package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CdResult;
import edu.austral.ingsis.clifford.results.CommandResult;
import java.util.List;

public class Cd implements Command {
  public boolean multiParam;
  public String directoryTo;
  public String name = "cd";

  public Cd(String directoryTo, Boolean multiParam) {
    this.directoryTo = directoryTo;
    this.multiParam = multiParam;
  }

  @Override
  public CommandResult run(Node node) {
    if (directoryTo.equals("root")) {
      Node root = getNodeTilRoot(node);
      return new CdResult("moved to directory '/'", root);
    }
    if (directoryTo.equals("parent")) {
      Node parent = node.getParentNode();
      if (parent == null) {
        return new CdResult("moved to directory '/'", node);
      }
      return new CdResult("moved to directory " + "'" + parent.archive.getPath() + "'", parent);
    }
    if (multiParam) {
      return runMultiParam(node);
    }
    Node newNode = findNode(node.getSubArchives(), directoryTo);
    if (newNode == null) {
      return new CdResult("'" + directoryTo + "'" + " directory does not exist", node);
    }
    return new CdResult("moved to directory '" + directoryTo + "'", newNode);
  }

  private CommandResult runMultiParam(Node node) {
    List<String> directories = List.of(directoryTo.split("/"));
    for (String dir : directories) {
      Node newNode = findNode(node.getSubArchives(), dir);
      if (newNode == null) {
        return new CdResult("directory '" + dir + "' not found", node);
      }
      node = newNode;
    }
    return new CdResult("moved to directory '" + directories.getLast() + "'", node);
  }

  private Node findNode(List<Node> subArchives, String directoryTo) {
    for (Node node : subArchives) {
      if (node.archive.getName().equals(directoryTo)) {
        return node;
      }
    }
    return null;
  }

  private Node getNodeTilRoot(Node node) {
    if (node.getParentNode() == null) {
      return node;
    }
    return getNodeTilRoot(node.getParentNode());
  }
}
