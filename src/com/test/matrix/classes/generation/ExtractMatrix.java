package com.test.matrix.classes.generation;

import com.test.matrix.classes.HandMadeException;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;


import java.io.IOException;
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
        try {
            Scanner strScanner = new Scanner(path);

            try {
                ArrayList<String> list = new ArrayList<>();

                while (strScanner.hasNextLine())
                    list.add(strScanner.nextLine());

                int dimY = list.size();
                int[][] array = new int[dimY][dimY];

                for (int i = 0; i < dimY; i++) {
                    Scanner elemsScanner = new Scanner(list.get(i));
                    int j = 0;

                    for (; elemsScanner.hasNextInt(); j++)
                        array[i][j] = elemsScanner.nextInt();

                    elemsScanner.close();

                    if (j != dimY)
                        throw new IllegalArgumentException("Matrix in file is not square");
                }

                return () -> array;
            } finally {
                strScanner.close();
            }
        } catch (IOException e) {
            HandMadeException n = new HandMadeException("HandMadeException occured");
            n.addSuppressed(e);
            throw n;
        }
    }

    public String getDescription() {
        return "Matrix generateMatrix() method of ExtractMatrix class\n" +
                "extracts matrix from specified txt file,\n" +
                "matrix in file should be square one";
    }
}
//