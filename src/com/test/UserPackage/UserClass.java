package com.test.UserPackage;

import com.test.MatrixPackage.UserInterface;

public class UserClass implements UserInterface {
    public int[][] userFlipMethod(int[][] m)
    {
        int[][] mr=new int[m.length][m[0].length];
        for(int i=0; i<m.length; i++)
            for(int j=0; j<m[0].length; j++)
                mr[i][j]=m[i][j]+1;
        return mr;
    }

}
