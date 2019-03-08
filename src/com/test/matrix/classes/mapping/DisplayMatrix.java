package com.test.matrix.classes.mapping;

import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.ShowMatrix;

public class DisplayMatrix implements ShowMatrix{


    public void displayMatrix(Matrix MRef)
    {
        int[][] m = MRef.getNative();
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
                System.out.print(m[i][j]+"\t");
            System.out.println("");
        }
        System.out.println("");
    }

    public String getDescription(){
        return "void displayMatrix(Matrix MRef) method of DisplayMatrix class\n" +
                "shows matrix on display.\n";
    }
}

