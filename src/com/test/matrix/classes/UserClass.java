package com.test.matrix.classes;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class UserClass implements UserFlip {

    public Matrix flipMethod(Matrix MRef)
    {
        int[][] outputMatrix=new int[MRef.getNative().length][MRef.getNative()[0].length];

        final int[][] outputMatrix1 = outputMatrix;
        for(int i = 0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                outputMatrix1[i][j]=MRef.getNative()[i][j]+1;

            Matrix MR = new Matrix() {
                public int[][] getNative() {
                    return outputMatrix1;
                }
            };

        return MR;
    }

    public String getDescription()
    {
        return "Matrix flipMethod(Matrix MRef)method of UserClass class returns reference to matrix, \n" +
                "flipped by user-defined method, inputMatrix must be a square one\n";
    }
}

