package com.test.matrix.classes.config;

import com.test.matrix.interfaces.GenerateMatrix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class FileGenConf {
    private String filePath;

    FileGenConf(String filePath) {
        this.filePath = filePath;
    }

    private String getFilePath() {
        return filePath;
    }

    /*public void setFilePath(String filePath) {
        this.filePath = filePath;
    }*/

    GenerateMatrix getFileGenRef() throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        String className = "com.test.matrix.classes.generation.GenIntMatrixFromFile";
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Object object = constructor.newInstance(this.getFilePath());
        return (GenerateMatrix) object;
    }
}

