package com.test.UserPackage;

import com.test.MatrixPackage.UserInterface;

public class Main {

    public static void main(String[] args) {
        
        UserClass object=new UserClass();
        UserInterface mm;
        mm=object;

        System.out.println("Initial matrix is");
        int[][] m1=mm.generateRandomMatrix(args[0]);
        mm.displayMatrix(m1);

        System.out.println("Initial matrix after horizontal flipping is");
        int[][] m2=mm.flipHorizontally(m1);
        mm.displayMatrix(m2);

        System.out.println("Initial matrix after vertical flipping is");
        int[][] m3=mm.flipVertically(m1);
        mm.displayMatrix(m3);

        System.out.println("Initial matrix after flipping relative to main diagonal is");
        int[][] m4=mm.flipRelToMainDiag(m1);
        mm.displayMatrix(m4);

        System.out.println("Initial matrix after flipping relative to secondary diagonal is");
        int[][] m5=mm.flipRelToSecDiag(m1);
        mm.displayMatrix(m5);

        System.out.println("Initial matrix after user flipping is");
        int[][] m6=mm.userFlipMethod(m1);
        mm.displayMatrix(m6);
    }
}
