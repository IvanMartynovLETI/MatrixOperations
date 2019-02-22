package com.test.matrix;

import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int[][] matrix;
    private ArrayList<UserFlip> ufList = new ArrayList<UserFlip>();

    public Calculator(GenerateMatrix genM) {
        matrix = genM.generateMatrix();
    }

    public void addCmdList(ArrayList<UserFlip> algs) {
        ufList = algs;
    }

    public void addCmd(UserFlip cmd) {
        ufList.add(cmd);
    }

    public int[][] calculate() {
        for (UserFlip userFlip : ufList) {
            matrix = userFlip.flipMethod(matrix);
            System.out.println(userFlip.getDescription());
        }
        return matrix;
    }

    public int[][] getInitMatrix() {
        return matrix;
    }
}
