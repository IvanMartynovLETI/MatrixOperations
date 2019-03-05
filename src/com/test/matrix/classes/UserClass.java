package com.test.matrix.classes;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class UserClass implements UserFlip, Matrix {
    private int[][] mr;

    public Matrix flipMethod(Matrix MRef)
    {
        mr=new int[MRef.getNative().length][MRef.getNative()[0].length];

        for(int i=0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                mr[i][j]=MRef.getNative()[i][j]+1;

        Matrix MRefOut = this;
        return MRefOut;
    }

    public int[][] getNative() {return mr;}

    public String getDescription()
    {
        return "Matrix flipMethod(Matrix MRef)method of UserClass class returns reference to matrix, \n" +
                "flipped by user-defined method, inputMatrix must be a square one\n";
    }
}

