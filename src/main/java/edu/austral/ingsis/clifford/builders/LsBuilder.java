package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.commands.Ls;

public class LsBuilder implements CommandBuilder {
  @Override
  public Command build(String cLine) {
    if (cLine.contains("--ord=asc")) {
      return new Ls("ASC");
    } else if (cLine.contains("--ord=desc")) {
      return new Ls("DESC");
    } else {
      return new Ls();
    }
  }
}
