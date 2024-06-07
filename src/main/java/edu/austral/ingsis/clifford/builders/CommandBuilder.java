package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;

public interface CommandBuilder {
  public Command build(String command);
}
