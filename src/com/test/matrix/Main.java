package com.test.matrix;

import com.test.matrix.classes.UserClass;
import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.generation.GenerateRandomMatrix;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.ShowMatrix;
import com.test.matrix.interfaces.UserFlip;

public class Main {

    public static void main(String[] args) {

        int dim = checkInput(args);

        GenerateRandomMatrix genMObj = new GenerateRandomMatrix();
        FlipHorizontally flipHorObj = new FlipHorizontally();
        FlipVertically flipVertObj = new FlipVertically();
        FlipRelToMainDiag flipMDObj = new FlipRelToMainDiag();
        FlipRelToSecDiag flipSDObj = new FlipRelToSecDiag();
        DisplayMatrix dispMObj = new DisplayMatrix();
        UserClass userObj = new UserClass();

        UserFlip userFlipRef;
        GenerateMatrix genMRef;
        ShowMatrix showMRef;

        showMRef = dispMObj;

        genMRef = genMObj;

        int[][] m1 = genMRef.generateMatrix(dim);
        System.out.println("Initial matrix is");
        showMRef.displayMatrix(m1);

        System.out.println("Initial matrix after horizontal flipping is");
        userFlipRef = flipHorObj;
        int[][] m2 = userFlipRef.flipMethod(m1);
        showMRef.displayMatrix(m2);

        System.out.println("Initial matrix after vertical flipping is");
        userFlipRef = flipVertObj;
        int[][] m3 = userFlipRef.flipMethod(m1);
        showMRef.displayMatrix(m3);

        System.out.println("Initial matrix after flipping relative to main diagonal is");
        userFlipRef = flipMDObj;
        int[][] m4 = userFlipRef.flipMethod(m1);
        showMRef.displayMatrix(m4);

        System.out.println("Initial matrix after flipping relative to secondary diagonal is");
        userFlipRef = flipSDObj;
        int[][] m5 = userFlipRef.flipMethod(m1);
        showMRef.displayMatrix(m5);

        System.out.println("Initial matrix after user flipping is");
        userFlipRef = userObj;
        int[][] m6 = userFlipRef.flipMethod(m1);
        showMRef.displayMatrix(m6);
    }

    private static int checkInput(String[] strArr) {
        int dimension;
        if (strArr.length == 0) {
            System.out.println("Command line parameter is empty.");
            System.out.println("0 as output parameter for checkInput() method generated");
            dimension = 0;
        } else {
            try {
                dimension = Integer.parseInt(strArr[0]);
            } catch (NumberFormatException ex) {
                System.out.println("Command line parameter is not an integer");
                System.out.println("0 as output parameter for checkInput() method generated");
                dimension = 0;
            }
            //ок, пустой параметр, не целое число и не число мы отловили, что осталось?
            //мы предполагаем, что пользователь неадекватен и может передать ахинею
            //частные случаи ахинеи, а именно 0, 1 и отрицательные целые мы будем
            //отлавливать в методе GenerateRandomMatrix()
        }
        return dimension;
    }
}
