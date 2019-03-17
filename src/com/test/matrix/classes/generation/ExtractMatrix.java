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
        Scanner strScanner = new Scanner("initial string");
        Scanner elemsScanner = new Scanner("initial string");

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

                elemsScanner.close();

                if (j != dimY)
                    throw new IllegalArgumentException("Matrix in file is not square");
            }

            strScanner.close();

            return () -> array;
        } catch(IOException ex) {
            IOException e = new IOException();
            e.addSuppressed(ex);
            throw new HandMadeException("shit happens");
        } finally {
            try {
                if(strScanner != null) {
                    strScanner.close();
                    throw new IOException("strScanner was not closed, closing now");
                }
            } catch (IOException ex) { System.out.println(ex.getMessage()); }

            try {
                if(elemsScanner != null) {
                    elemsScanner.close();
                    throw new IOException("elemsScanner was not closed, closing now");
                }
            } catch (IOException e) { System.out.println(e.getMessage());}
        }
    }


    public String getDescription() {
        return "Matrix generateMatrix() method of ExtractMatrix class\n" +
                "extracts matrix from specified txt file,\n" +
                "matrix in file should be square one";
    }
}
//