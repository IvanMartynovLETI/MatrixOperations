package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipRelToMainDiag implements UserFlip {
    //private int[][] outputMatrix;

    /*Matrix MR = new Matrix() {
        public int[][] getNative() {
            return outputMatrix;
        }
    };*/

    public Matrix flipMethod(Matrix MRef)
    {
        int[][] outputMatrix=new int[MRef.getNative().length][MRef.getNative()[0].length];

        for(int i=0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                outputMatrix[i][j]=MRef.getNative()[j][i];

            Matrix MR = new Matrix() {
              public int[][] getNative() {
                  return outputMatrix;
              }
            };

        return MR;
    }

    public String getDescription(){
        return "Matrix flipMethod(Matrix MRef) method of FlipRelToMainDiag class returns reference to matrix,\n" +
                "flipped relative to main diagonal, input matrix must be square one\n";
    }
}

