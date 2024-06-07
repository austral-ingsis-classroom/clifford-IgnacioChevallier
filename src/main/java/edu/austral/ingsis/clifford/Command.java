package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.results.CommandResult;

public interface Command {
  public CommandResult run(Node node);
}
