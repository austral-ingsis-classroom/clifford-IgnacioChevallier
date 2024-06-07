package edu.austral.ingsis;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.MySimpleFileSystem;
import java.util.ArrayList;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner {
  @Override
  public List<String> executeCommands(List<String> commands) {
    FileSystem fileSystem = new MySimpleFileSystem();
    List<String> results = new ArrayList<>();
    for (String command : commands) {
      String message = fileSystem.run(command);
      results.add(message);
    }
    return results;
  }
}
