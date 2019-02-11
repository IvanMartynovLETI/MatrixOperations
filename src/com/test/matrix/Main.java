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

import java.util.*;


public class Main {

    public static void main(String[] args) {

        ArrayList<String> userList = new ArrayList<String>();
        userList.add("showResult");
        userList.add("showResult.getDescription");
        userList.add("generateMatrix.getDescriprion");
        userList.add("flipVert");
        userList.add("showResult");
        userList.add("flipVert.getDescription");
        userList.add("flipHor");
        userList.add("showResult");
        userList.add("flipHor.getDescription");
        userList.add("flipMD");
        userList.add("showResult");
        userList.add("flipMD.getDescription");
        userList.add("flipSD");
        userList.add("showResult");
        userList.add("flipSD.getDescription");
        userList.add("userFlip");
        userList.add("showResult");
        userList.add("userFlip.getDescription");
        //пока предполагается, что userList формируется внешним по отношению к core кодом
        //здесь код формирования userList пока не рассматривается.
        //в дальнейшем его будет формировать отдельный метод, который и отловит косяки ввода команд пользователя
        core(userList, args);

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

    public static void core(ArrayList<String> userList, String[] args) {

        ArrayList<String> acceptedOps = new ArrayList<String>(); //в дальнейшем этот список допустимых
        acceptedOps.add("flipHor");                           //команд должен формироваться ядром
        acceptedOps.add("flipVert");                             //самостоятельно
        acceptedOps.add("flipMD");
        acceptedOps.add("flipSD");
        acceptedOps.add("userFlip");
        acceptedOps.add("showResult");
        acceptedOps.add("generateMatrix.getDescriprion");
        acceptedOps.add("showResult.getDescription");
        acceptedOps.add("flipHor.getDescription");
        acceptedOps.add("flipVert.getDescription");
        acceptedOps.add("flipMD.getDescription");
        acceptedOps.add("flipSD.getDescription");
        acceptedOps.add("userFlip.getDescription");

        List<UserFlip> algorithms = Arrays.asList(
                new FlipHorizontally(),
                new FlipVertically(),
                new FlipRelToMainDiag(),
                new FlipRelToSecDiag(),
                new UserClass()
        );

        Map<String, UserFlip> flipVoc = new HashMap<String, UserFlip>();
        flipVoc.put(acceptedOps.get(0), algorithms.get(0));
        flipVoc.put(acceptedOps.get(1), algorithms.get(1));
        flipVoc.put(acceptedOps.get(2), algorithms.get(2));
        flipVoc.put(acceptedOps.get(3), algorithms.get(3));
        flipVoc.put(acceptedOps.get(4), algorithms.get(4));

        flipVoc.put(acceptedOps.get(8), algorithms.get(0));//вот эта вторая половина словаря мне не нравится,
        flipVoc.put(acceptedOps.get(9), algorithms.get(1));//но как обойти это место я пока не знаю
        flipVoc.put(acceptedOps.get(10), algorithms.get(2));
        flipVoc.put(acceptedOps.get(11), algorithms.get(3));
        flipVoc.put(acceptedOps.get(12), algorithms.get(4));

        try {
            int dim = checkInput(args);
            ShowMatrix matrixPrinter = new DisplayMatrix();
            int[][] initialMatrix = new GenerateRandomMatrix().generateMatrix(dim);
            int[][] tempMatrix = initialMatrix;

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i) == acceptedOps.get(5)) {
                    new DisplayMatrix().displayMatrix(tempMatrix);
                } else if (userList.get(i) == acceptedOps.get(6)) {
                    System.out.println(new GenerateRandomMatrix().getDescription());
                } else if (userList.get(i) == acceptedOps.get(7)) {
                    System.out.println(new DisplayMatrix().getDescription());
                } else {
                    UserFlip ufRef;
                    if (userList.get(i) == acceptedOps.get(8) || userList.get(i) == acceptedOps.get(9) ||
                            userList.get(i) == acceptedOps.get(10) || userList.get(i) == acceptedOps.get(11) ||
                            userList.get(i) == acceptedOps.get(12)) {
                        ufRef = flipVoc.get(userList.get(i));
                        System.out.println(ufRef.getDescription());
                    } else if (userList.get(i) == acceptedOps.get(0) || userList.get(i) == acceptedOps.get(1) ||
                            userList.get(i) == acceptedOps.get(2) || userList.get(i) == acceptedOps.get(3) ||
                            userList.get(i) == acceptedOps.get(4)) {
                        ufRef = flipVoc.get(userList.get(i));
                        tempMatrix = ufRef.flipMethod(tempMatrix);
                    } else {
                        throw new IllegalArgumentException("Invalid user command found");
                    }
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Wrong argument " + e.getMessage());
        }
    }
}
