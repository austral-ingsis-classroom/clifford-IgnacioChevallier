package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.commands.Cd;
import java.util.List;

public class CdBuilder implements CommandBuilder {
  @Override
  public Command build(String command) {
    command = command.trim();
    if (command.equals("/")) {
      return new Cd("root", false);
    }
    List<String> commandParts = List.of(command.split("/"));
    if (command.contains("..")) {
      return new Cd("parent", false);
    }
    if (commandParts.size() == 1) {
      return new Cd(command, false);
    } else if (commandParts.size() > 1) {
      return new Cd(command, true);
    }
    return new Cd(command, false);
  }
}
