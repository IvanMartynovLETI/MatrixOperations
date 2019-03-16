package com.test.matrix;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

import java.io.IOException;
import java.util.ArrayList;

class Calculator {
    private ArrayList<UserFlip> ufList = new ArrayList<>();
    private GenerateMatrix GMRef;
    private Matrix initMRef;

    Calculator(GenerateMatrix GMR) { GMRef = GMR; }

    void addCmdList(ArrayList<UserFlip> algs) {
        ufList.addAll(algs);
    }

    void addCmd(UserFlip cmd) {
        ufList.add(cmd);
    }

    Matrix calculate() throws IOException {

            Matrix MRef = GMRef.generateMatrix();
            initMRef = MRef;

            for (UserFlip userFlip : ufList) {
                MRef = userFlip.flipMethod(MRef);
            }
            return MRef;

    }

    Matrix getInitialMatrix() { return initMRef; }
}

