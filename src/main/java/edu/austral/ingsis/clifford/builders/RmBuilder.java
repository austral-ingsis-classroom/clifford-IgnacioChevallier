package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.commands.Rm;

public class RmBuilder implements CommandBuilder {
    @Override
    public Command build(String command) {
        if (command.contains("--recursive")) {
            return new Rm(true);
        }
        return new Rm(false);
    }
}
