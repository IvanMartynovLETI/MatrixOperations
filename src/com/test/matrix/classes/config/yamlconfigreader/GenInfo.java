package com.test.matrix.classes.config.yamlconfigreader;

public class GenInfo {
    private String genUsed;

    public String getGenUsed() {
        return genUsed;
    }

    public void setGenUsed(String genUsed) {
        this.genUsed = genUsed;
    }

    @Override
    public String toString() {
        return getGenUsed();
    }
}

