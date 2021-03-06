package com.test.matrix.classes.flip;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

public class FlipRelToMainDiag implements UserFlip {

    public <T>Matrix<T> flipMethod(Matrix<T> MRef)
    {
        final T[][] aNative = MRef.getNative();
        T[][] outputMatrix = (T[][]) new Object[aNative.length][aNative[0].length];

        for(int i = 0; i< aNative.length; i++)
            for(int j = 0; j< aNative[0].length; j++)
                outputMatrix[i][j]= aNative[j][i];

        return () -> outputMatrix;
    }

    public String getDescription(){
        return "Matrix<T> flipMethod(Matrix<T> MRef) method of FlipRelToMainDiag class returns reference to matrix,\n" +
                "flipped relative to main diagonal, input matrix must be square one\n";
    }
}

