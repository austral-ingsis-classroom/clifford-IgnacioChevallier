package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.commands.Cd;

import java.util.List;

public class CdBuilder implements CommandBuilder{
    @Override
    public Command build(String command) {
        List<String> commandParts = List.of(command.split("/"));
        if (command.contains("..") || command.contains("/")) {
            return new Cd("root");
        }
        if (commandParts.size() == 1) {
            return new Cd(commandParts.getFirst().trim());
        }
        return new Cd(command);
    }
}
