package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipRelToSecDiag<T> implements UserFlip<T> {

    public Matrix<T> flipMethod(Matrix<T> MRef)
    {
        final T[][] outputMatrix = (T[][]) new Object[MRef.getNative().length][MRef.getNative()[0].length];

        for(int i=0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                outputMatrix[i][j]=MRef.getNative()[MRef.getNative()[0].length-1-j][MRef.getNative().length-1-i];

        return () -> outputMatrix;
    }

    public String getDescription(){
        return "Matrix<T> flipMethod(Matrix<T> MRef) method of FlipRelToSecDiag class returns reference to matrix,\n" +
                "flipped relative to secondary diagonal, input matrix must be square one\n";
    }
}

