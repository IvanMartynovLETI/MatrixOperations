package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipHorizontally implements UserFlip{

    public <T>Matrix<T> flipMethod(Matrix<T> MRef)
    {
        final T[][] aNative = MRef.getNative();
        T[][] outputMatrix = (T[][]) new Object[aNative.length][aNative[0].length];

        for(int i = 0; i< aNative.length; i++)
            System.arraycopy(aNative[aNative.length - 1 - i], 0, outputMatrix[i], 0, aNative[0].length);

        return () -> outputMatrix;
    }
    public String getDescription(){
        return "Matrix<T> flipMethod(Matrix<T> MRef) method of FlipHorizontally class returns reference to matrix,\n" +
                "flipped horizontally, input matrix must be square one\n";
    }

}

