package com.test.MatrixPackage;

import com.test.UserPackage.UserFlip;

public class FlipVertically implements UserFlip {
    public int[][] flipMethod(int[][] m)
    {
        //flips matrix previously generated vertically
        int[][] resultMatrix=new int[m.length][m[0].length];
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
                resultMatrix[i][j]=m[i][m[0].length-1-j];
        }
        return resultMatrix;
    }
}
