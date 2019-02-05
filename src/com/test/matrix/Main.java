package com.test.matrix;

import com.test.matrix.classes.checkarg.ArgCheck;
import com.test.matrix.classes.checkarg.CrazyUser;
import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.generation.GenerateRandomMatrix;
import com.test.matrix.interfaces.*;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.classes.*;

public class Main {

    public static void main (String[] args) {

        ArgCheck argCheckObj = new ArgCheck ();
        CrazyUser crazyUserObj = new CrazyUser ();


        String outStr1 = argCheckObj.checkForEmpty(args);
        int dim = crazyUserObj.checkUserInput(outStr1);

        GenerateRandomMatrix genMObj = new GenerateRandomMatrix ();
        FlipHorizontally flipHorObj = new FlipHorizontally ();
        FlipVertically flipVertObj = new FlipVertically ();
        FlipRelToMainDiag flipMDObj = new FlipRelToMainDiag ();
        FlipRelToSecDiag flipSDObj = new FlipRelToSecDiag ();
        DisplayMatrix dispMObj = new DisplayMatrix ();
        UserClass userObj = new UserClass ();

        UserFlip userFlipRef;
        GenerateMatrix genMRef;
        ShowMatrix showMRef;

        showMRef = dispMObj;

        genMRef = genMObj;

        int[][] m1 = genMRef.genMatrixMethod (dim);
        System.out.println ("Initial matrix is");
        showMRef.displayMatrix (m1);

        System.out.println ("Initial matrix after horizontal flipping is");
        userFlipRef = flipHorObj;
        int[][] m2 = userFlipRef.flipMethod (m1);
        showMRef.displayMatrix (m2);

        System.out.println ("Initial matrix after vertical flipping is");
        userFlipRef = flipVertObj;
        int[][] m3 = userFlipRef.flipMethod (m1);
        showMRef.displayMatrix (m3);

        System.out.println ("Initial matrix after flipping relative to main diagonal is");
        userFlipRef = flipMDObj;
        int[][] m4 = userFlipRef.flipMethod (m1);
        showMRef.displayMatrix (m4);

        System.out.println ("Initial matrix after flipping relative to secondary diagonal is");
        userFlipRef = flipSDObj;
        int[][] m5 = userFlipRef.flipMethod (m1);
        showMRef.displayMatrix (m5);

        System.out.println ("Initial matrix after user flipping is");
        userFlipRef = userObj;
        int[][] m6 = userFlipRef.flipMethod (m1);
        showMRef.displayMatrix (m6);
    }
}
