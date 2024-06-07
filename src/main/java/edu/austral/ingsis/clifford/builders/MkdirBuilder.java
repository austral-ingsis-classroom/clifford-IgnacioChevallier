package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.commands.Mkdir;

public class MkdirBuilder implements CommandBuilder {
  @Override
  public Command build(String command) {
    String directoryName = command.split(" ")[0];
    String message = ("'" + directoryName + "' directory created");
    Directory newDir = new Directory(directoryName, "");
    return new Mkdir(message, newDir);
  }
}
