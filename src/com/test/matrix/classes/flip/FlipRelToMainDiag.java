package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.UserFlip;

public class FlipRelToMainDiag implements UserFlip {

    public int[][] flipMethod(int[][] inputMatrix) {
        //flips matrix previously generated relative to main diagonal
        int[][] outputMatrix = new int[inputMatrix.length][inputMatrix[0].length];

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++)
                outputMatrix[i][j] = inputMatrix[j][i];
        }
        return outputMatrix;
    }

    public String getDescription() {
        String s1, s2, s3, s4;
        s1 = "int[][] flipMethod(int[][] inputMatrix) method \nof FlipRelToMainDiag class returns matrix, \n";
        s2 = "flipped relative to main diagonal of matrix inputMatrix. \n";
        s3 = "inputMatrix must be a square matrix \n";
        s4 = s1 + s2 + s3;
        return s4;
    }
}
