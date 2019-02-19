package com.test.matrix;

import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.List;

public class Calculator {
    private int[][] matrix;
    private List<UserFlip> ufList;
    private boolean initMatrixGenOK = false;

    public Calculator(GenerateMatrix genM) {
        try {
            matrix = genM.generateMatrix();
            initMatrixGenOK = true;
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong argument " + e.getMessage());
            throw new IllegalArgumentException("Initial matrix generation in constructor of +" +
                    "Calculator class failed");
        }

        DisplayMatrix dObj = new DisplayMatrix();
        System.out.println("Initial matrix is");
        dObj.displayMatrix(matrix);
    }

    public void addCmdList(List<UserFlip> algs) {
        try {
            if (algs.size() == 0) {
                throw new IllegalArgumentException("Empty command list received in addCmdList() method");
            }

            for (UserFlip userFlip : algs)
                ufList = algs;
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong argument " + e.getMessage());
            throw new IllegalArgumentException("Empty command list received in addCmdList() method");
        }
    }

    public void addCmd(UserFlip cmd) {
        ufList.add(cmd);
    }

    public int[][] calculate() {
        try {
            if (ufList.size() == 0) throw new IllegalArgumentException("list of operations for calculate() method +" +
                    "is empty");
            if (!initMatrixGenOK) throw new IllegalArgumentException("Initial random matrix for calculate() +" +
                    "method was not generated previously in constructor of Calculator class");

            for (UserFlip userFlip : ufList) {
                matrix = userFlip.flipMethod(matrix);
                System.out.println(userFlip.getDescription());
            }
            System.out.println("Final matrix is");
            return matrix;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("calculator() method failed");
        }


    }
}
