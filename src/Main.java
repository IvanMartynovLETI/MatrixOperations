import com.test.matrix.classes.Calculator.Calculator;
import com.test.matrix.classes.Config.Configuration;
import com.test.matrix.classes.UserClasses.UserClass;
import com.test.matrix.classes.flip.FlipHorizontally;
import com.test.matrix.classes.flip.FlipRelToMainDiag;
import com.test.matrix.classes.flip.FlipRelToSecDiag;
import com.test.matrix.classes.flip.FlipVertically;
import com.test.matrix.classes.mapping.DisplayMatrix;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;
import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        try {
            GenerateMatrix GMRef;
            Yaml yaml = new Yaml();
            try (InputStream in = Files.newInputStream(Paths.get("./resource/config.yaml"))) {
                Configuration confObj = yaml.loadAs(in, Configuration.class);
                GMRef = confObj.getGenRef();
                System.out.println(confObj.toString());
            }

            DisplayMatrix<Integer> DObj = new DisplayMatrix<>();

            ArrayList<UserFlip> algorithms = new ArrayList<>();
            algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipHorizontally());
            algorithms.add(new FlipVertically());
            algorithms.add(new FlipRelToMainDiag());
            algorithms.add(new FlipRelToSecDiag());
            algorithms.add(new UserClass());

            Calculator CObj = new Calculator(GMRef);
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
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
