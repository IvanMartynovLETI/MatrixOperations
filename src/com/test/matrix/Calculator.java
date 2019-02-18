package com.test.matrix;

import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;
import java.util.List;

public class Calculator {
    private int[][] matrix;
    private List<UserFlip> ufList;
    private boolean initMatrixGenOK = false;

    public void configure(List<UserFlip> algs, GenerateMatrix genM) {
        try {
            if(algs.size() == 0) {
                throw new IllegalArgumentException("empty list in configure() method");
            }
            try {
                this.matrix = genM.generateMatrix();
                initMatrixGenOK = true;
            } catch(IllegalArgumentException e) {
                System.out.println("Wrong argument " + e.getMessage());
                throw new IllegalArgumentException("initial matrix generation falled");
            }

            DisplayMatrix dObj = new DisplayMatrix();
            System.out.println("Initial matrix is");
            dObj.displayMatrix(matrix);

            ufList = algs;


        } catch(IllegalArgumentException e) {
            System.out.println("Wrong argument " + e.getMessage());
            throw new IllegalArgumentException("Calculator configuration falled");
        }
    }

    public int[][] calculate() {
        try {
            if(ufList.size() == 0) throw new IllegalArgumentException("list of operations for calculate() method +" +
                    "is empty");
            if(!initMatrixGenOK) throw new IllegalArgumentException("Initial random matrix for calculate() +" +
                    "method was not generated previously in configure() method");

            for(UserFlip userFlip : ufList) {
                matrix = userFlip.flipMethod(matrix);
                System.out.println(userFlip.getDescription());
            }
            System.out.println("Final matrix is");
            return matrix;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("calculator() method falled");
        }

    }
}
