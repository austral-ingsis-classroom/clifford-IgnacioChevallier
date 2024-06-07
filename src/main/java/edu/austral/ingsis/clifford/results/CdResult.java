package edu.austral.ingsis.clifford.results;

import edu.austral.ingsis.clifford.Node;

public class CdResult implements CommandResult {

  public final String message;
  public final Node node;

  public CdResult(String message, Node node) {
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
