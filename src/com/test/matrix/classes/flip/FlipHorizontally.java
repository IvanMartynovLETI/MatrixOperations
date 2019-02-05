package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.UserFlip;

public class FlipHorizontally implements UserFlip {

    public int[][] flipMethod(int[][] inputMatrix) {
        //flips matrix previously generated horizontally
        int[][] outputMatrix = new int[inputMatrix.length][inputMatrix[0].length];

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++)
                outputMatrix[i][j] = inputMatrix[inputMatrix.length - 1 - i][j];
        }
        return outputMatrix;
    }

    public String getDescription() {
        String s1, s2, s3;
        s1 = "int[][] flipMethod(int[][] inputMatrix) method of FlipHorizontally class returns matrix, \n";
        s2 = "flipped horizontally, inputMatrix must be a square matrix \n";
        s3 = s1 + s2;
        return s3;
    }
}
