package com.test.matrix;

import com.test.matrix.classes.CustomException;
import com.test.matrix.classes.UserClass;
import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.generation.GenMatrixFromFile;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        try {
            DisplayMatrix DObj = new DisplayMatrix();

            ArrayList<UserFlip> algorithms = new ArrayList<>();
            algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipVertically());
            algorithms.add(new FlipRelToMainDiag());
            algorithms.add(new FlipRelToSecDiag());

            algorithms.add(new UserClass());
            algorithms.add(new UserClass());

            //int dim = checkInput(args);

            String strPath="K:/shared folder/1.txt";
            Path path = Paths.get(strPath);
            GenMatrixFromFile GRef = new GenMatrixFromFile(path);
            Calculator CObj = new Calculator(GRef);
            CObj.addCmdList(algorithms);
            CObj.addCmd(new UserClass());

            ArrayList<UserFlip> algorithms1 = new ArrayList<>();
            algorithms1.add(new UserClass());
            algorithms1.add(new UserClass());

            CObj.addCmdList(algorithms1);

            CObj.addCmd(new UserClass());

            System.out.println("Result is");
            DObj.displayMatrix(CObj.calculate());
            System.out.println("Initial matrix is");
            DObj.displayMatrix(CObj.getInitialMatrix());
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong argument " + e.getMessage());
        } catch(CustomException ex) {
            System.out.println(ex.getMessage());
        }


    }

    /*private static int checkInput(String[] strArr) {
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
    }*/
}
