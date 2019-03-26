package com.test.matrix.classes.config.yamlconfigreader;

public class RandGenSettings {
    private String randMatrixDim;

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
