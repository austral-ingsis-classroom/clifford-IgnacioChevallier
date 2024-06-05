package edu.austral.ingsis.clifford.results;

import edu.austral.ingsis.clifford.Node;

public class RmResult implements CommandResult {
    private final String message;
    private final Node node;

    public RmResult(String message, Node node) {
        this.message = message;
        this.node = node;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Node getNode() {
        return node;
    }
}
