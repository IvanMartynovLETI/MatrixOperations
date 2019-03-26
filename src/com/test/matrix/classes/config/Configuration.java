package com.test.matrix.classes.config;

import com.test.matrix.classes.config.yamlconfigreader.YamlConfigReader;
import com.test.matrix.interfaces.GenerateMatrix;
import com.test.matrix.interfaces.UserFlip;
import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Configuration {
    private String filePath;

    public Configuration(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public GenerateMatrix getGenRef() throws IOException, ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        Yaml yaml = new Yaml();

        try (InputStream in = Files.newInputStream(Paths.get(this.getFilePath()))) {
            YamlConfigReader config = yaml.loadAs(in, YamlConfigReader.class);

            switch (config.getGenInfo().getGenUsed()) {
                case "randGen":
                    RandGenConf RGCObj = new RandGenConf(config.getRandGenSettings().getRandMatrixDim());
                    return RGCObj.getRandGenRef();
                case "fileGen":
                    FileGenConf FGCObj = new FileGenConf(config.getFileGenSettings().getPathToMatrixFile());
                    return FGCObj.getFileGenRef();
                default:
                    throw new IllegalArgumentException("Incorrect gen type in yaml config file");
            }
        }
    }

    public ArrayList<UserFlip> getOpsList() throws IOException, ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        Yaml yaml = new Yaml();

        try (InputStream in = Files.newInputStream(Paths.get(this.getFilePath()))) {
            YamlConfigReader config = yaml.loadAs(in, YamlConfigReader.class);
            OpsListConf OLCObj = new OpsListConf(config.getCalcOpsList());
            return OLCObj.getAlgorithms();
        }

    }


}

