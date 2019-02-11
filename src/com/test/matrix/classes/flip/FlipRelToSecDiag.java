package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.UserFlip;

public class FlipRelToSecDiag implements UserFlip {

    public int[][] flipMethod(int[][] inputMatrix) {
        //flip matrix previously generated relative to secondary diagonal
        int[][] outputMatrix = new int[inputMatrix.length][inputMatrix[0].length];

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++)
                outputMatrix[i][j] = inputMatrix[inputMatrix[0].length - 1 - j][inputMatrix.length - 1 - i];
        }
        return outputMatrix;
    }

    public String getDescription() {
        return "int[][] flipMethod(int[][] inputMatrix) method \nof FlipRelToSecDiag class returns matrix, \n" +
                "flipped relative to secondary diagonal of matrix inputMatrix. \n" +
                "inputMatrix must be a square matrix \n";
    }
}
