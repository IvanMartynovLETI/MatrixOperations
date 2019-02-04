package com.test.matrix;

import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.generation.GenerateRandomMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.ShowMatrix;
import com.test.matrix.interfaces.UserFlip;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.classes.*;

public class Main {

    public static void main(String[] args) {

        GenerateRandomMatrix GenerateMatrixObject=new GenerateRandomMatrix();
        FlipHorizontally FlipHorizontallyObject=new FlipHorizontally();
        FlipVertically FlipVerticallyObject=new FlipVertically();
        FlipRelToMainDiag FlipRelToMainDiagObject=new FlipRelToMainDiag();
        FlipRelToSecDiag FlipRelToSecDiagObject=new FlipRelToSecDiag();
        DisplayMatrix DisplayMatrixObject=new DisplayMatrix();
        UserClass UserClassObject=new UserClass();

        UserFlip UserFlipReference;
        GenerateMatrix GenerateMatrixReference;
        ShowMatrix ShowMatrixReference;

        ShowMatrixReference=DisplayMatrixObject;

        GenerateMatrixReference=GenerateMatrixObject;
        System.out.println("Initial matrix is");
        int[][] m1=GenerateMatrixReference.GenMatrixMethod(args[0]);
        ShowMatrixReference.displayMatrix(m1);

        System.out.println("Initial matrix after horizontal flipping is");
        UserFlipReference=FlipHorizontallyObject;
        int[][] m2=UserFlipReference.flipMethod(m1);
        ShowMatrixReference.displayMatrix(m2);


        System.out.println("Initial matrix after vertical flipping is");
        UserFlipReference=FlipVerticallyObject;
        int[][] m3=UserFlipReference.flipMethod(m1);
        ShowMatrixReference.displayMatrix(m3);

        System.out.println("Initial matrix after flipping relative to main diagonal is");
        UserFlipReference=FlipRelToMainDiagObject;
        int[][] m4=UserFlipReference.flipMethod(m1);
        ShowMatrixReference.displayMatrix(m4);

        System.out.println("Initial matrix after flipping relative to secondary diagonal is");
        UserFlipReference=FlipRelToSecDiagObject;
        int[][] m5=UserFlipReference.flipMethod(m1);
        ShowMatrixReference.displayMatrix(m5);

        System.out.println("Initial matrix after user flipping is");
        UserFlipReference=UserClassObject;
        int[][] m6=UserFlipReference.flipMethod(m1);
        ShowMatrixReference.displayMatrix(m6);
    }
}
