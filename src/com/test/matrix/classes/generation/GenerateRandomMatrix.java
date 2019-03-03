package com.test.matrix.classes.generation;

import com.test.matrix.interfaces.GenerateMatrix;

public class GenerateRandomMatrix implements GenerateMatrix {
    private int dim = 0;
    private int[][] randMatrix;

    public GenerateRandomMatrix(int i) throws IllegalArgumentException {
        if (i == 0) {
            throw new IllegalArgumentException("Empty array, constructor of GenerateRandomMatrix class failed");
        } else if (i < 0) {
            throw new IllegalArgumentException("Dimension must be positive, " +
                    " constructor of GenerateRandomMatrix class failed");
        } else if (i < 2 || i > 100) {
            throw new IllegalArgumentException("Dimension must be in range from 2 to 100, " +
                    "constructor of GenerateRandomMatrix class failed");
        } else {
            dim = i;
        }
    }

    public int[][] generateMatrix() {
        randMatrix = new int[dim][dim];

        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++) {
                    randMatrix[i][j] = (int) (Math.random() * 100);
            }
        return randMatrix;
    }

    public int[][] getMatrix() {
        return randMatrix;
    }

    public String getDescription() {
        return "int[][] generateMatrix(int dim) method of GenerateRandomMatrix class\n" +
                "creates square random matrix dimension of dim,\n" +
                "dim parameter must be positive integer greater than 1.";
    }


}