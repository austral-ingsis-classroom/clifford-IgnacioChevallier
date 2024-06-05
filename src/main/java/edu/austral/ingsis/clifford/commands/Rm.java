package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Archive;
import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;

public class Rm implements Command {
    public String name = "rm";
    @Override
    public CommandResult run(Node node) {
        return null;
    }
}
