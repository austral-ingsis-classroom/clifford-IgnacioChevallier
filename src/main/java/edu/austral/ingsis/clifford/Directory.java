package edu.austral.ingsis.clifford;

public class Directory implements Archive {

  public String name;
  public String path;

  public Directory(String name, String path) {
    this.name = name;
    this.path = path;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return path;
  }
}
