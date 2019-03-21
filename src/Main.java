import com.test.matrix.Calculator;
import com.test.matrix.classes.UserClass;
import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.generation.GenIntMatrixFromFile;
import com.test.matrix.classes.generation.GenRandIntMatrix;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            DisplayMatrix<Integer> DObj = new DisplayMatrix<>();

            ArrayList<UserFlip> algorithms = new ArrayList<>();
            algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipVertically());
            algorithms.add(new FlipRelToMainDiag());
            algorithms.add(new FlipRelToSecDiag());

            algorithms.add(new UserClass());

            int dim = checkInput(args);

            GenRandIntMatrix GMObj = new GenRandIntMatrix(dim);
            //GenIntMatrixFromFile GMObj = new GenIntMatrixFromFile("K:\\shared folder\\1.txt");
            Calculator CObj = new Calculator(GMObj);
            CObj.addCmdList(algorithms);
            CObj.addCmd(new UserClass());

            ArrayList<UserFlip> algorithms1 = new ArrayList<>();
            algorithms1.add(new UserClass());

            CObj.addCmdList(algorithms1);

            System.out.println("Result is");
            DObj.displayMatrix(CObj.calculate());
            System.out.println("Initial matrix is");
            DObj.displayMatrix(CObj.getInitialMatrix());
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
