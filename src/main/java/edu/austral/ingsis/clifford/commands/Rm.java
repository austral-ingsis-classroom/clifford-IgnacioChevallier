package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;
import edu.austral.ingsis.clifford.results.RmResult;

import java.util.List;

public class Rm implements Command {
    public String name = "rm";
    public boolean isRecursive;

    public Rm(boolean b) {
        this.isRecursive = b;
    }

    @Override
    public CommandResult run(Node node) {
        if (!isRecursive && node.archive instanceof Directory) {
            return new RmResult("cannot remove '" + node.archive.getName() + "', is a directory", node);
        } else {
            String removed = node.archive.getName();
            removeSubDirectory(removed, node);
            return new RmResult("'" + removed + "' removed", node);
        }
    }

    private void removeSubDirectory(String removed, Node node) {
        List<Node> subArchives = node.getSubArchives();
        for (Node subArchive : subArchives) {
            if (subArchive.archive.getName().equals(removed)) {
                node.removeArchive(subArchive.archive);
            }
        }
    }
}
