package edu.austral.ingsis.clifford.results;

import edu.austral.ingsis.clifford.Node;

public interface CommandResult {
  String getMessage();

  Node getNode();
}
