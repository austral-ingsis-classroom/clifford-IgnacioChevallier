package edu.austral.ingsis.clifford.commands;
import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;
import edu.austral.ingsis.clifford.results.PwdResult;

public class Pwd implements Command {
    public String name = "pwd";
    @Override
    public CommandResult run(Node node) {
        return new PwdResult("/" + node.archive.getName(), node);
    }
}
