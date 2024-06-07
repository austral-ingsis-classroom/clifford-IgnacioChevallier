package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

public class Node {
  public List<Node> subArchives;
  public Node parentNode;
  public Archive archive = new Directory("root", "/");

  public Node(Node parentNode, List<Node> archives) {
    this.parentNode = parentNode;
    this.subArchives = archives;
  }

  public Node(Node parentNode, List<Node> archives, Archive archive) {
    this.parentNode = parentNode;
    this.subArchives = archives;
    this.archive = archive;
  }

  public Node getParentNode() {
    return parentNode;
  }

  public List<Node> getSubArchives() {
    return subArchives;
  }

  public void addArchive(Archive archive) {
    Node node = new Node(this, new ArrayList<>(), archive);
    subArchives.add(node);
  }

  public void removeArchive(Archive archive) {
    subArchives.removeIf(node -> node.archive.getName().equals(archive.getName()));
  }
}
