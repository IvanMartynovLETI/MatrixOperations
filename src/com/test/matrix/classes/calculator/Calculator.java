package com.test.matrix.classes.calculator;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.ArrayList;
import java.util.Collection;

public class Calculator {
    private Collection<UserFlip> ufList = new ArrayList<>();
    private GenerateMatrix GMRef;
    private Matrix initMRef;

    public Calculator(GenerateMatrix GMR) { GMRef = GMR; }

    public void addCmdList(Collection<UserFlip> algs) { ufList.addAll(algs); }

    public void addCmd(UserFlip cmd) { ufList.add(cmd); }

    public Matrix calculate() {
        Matrix MRef = GMRef.generateMatrix();
        initMRef = MRef;

        for (UserFlip userFlip : ufList) {
            MRef = userFlip.flipMethod(MRef);
        }
        return MRef;
    }

    public Matrix getInitialMatrix() { return initMRef; }
}
