package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipVertically implements UserFlip {
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
                outputMatrix[i][j]=MRef.getNative()[i][MRef.getNative()[0].length-1-j];

        return this.MR;
    }

    public String getDescription(){
        return "Matrix flipMethod(Matrix MRef) method of FlipVertically class returns reference to matrix,\n" +
                "flipped vertically, input matrix must be square one\n";
    }
}

