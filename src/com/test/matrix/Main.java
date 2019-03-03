package com.test.matrix;

import com.test.matrix.classes.UserClass;
import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.generation.GenerateRandomMatrix;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            DisplayMatrix DObj = new DisplayMatrix();
            UserFlip ufRef = new FlipVertically();

            ArrayList<UserFlip> algorithms = new ArrayList<UserFlip>();
            //algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipVertically());
            algorithms.add(new FlipRelToMainDiag());
            algorithms.add(new FlipRelToSecDiag());

            algorithms.add(new UserClass());
            algorithms.add(new UserClass());

            int dim = checkInput(args);

            GenerateRandomMatrix GObj = new GenerateRandomMatrix(dim);
            int[][] initRandMatrix = GObj.generateMatrix();
            GenerateMatrix GRef = GObj;
            Calculator CObj = new Calculator();
            System.out.println("Initial matrix is");
            DObj.displayMatrix(initRandMatrix);

            CObj.addCmdList(algorithms);
            CObj.addCmd(new UserClass());

            ArrayList<UserFlip> algorithms1 = new ArrayList<UserFlip>();
            algorithms1.add(new UserClass());
            algorithms1.add(new UserClass());

            CObj.addCmdList(algorithms1);

            CObj.addCmd(new UserClass());

            System.out.println("Result is");
            DObj.displayMatrix(CObj.calculate(GRef));
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong argument " + e.getMessage());
        }
    }

    private static int checkInput(String[] strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Empty dimension");
        }

        try {
            int i = Integer.parseInt(strArr[0]);
            if (i < 2 || i > 100) {
                throw new IllegalArgumentException("Dimension must be in range between 2 and 100");
            }
            return i;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Dimension must be an integer");
        }
    }
}
