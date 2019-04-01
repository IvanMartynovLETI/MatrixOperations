package com.test.matrix.classes.config;

import com.test.matrix.interfaces.GenerateMatrix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class RandGenConf {
    private String dim;

    RandGenConf(String dim) {
        this.dim = dim;
    }

    private String getDim() {
        return dim;
    }

    /*public void setDim(String dim) {
        this.dim = dim;
    }*/

    private int checkInput(String dim) {
        if (dim.equals("")) {
            throw new IllegalArgumentException("Empty dimension");
        }

        try {
            int i = Integer.parseInt(dim);
            if (i < 2 || i > 100) {
                throw new IllegalArgumentException("Dimension must be in range between 2 and 100");
            }
            return i;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Dimension must be an integer");
        }
    }

    GenerateMatrix getRandGenRef() throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {

        String className = "com.test.matrix.classes.generation.GenRandIntMatrix";
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor(int.class);
        Object object = constructor.newInstance(this.checkInput(this.getDim()));
        return (GenerateMatrix) object;
    }
}

