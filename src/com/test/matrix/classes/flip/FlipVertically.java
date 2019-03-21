package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipVertically implements UserFlip {

    public <T>Matrix<T> flipMethod(Matrix<T> MRef)
    {
        final T[][] aNative = MRef.getNative();
        T[][] outputMatrix = (T[][]) new Object[aNative.length][aNative[0].length];

        for(int i = 0; i< aNative.length; i++)
            for(int j = 0; j< aNative[0].length; j++)
                outputMatrix[i][j]= aNative[i][aNative[0].length-1-j];

        return () -> outputMatrix;
    }

    public String getDescription(){
        return "Matrix<T> flipMethod(Matrix<T> MRef) method of FlipVertically class returns reference to matrix,\n" +
                "flipped vertically, input matrix must be square one\n";
    }
}

