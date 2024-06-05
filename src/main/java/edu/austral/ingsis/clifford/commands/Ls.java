package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Archive;
import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;
import edu.austral.ingsis.clifford.results.LsResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Ls implements Command {
    public String order = "";

    public Ls() {
    }

    public Ls(String order) {
        this.order = order;
    }

    @Override
    public CommandResult run(Node node) {
        List<String> archivesName = getArchivesNames(node.getSubArchives());
        if (Objects.equals(order, "ASC")) {
            return new LsResult(getAscendingOrder(archivesName), node);
        } else if (Objects.equals(order, "DESC")) {
            return new LsResult(getDescendingOrder(archivesName), node);
        }
        return new LsResult(buildMessage(archivesName), node);
    }

    private String getDescendingOrder(List<String> archivesName) {
        archivesName.sort(String::compareTo);
        List<String> descendingOrder = new ArrayList<>();
        for (int i = archivesName.size() - 1; i >= 0; i--) {
            descendingOrder.add(archivesName.get(i));
        }
        return buildMessage(descendingOrder);
    }

    private String getAscendingOrder(List<String> subArchives) {
        subArchives.sort(String::compareTo);
        return buildMessage(subArchives);
    }

    private String buildMessage(List<String> subArchives) {
        StringBuilder message = new StringBuilder();
        if (subArchives == null) { return ""; }
        if (subArchives.size() == 1) { return message.append(subArchives.getFirst()).toString(); }
        for (String name : subArchives) {
            message.append(name).append(" ");
        }
        return message.toString().trim();
    }

    private List<String> getArchivesNames(List<Node> subArchives) {
        List<String> archivesName = new ArrayList<>();
        for (Node node : subArchives) {
            archivesName.add(node.archive.getName());
        }
        return archivesName;
    }
}
