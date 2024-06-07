package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;
import edu.austral.ingsis.clifford.results.MkdirResult;

public class Mkdir implements Command {
  public String name = "mkdir";
  public String message;
  public Directory newDir;

  public Mkdir(String message, Directory dir) {
    this.message = message;
    this.newDir = dir;
  }

  @Override
  public CommandResult run(Node node) {
    newDir.path = node.archive.getPath() + "/" + newDir.getName();
    node.addArchive(newDir);
    return new MkdirResult(message);
  }
}
