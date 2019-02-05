package com.test.matrix.classes;

import com.test.matrix.interfaces.UserFlip;

public class UserClass implements UserFlip {

    public int[][] flipMethod(int[][] m) {
        int[][] mr = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                mr[i][j] = m[i][j] + 1;

        return mr;
    }

    public String getDescription() {
        String s1, s2, s3;
        s1 = "int[][] flipMethod(int[][] inputMatrix) method of UserClass class returns matrix, \n";
        s2 = "flipped by user-defined method, inputMatrix must be a square matrix \n";
        s3 = s1 + s2;
        return s3;
    }

}
