package com.test.matrix.classes.generation;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;
import java.util.Random;

public class GenRandIntMatrix implements GenerateMatrix {
    private int dim;

    public GenRandIntMatrix(int i) throws IllegalArgumentException {
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

    public Matrix<Integer> generateMatrix() {
        Integer[][] randMatrix = new Integer[dim][dim];
        final Random random = new Random();

        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++) {
                randMatrix[i][j] = random.nextInt(100);
            }

        return () -> randMatrix;
    }

    public String getDescription() {
        return "Matrix generateMatrix(int dim) method of GenerateRandomMatrix class\n" +
                "creates square random matrix dimension of dim,\n" +
                "dim parameter must be positive integer greater than 1.";
    }


}
