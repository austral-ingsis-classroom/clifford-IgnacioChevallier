package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;
import edu.austral.ingsis.clifford.results.PwdResult;
import java.util.ArrayList;
import java.util.List;

public class Pwd implements Command {
  public String name = "pwd";

  @Override
  public CommandResult run(Node node) {
    List<Node> nodes = getNodesTilParent(node, new ArrayList<>());
    String path = generatePath(nodes);
    return new PwdResult(path, node);
  }

  private String generatePath(List<Node> nodes) {
    StringBuilder path = new StringBuilder();
    for (int i = nodes.size() - 1; i >= 0; i--) {
      path.append("/");
      path.append(nodes.get(i).archive.getName());
    }
    return path.toString();
  }

  private List<Node> getNodesTilParent(Node node, List<Node> nodes) {
    if (node.getParentNode() == null) {
      return nodes;
    }
    nodes.add(node);
    return getNodesTilParent(node.getParentNode(), nodes);
  }
}
