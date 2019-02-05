package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.UserFlip;

public class FlipVertically implements UserFlip {

    public int[][] flipMethod(int[][] m) {
        //flips matrix previously generated vertically
        int[][] resultMatrix = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                resultMatrix[i][j] = m[i][m[0].length - 1 - j];
        }
        return resultMatrix;
    }

    public String getDescription() {
        String s1, s2, s3;
        s1 = "int[][] flipMethod(int[][] inputMatrix) method of FlipVertically class returns matrix, \n";
        s2 = "flipped vertically, inputMatrix must be a square matrix \n";
        s3 = s1 + s2;
        return s3;
    }
}
