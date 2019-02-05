package com.test.matrix.classes.generation;

import com.test.matrix.interfaces.GenerateMatrix;

public class GenerateRandomMatrix implements GenerateMatrix {

    public int[][] generateMatrix(int dim) {
        boolean generationOK = true;
        int dimension = 0;
        int[][] randMatrix;

        if (dim < 0) {
            System.out.println("Input parameter for generateMatrix() method is integer, but not positive. Random matrix has not been created.");
            System.out.println("Abnormal program termination");
            generationOK = false;
            dimension = 2;
        } else if (dim == 0) {
            System.out.println("Input parameter for generateMatrix() is 0. Random matrix has not been created");
            System.out.println("Abnormal program termination");
            generationOK = false;
            dimension = 2;
        } else if (dim == 1) {
            System.out.println("Input parameter for generateMatrix() is 1. Random matrix has not been created.");
            System.out.println("Abnormal program termination");
            generationOK = false;
            dimension = 2;
        } else if (dim < 0) {
            System.out.println("Input parameter for generateMatrix() is negative integer. Random matrix has not been created");
            System.out.println("Abnormal program termination");
            generationOK = false;
            dimension = 2;
        } else
            dimension = dim;


        randMatrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++) {
                if (generationOK)
                    randMatrix[i][j] = (int) (Math.random() * 100);
                else
                    randMatrix[i][j] = 0;
            }
        return randMatrix;
    }

    public String getDescription() {
        String s1, s2, s3;
        s1 = "int[][] generateMatrix(int dim) of GenerateRandomMatrix class \ncreates square random matrix dimension of dim, \n";
        s2 = "dim parameter must be positive integer greater than 1. \n";
        s3 = s1 + s2;
        return s3;

    }
}
