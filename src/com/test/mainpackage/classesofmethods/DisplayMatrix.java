package com.test.mainpackage.classesofmethods;

import com.test.mainpackage.interfacesofmethods.ShowMatrix;

public class DisplayMatrix implements ShowMatrix {
    public void displayMatrix(int m[][])
    {
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
                System.out.print(m[i][j]+"\t");
            System.out.println("");
        }
        System.out.println("");
    }
}
