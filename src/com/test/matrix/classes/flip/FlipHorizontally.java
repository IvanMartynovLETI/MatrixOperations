package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.UserFlip;

public class FlipHorizontally implements UserFlip {

    public int[][] flipMethod (int[][] inputMatrix)
    {
        //flips matrix previously generated horizontally
        int[][] outputMatrix = new int[inputMatrix.length][inputMatrix[0].length];

        for (int i = 0; i < inputMatrix.length; i ++)
        {
            for (int j = 0; j < inputMatrix[0].length; j ++)
                outputMatrix[i][j] = inputMatrix[inputMatrix.length - 1 - i][j];
        }
        return outputMatrix;
    }
}
