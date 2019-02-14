package com.test.matrix;

import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;
import java.util.List;

public class Calculator {
    public int[][] calculate(List<UserFlip> algs, GenerateMatrix genM) {
        try {

            int[][] matrix = genM.generateMatrix();
            DisplayMatrix dObj = new DisplayMatrix();
            System.out.println("Initial matrix is");
            dObj.displayMatrix(matrix);

            for(UserFlip userFlip : algs) {
                matrix = userFlip.flipMethod(matrix);
                System.out.println(userFlip.getDescription());
            }
            System.out.println("Final matrix is");
            dObj.displayMatrix(matrix);
            return matrix;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
