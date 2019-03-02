package com.test.matrix;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.ArrayList;

public class Calculator {
    private int[][] resMatrix;
    private ArrayList<UserFlip> ufList = new ArrayList<UserFlip>();



    public void addCmdList(ArrayList<UserFlip> algs) {
        ufList.addAll(algs);
    }

    public void addCmd(UserFlip cmd) {
        ufList.add(cmd);
    }

    public int[][] calculate(int[][] initMatrix) {//в конце концов, исходную матрицу можно брать откуда угодно
        resMatrix = initMatrix;
        for (UserFlip userFlip : ufList) {
            resMatrix = userFlip.flipMethod(resMatrix);
        }
        return resMatrix;
    }


}
