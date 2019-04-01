package com.test.matrix.classes.generation;

import com.test.matrix.classes.exceptions.MatrixException;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenIntMatrixFromFile implements GenerateMatrix {
    private Path path;

    public GenIntMatrixFromFile(String filePath) {
        path = Paths.get(filePath);
    }

    public GenIntMatrixFromFile(Path pathToFile) {
        path = pathToFile;
    }

    public Matrix<Integer> generateMatrix() {

        try {

            try (Scanner strScanner = new Scanner(path)) {
                ArrayList<String> list = new ArrayList<>();

                while (strScanner.hasNextLine())
                    list.add(strScanner.nextLine());

                int dimY = list.size();
                final Integer[][] array = new Integer[dimY][dimY];


                for (int i = 0; i < dimY; i++) {
                    try (Scanner elemsScanner = new Scanner(list.get(i))) {
                        int j = 0;
                        for (; elemsScanner.hasNextInt(); j++)
                            array[i][j] = elemsScanner.nextInt();

                        elemsScanner.close();

                        if (j != dimY)
                            throw new IllegalArgumentException("Matrix in file is not square");
                    }
                }

                return () -> array;
            }
        } catch (IOException e) {
            MatrixException n = new MatrixException("MatrixException occurred");
            n.addSuppressed(e);
            throw n;
        }
    }

    public String getDescription() {
        return "Matrix generateMatrix method of GenIntMatrixFromFile class extracts matrix from specified txt file,\n" +
                "matrix in file should be square one";
    }
}
