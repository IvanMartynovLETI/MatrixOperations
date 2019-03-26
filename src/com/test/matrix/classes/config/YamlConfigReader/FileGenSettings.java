package com.test.Config.YamlConfigReader;

public class FileGenSettings {
    public String pathToMatrixFile;

    public String getPathToMatrixFile() {
        return pathToMatrixFile;
    }

    public void setPathToMatrixFile(String pathToMatrixFile) {
        this.pathToMatrixFile = pathToMatrixFile;
    }

    @Override
    public String toString() {
        return getPathToMatrixFile();
    }
}
