package com.test.matrix.classes.config.yamlconfigreader;

public class FileGenSettings {
    private String pathToMatrixFile;

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
