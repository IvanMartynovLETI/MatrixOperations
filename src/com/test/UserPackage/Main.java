package com.test.UserPackage;

import com.test.MatrixPackage.Matrix;

public class Main {

    public static void main(String[] args) {

        Matrix MatrixObject = new Matrix();
        UserClass UserClassObject = new UserClass();
        UserFlip UserFlipReference;

        UserFlipReference=MatrixObject;

        System.out.println("Initial matrix is");
        int[][] m1=((Matrix) UserFlipReference).generateRandomMatrix(args[0]);
        ((Matrix) UserFlipReference).displayMatrix(m1);

        System.out.println("Initial matrix after horizontal flipping is");
        int[][] m2=((Matrix) UserFlipReference).flipHorizontally(m1);
        ((Matrix) UserFlipReference).displayMatrix(m2);

        System.out.println("Initial matrix after vertical flipping is");
        int[][] m3=((Matrix) UserFlipReference).flipVertically(m1);
        ((Matrix) UserFlipReference).displayMatrix(m3);

        System.out.println("Initial matrix after flipping relative to main diagonal is");
        int[][] m4=((Matrix) UserFlipReference).flipRelToMainDiag(m1);
        ((Matrix) UserFlipReference).displayMatrix(m4);

        System.out.println("Initial matrix after flipping relative to secondary diagonal is");
        int[][] m5=((Matrix) UserFlipReference).flipRelToSecDiag(m1);
        ((Matrix) UserFlipReference).displayMatrix(m5);

        System.out.println("Initial matrix after user flipping is");
        UserFlipReference=UserClassObject;
        int[][] m6=UserFlipReference.userFlipMethod(m1);
        UserFlipReference=MatrixObject;
        ((Matrix) UserFlipReference).displayMatrix(m6);
    }
}
