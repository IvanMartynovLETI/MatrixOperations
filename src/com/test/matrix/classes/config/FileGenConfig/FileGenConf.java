package com.test.matrix.classes.config.MatrixGenConfig;

import com.test.matrix.interfaces.GenerateMatrix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MatrixGenConf {
    private String filePath;

    public MatrixGenConf(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public GenerateMatrix getFileGenRef(String filePath) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {

        String className = "com.test.matrix.classes.generation.GenIntMatrixFromFile";
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor(String.class);
        Object object = constructor.newInstance(filePath);
        return (GenerateMatrix) object;
    }

}
