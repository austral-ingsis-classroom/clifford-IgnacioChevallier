package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Archive;
import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.File;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;
import edu.austral.ingsis.clifford.results.TouchResult;

public class Touch implements Command {
    public final String message;
    public final File newFile;
    public String name = "touch";

    public Touch(String message, File newFile) {
        this.message = message;
        this.newFile = newFile;
    }

    @Override
    public CommandResult run(Node node) {
        node.addArchive(newFile);
        return new TouchResult(message);
    }
}
