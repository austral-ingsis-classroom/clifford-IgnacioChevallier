package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Archive;
import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CdResult;
import edu.austral.ingsis.clifford.results.CommandResult;

import java.util.List;


public class Cd implements Command {
    public String directoryTo;
    public String name = "cd";

    public Cd(String directoryTo) {
        this.directoryTo = directoryTo;
    }

    @Override
    public CommandResult run(Node node) {
        if (directoryTo.equals("root")) {
            //return new CdResult("moved to directory '/'", archive.getParent());
        }
        Node newNode = findNode(node.getSubArchives(), directoryTo);
        return new CdResult("moved to directory '" + directoryTo + "'", newNode);
    }

    private Node findNode(List<Node> subArchives, String directoryTo) {
        for (Node node : subArchives) {
            if (node.archive.getName().equals(directoryTo)) {
                return node;
            }
        }
        return null;
    }
}
