package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.File;
import edu.austral.ingsis.clifford.commands.Touch;

public class TouchBuilder implements CommandBuilder {
  @Override
  public Command build(String command) {
    String fileName = command.trim();
    String message = "'" + fileName + "' file created";
    File newFile = new File(fileName);
    return new Touch(message, newFile);
  }

  // Strip extension .txt .exe .java
  private String getFileName(String command) {
    String[] commandParts = command.split(" ");
    return commandParts[0].split("\\.")[0];
  }
}
