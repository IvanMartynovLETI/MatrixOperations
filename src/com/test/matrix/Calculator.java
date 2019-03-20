package com.test.matrix;

import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.Matrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.ArrayList;

public class Calculator<T> {
    private ArrayList<UserFlip<T>> ufList = new ArrayList<>();
    private GenerateMatrix<T> GMRef;
    private Matrix<T> initMRef;

    public Calculator(GenerateMatrix<T> GMR) { GMRef = GMR; }

    public void addCmdList(ArrayList<UserFlip<T>> algs) { ufList.addAll(algs); }

    public void addCmd(UserFlip<T> cmd) { ufList.add(cmd); }

    public Matrix<T> calculate() {
        Matrix<T> MRef = GMRef.generateMatrix();
        initMRef = MRef;

        for (UserFlip<T> userFlip : ufList) {
            MRef = userFlip.flipMethod(MRef);
        }
        return MRef;
    }

    public Matrix<T> getInitialMatrix() { return initMRef; }
}
