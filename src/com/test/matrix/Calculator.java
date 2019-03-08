package com.test.matrix;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<UserFlip> ufList = new ArrayList<UserFlip>();
    private Matrix MRef;

    public Calculator(GenerateMatrix GMR) {
        GMR.generateMatrix();
        MRef = GMR.getMatrix();
    }

    public void addCmdList(ArrayList<UserFlip> algs) {
        ufList.addAll(algs);
    }

    public void addCmd(UserFlip cmd) {
        ufList.add(cmd);
    }

    public Matrix calculate() {
        for (UserFlip userFlip : ufList) {
            MRef = userFlip.flipMethod(MRef);
        }
        return MRef;
    }
}

