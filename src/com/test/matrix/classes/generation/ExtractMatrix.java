package com.test.matrix.classes.generation;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtractMatrix implements GenerateMatrix {
    private Path path;

    public ExtractMatrix(String filePath) {
        path = Paths.get(filePath);
    }

    public ExtractMatrix(Path pathToFile) {
        path = pathToFile;
    }

    public Matrix generateMatrix() {
        Scanner strScanner = null;
        Scanner elemsScanner = null;

        try {
            ArrayList<String> list = new ArrayList<>();
            strScanner = new Scanner(path);

            while (strScanner.hasNextLine())
                list.add(strScanner.nextLine());

            int dimY = list.size();
            int[][] array = new int[dimY][dimY];

            for (int i = 0; i < dimY; i++) {
                elemsScanner = new Scanner(list.get(i));
                int j = 0;

                for (; elemsScanner.hasNextInt(); j++)
                    array[i][j] = elemsScanner.nextInt();

                if (j != dimY)
                    throw new IllegalArgumentException("Matrix in file is not square");
            }

            return () -> array;

        } catch (IOException ex) {
            System.out.println("Could not open file");
            System.out.println(ex.getMessage());
        } finally {
            if(strScanner != null)
                strScanner.close();

            if(elemsScanner != null)
                elemsScanner.close();


        }
        return null;
    }


    public String getDescription() {
        return "Matrix generateMatrix() method of ExtractMatrix class\n" +
                "extracts matrix from specified txt file,\n" +
                "matrix in file should be square one";
    }
}
//