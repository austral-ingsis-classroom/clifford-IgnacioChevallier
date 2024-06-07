package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.builders.CommandBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FileSystem {
  public String name = "";
  public String path = "";
  public String creator = "";

  public String run(String parameters);

  public void addCommand(String name, CommandBuilder commandBuilder);

  public void removeCommand(String commandName);

  public List<String> getCommands();

  public Map<String, CommandBuilder> commands = new HashMap<String, CommandBuilder>();
}
