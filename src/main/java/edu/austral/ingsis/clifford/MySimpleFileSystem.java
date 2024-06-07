package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.builders.*;
import edu.austral.ingsis.clifford.results.CommandResult;
import java.util.*;

public class MySimpleFileSystem implements FileSystem {
  Map<String, CommandBuilder> commands = new HashMap<String, CommandBuilder>();
  Node root;
  Node current;

  public MySimpleFileSystem() {
    this.commands = getImplementedCommands();
    this.root = new Node(null, new ArrayList<>(), new Directory("root", "/"));
    this.current = root;
  }

  @Override
  public String run(String parameters) {
    List<String> list = List.of(parameters.split(" "));

    Command command = null;
    String commandName = list.getFirst();
    String rest = getRestOfCommand(list);
    if (commands.containsKey(commandName)) {
      command = commands.get(commandName).build(rest);
    } else {
      System.out.println(commandName + ": command not found");
      return "Command not found";
    }
    CommandResult result = command.run(current);
    if (result.getNode() != current && result.getNode() != null) {
      current = result.getNode();
    }
    return result.getMessage();
  }

  private String getRestOfCommand(List<String> list) {
    StringBuilder rest = new StringBuilder();
    for (int i = 1; i < list.size(); i++) {
      rest.append(list.get(i));
      rest.append(" ");
    }
    return rest.toString();
  }

  @Override
  public void addCommand(String name, CommandBuilder builder) {
    commands.put(name, builder);
  }

  @Override
  public void removeCommand(String commandName) {
    commands.remove(commandName);
  }

  @Override
  public List<String> getCommands() {
    return List.of(commands.keySet().toArray(new String[0]));
  }

  public Map<String, CommandBuilder> getImplementedCommands() {
    Map<String, CommandBuilder> result = new HashMap<>();
    result.put("cd", new CdBuilder());
    result.put("ls", new LsBuilder());
    result.put("mkdir", new MkdirBuilder());
    result.put("pwd", new PwdBuilder());
    result.put("rm", new RmBuilder());
    result.put("touch", new TouchBuilder());
    return result;
  }
}
