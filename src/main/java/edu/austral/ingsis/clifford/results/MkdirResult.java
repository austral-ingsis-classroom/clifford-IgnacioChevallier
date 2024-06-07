package edu.austral.ingsis.clifford.results;

import edu.austral.ingsis.clifford.Node;

public class MkdirResult implements CommandResult {
  public String message;

  public MkdirResult(String message) {
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
