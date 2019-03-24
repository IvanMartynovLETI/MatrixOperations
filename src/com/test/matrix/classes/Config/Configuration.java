package com.test.matrix.classes.Config;

import com.test.matrix.classes.generation.GenIntMatrixFromFile;
import com.test.matrix.classes.generation.GenRandIntMatrix;
import com.test.matrix.interfaces.GenerateMatrix;

import static java.lang.String.format;

public class Configuration {
    private String genPath;
    private String genUsed;
    private String dim;


    public String getGenPath() {
        return genPath;
    }

    public String getGenUsed() {
        return genUsed;
    }

    public String getDim() {
        return dim;
    }

    public void setGenPath(String genPath) {
        this.genPath = genPath;
    }

    public void setGenUsed(String genUsed) {
        this.genUsed = genUsed;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public GenerateMatrix getGenRef() {
        GenerateMatrix GMRef;
        switch (genUsed) {
            case "randGen":
                GMRef = new GenIntMatrixFromFile(this.getGenPath());
                return GMRef;
            case "fileGen":
                GMRef = new GenRandIntMatrix(this.checkInput(dim));
                return GMRef;
            default:
                throw new IllegalArgumentException("Invalid type of matrix generator");
        }
    }

    public int checkInput(String dim) {
        if (dim.equals("")) {
            throw new IllegalArgumentException("Empty dimension");
        }

        try {
            int i = Integer.parseInt(dim);
            if (i < 2 || i > 100) {
                throw new IllegalArgumentException("Dimension must be in range between 2 and 100");
            }
            return i;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Dimension must be an integer");
        }
    }

    @Override
    public String toString() {
        return format("Used generator: %s\n", genUsed) +
                (format("Path to matrix file: %s\n", genPath)) +
                format("dimension of random matrix %s\n", dim);
    }
}
