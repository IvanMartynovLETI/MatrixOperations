package com.test.matrix.classes;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class UserClass implements UserFlip {
    private int[][] outputMatrix;

    Matrix MR = new Matrix() {
        public int[][] getNative() {
            return outputMatrix;
        }
    };

    public Matrix flipMethod(Matrix MRef)
    {
        outputMatrix=new int[MRef.getNative().length][MRef.getNative()[0].length];

        for(int i=0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                outputMatrix[i][j]=MRef.getNative()[i][j]+1;

        return this.MR;
    }

    public String getDescription()
    {
        return "Matrix flipMethod(Matrix MRef)method of UserClass class returns reference to matrix, \n" +
                "flipped by user-defined method, inputMatrix must be a square one\n";
    }
}

