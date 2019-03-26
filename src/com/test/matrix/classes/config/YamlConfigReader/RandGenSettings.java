package com.test.Config.YamlConfigReader;

public class RandGenSettings {
    public String randMatrixDim;

    public String getRandMatrixDim() {
        return randMatrixDim;
    }

    public void setRandMatrixDim(String randMatrixDim) {
        this.randMatrixDim = randMatrixDim;
    }

    @Override
    public String toString() {
        return getRandMatrixDim();
    }
}
