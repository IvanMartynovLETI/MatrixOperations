package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipHorizontally<T> implements UserFlip<T>{



    public Matrix<T> flipMethod(Matrix<T> MRef)
    {
        final T[][] outputMatrix = (T[][]) new Object[MRef.getNative().length][MRef.getNative()[0].length];

        for(int i=0; i<MRef.getNative().length; i++)
            for(int j=0; j<MRef.getNative()[0].length; j++)
                outputMatrix[i][j]=MRef.getNative()[MRef.getNative().length-1-i][j];

        return () -> outputMatrix;
    }
    public String getDescription(){
        return "Matrix<T> flipMethod(Matrix<T> MRef) method of FlipHorizontally class returns reference to matrix,\n" +
                "flipped horizontally, input matrix must be square one\n";
    }

}

