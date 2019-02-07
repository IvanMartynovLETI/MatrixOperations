package com.test.matrix;

import com.test.matrix.classes.UserClass;
import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.generation.GenerateRandomMatrix;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.ShowMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {
  public static void main(String[] args) {
    try {
      int dim = checkInput(args);

      List<Supplier<UserFlip>> algorithms = Arrays.asList(
          FlipHorizontally::new,
          FlipVertically::new,
          FlipRelToMainDiag::new,
          FlipRelToSecDiag::new,
          UserClass::new
      );

      ShowMatrix matrixPrinter = new DisplayMatrix();
      int[][] matrix = new GenerateRandomMatrix().generateMatrix(dim);

      System.out.println("Initial matrix is");
      matrixPrinter.displayMatrix(matrix);

      for (Supplier<UserFlip> alg : algorithms) {
        UserFlip userFlip = alg.get();
        System.out.println(userFlip.getDescription());
        matrixPrinter.displayMatrix(userFlip.flipMethod(matrix));
      }

    } catch (IllegalArgumentException e) {
      System.out.println("Wrong argument: " + e.getMessage());
    }
  }

  private static int checkInput(String[] strArr) {
    if (strArr.length == 0) {
      throw new IllegalArgumentException("Empty dimension");
    }

    try {
      int i = Integer.parseInt(strArr[0]);
      if (i < 2 || i > 100) {
        throw new IllegalArgumentException("Dimension must be an in range 2 between 100");
      }
      return i;
    } catch (NumberFormatException ex) {
      throw new IllegalArgumentException("Dimension must an integer");
    }
  }

}
