package edu.austral.ingsis.clifford.results;

import edu.austral.ingsis.clifford.Node;

public class TouchResult implements CommandResult {
  private final String message;

  public TouchResult(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public Node getNode() {
    return null;
  }
}
