package edu.austral.ingsis.clifford;

public class File implements Archive {
    public final String name;

    public File(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return "";
    }
}
