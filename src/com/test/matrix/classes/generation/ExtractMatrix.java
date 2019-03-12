package com.test.matrix.classes.generation;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtractMatrix implements GenerateMatrix {
    private Scanner StrScanner;

    public ExtractMatrix(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        StrScanner = new Scanner(path);
    }

    public ExtractMatrix(Path path) throws IOException {
        StrScanner = new Scanner(path);
    }

    public Matrix generateMatrix() throws IllegalArgumentException {
        ArrayList<String> list = new ArrayList<String>();

        while(StrScanner.hasNextLine())
            list.add(StrScanner.nextLine());

        StrScanner.close();
        int dimY = list.size();
        Scanner ElemsScanner;

        int[][] array = new int[dimY][dimY];

        for(int i = 0; i < dimY; i ++)
        {
            ElemsScanner = new Scanner(list.get(i));
            int j = 0;
            for(; ElemsScanner.hasNextInt(); j ++)
            {
                array[i][j] = ElemsScanner.nextInt();

            }

            ElemsScanner.close();

            if(j != dimY)
                throw new IllegalArgumentException("matrix in file is not square");
        }

        Matrix MR = new Matrix() {
            public int[][] getNative() {
                return array;
            }
        };

        return MR;
    }

    public String getDescription() {
        return "Matrix generateMatrix() method of ExtractMatrix class\n" +
                "extracts matrix from specified txt file,\n" +
                "matrix in file should be square one";
    }
}
//