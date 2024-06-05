package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.commands.Pwd;

public class PwdBuilder implements CommandBuilder {
    @Override
    public Command build(String command) {
        return new Pwd();
    }
}
