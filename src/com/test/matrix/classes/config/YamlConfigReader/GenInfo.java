package com.test.Config.YamlConfigReader;

public class GenInfo {
    public String genUsed;

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
