package com.test.matrix.classes.generation;

import com.test.matrix.classes.MatrixException;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenMatrixFromFile implements GenerateMatrix {
    private Path path;

    public GenMatrixFromFile(String filePath) {
        path = Paths.get(filePath);
    }

    public GenMatrixFromFile(Path pathToFile) {
        path = pathToFile;
    }

    public Matrix generateMatrix() {
        try {

            try (Scanner strScanner = new Scanner(path)) {
                try {
                    ArrayList<String> list = new ArrayList<>();

                    while (strScanner.hasNextLine())
                        list.add(strScanner.nextLine());

                    int dimY = list.size();
                    int[][] array = new int[dimY][dimY];

                    for (int i = 0; i < dimY; i++) {
                        try (Scanner elemsScanner = new Scanner(list.get(i))) {
                            try {
                                int j = 0;
                                for (; elemsScanner.hasNextInt(); j++)
                                    array[i][j] = elemsScanner.nextInt();

                                elemsScanner.close();

                                if (j != dimY)
                                    throw new IllegalArgumentException("Matrix in file is not square");
                            } finally {
                                elemsScanner.close();
                            }
                        }
                    }

                    return () -> array;
                } finally {
                    strScanner.close();
                }
            }
        } catch (IOException e) {
            MatrixException n = new MatrixException("CustomException occurred");
            n.addSuppressed(e);
            throw n;
        }
    }

    public String getDescription() {
        return "Matrix generateMatrix() method of GenMatrixFromFile class\n" +
                "extracts matrix from specified txt file,\n" +
                "matrix in file should be square one";
    }
}
