package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Archive;
import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.results.CommandResult;
import edu.austral.ingsis.clifford.results.RmResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Rm implements Command {
  private final String remove;
  public String name = "rm";
  public boolean isRecursive;

  public Rm(boolean b, String remove) {
    this.isRecursive = b;
    this.remove = remove;
  }

  @Override
  public CommandResult run(Node node) {
    Archive archive = getArchive(node, remove);
    if (Objects.equals(remove, "")) { // Si el rm viene solo agarro el primer sub archive
      Archive firstSubArchive = getFirstSubArchive(node);
      if (firstSubArchive instanceof Directory) {
        return new RmResult(
            "cannot remove '" + firstSubArchive.getName() + "', is a directory", node);
      }
    }
    if (!isRecursive && archive instanceof Directory) {
      return new RmResult("cannot remove '" + archive.getName() + "', is a directory", node);
    } else {
      removeSubDirectory(archive, node);
      return new RmResult("'" + remove + "' removed", node);
    }
  }

  private Archive getFirstSubArchive(Node node) {
    List<String> subArchives = getArchivesNames(node.getSubArchives());
    sort(subArchives);
    return getArchive(node, subArchives.getFirst());
  }

  private List<String> getArchivesNames(List<Node> subArchives) {
    List<String> archivesName = new ArrayList<>();
    for (Node node : subArchives) {
      archivesName.add(node.archive.getName());
    }
    return archivesName;
  }

  private void sort(List<String> subArchives) {
    subArchives.sort(
        (s1, s2) -> {
          boolean s1IsFile = s1.contains(".");
          boolean s2IsFile = s2.contains(".");
          if (s1IsFile && !s2IsFile) {
            return 1;
          } else if (!s1IsFile && s2IsFile) {
            return -1;
          } else {
            return s1.compareTo(s2);
          }
        });
  }

  private Archive getArchive(Node node, String remove) {
    List<Node> subArchives = node.getSubArchives();
    Iterator<Node> iterator = subArchives.iterator();
    while (iterator.hasNext()) {
      Node next = iterator.next();
      if (next.archive.getName().equals(remove)) {
        return next.archive;
      }
    }
    return null;
  }

  private void removeSubDirectory(Archive archive, Node node) {
    List<Node> subArchives = node.getSubArchives();
    subArchives.removeIf(subArchive -> subArchive.archive.equals(archive));
  }
}
