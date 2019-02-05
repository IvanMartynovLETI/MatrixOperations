package com.test.matrix.classes.mapping;

import com.test.matrix.interfaces.ShowMatrix;

public class DisplayMatrix implements ShowMatrix {

    public void displayMatrix(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.print(m[i][j] + "\t");
            System.out.println("");
        }
        System.out.println("");
    }

    public String getDescription() {
        String s1;
        s1 = "void displayMatrix(int m[][]) method of DisplayMatrix class \nshows matrix m on display. \n";
        return s1;
    }
}
