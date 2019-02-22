package com.test.matrix;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.ArrayList;

public class Calculator {
    private int[][] initMatrix;
    private int[][] resMatrix;
    private ArrayList<UserFlip> ufList = new ArrayList<UserFlip>();

    public Calculator(GenerateMatrix genM) {
        initMatrix = genM.generateMatrix();
        resMatrix = initMatrix;
    }

    public void addCmdList(ArrayList<UserFlip> algs) {
        if (algs.size() != 0) {
            ArrayList<UserFlip> tmpList = new ArrayList<UserFlip>();
            tmpList = ufList;

            for (int i = 0; i < algs.size(); i++)
                tmpList.add(algs.get(i));
            ufList = tmpList;
        }

    }

    public void addCmd(UserFlip cmd) {
        ufList.add(cmd);
    }

    public int[][] calculate() {
        for (UserFlip userFlip : ufList) {
            resMatrix = userFlip.flipMethod(resMatrix);
        }
        return resMatrix;
    }

    public int[][] getInitMatrix() {
        return initMatrix;
    }
}
