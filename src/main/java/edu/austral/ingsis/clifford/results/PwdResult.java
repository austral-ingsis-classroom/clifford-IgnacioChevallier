package edu.austral.ingsis.clifford.results;

import edu.austral.ingsis.clifford.Node;

public class PwdResult implements CommandResult {
  public String message;
  public Node node;

  public PwdResult(String message, Node node) {
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
