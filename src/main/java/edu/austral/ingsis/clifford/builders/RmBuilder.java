package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.commands.Rm;
import java.util.List;
import java.util.Objects;

public class RmBuilder implements CommandBuilder {
  @Override
  public Command build(String command) {
    List<String> list = List.of(command.split(" "));
    String isRecursive = list.getFirst();
    if (Objects.equals(isRecursive, "--recursive")) {
      return new Rm(true, list.get(1));
    }
    return new Rm(false, list.get(0));
  }
}
