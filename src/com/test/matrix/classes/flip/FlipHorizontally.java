package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipHorizontally implements UserFlip {

    public Matrix flipMethod(Matrix MRef)
    {
        int[][] outputMatrix=new int[MRef.getNative().length][MRef.getNative()[0].length];

        for(int i=0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                outputMatrix[i][j]=MRef.getNative()[MRef.getNative().length-1-i][j];

            Matrix MR = new Matrix() {
                public int[][] getNative() {
                    return outputMatrix;
                }
            };

        return MR;
    }

    public String getDescription(){
        return "Matrix flipMethod(Matrix MRef) method of FlipHorizontally class returns reference to matrix,\n" +
                "flipped horizontally, input matrix must be square one\n";
    }

}

