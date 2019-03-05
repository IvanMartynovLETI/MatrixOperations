package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipVertically implements UserFlip, Matrix {
    private int[][] outputMatrix;

    public Matrix flipMethod(Matrix MRef)
    {
        outputMatrix=new int[MRef.getNative().length][MRef.getNative()[0].length];

        for(int i=0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                outputMatrix[i][j]=MRef.getNative()[i][MRef.getNative()[0].length-1-j];

        Matrix MRefOut = this;
        return MRefOut;
    }

    public int[][] getNative() {return outputMatrix;}

    public String getDescription(){
        return "Matrix flipMethod(Matrix MRef) method of FlipVertically class returns reference to matrix,\n" +
                "flipped vertically, input matrix must be square one\n";
    }
}

