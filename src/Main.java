import com.test.matrix.classes.calculator.Calculator;
import com.test.matrix.classes.config.Configuration;
import com.test.matrix.classes.mapping.DisplayMatrix;
import java.io.*;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) {


        try {
            String configFilePath = "./resources/config.yaml";
            Configuration ConfObj = new Configuration(configFilePath);
            DisplayMatrix<Integer> DObj = new DisplayMatrix<>();
            Calculator<Integer> CObj = new Calculator<>(ConfObj.getGenRef());
            CObj.addCmdList(ConfObj.getOpsList());
            System.out.println("Result is");
            DObj.displayMatrix(CObj.calculate());
            System.out.println("Initial matrix is");
            DObj.displayMatrix(CObj.getInitialMatrix());

        } catch (IllegalArgumentException e1) {
            System.out.println("Wrong argument " + e1.getMessage());
        }  catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException | IOException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
//main
