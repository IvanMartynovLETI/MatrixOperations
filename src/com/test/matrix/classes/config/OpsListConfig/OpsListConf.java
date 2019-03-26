package com.test.matrix.classes.config.OpsListConfig;

import com.test.matrix.interfaces.UserFlip;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class OpsListConf {
    private ArrayList<UserFlip> algorithms = new ArrayList<>();
    private List<String> calcOpsList;

    public ArrayList<UserFlip> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(ArrayList<UserFlip> algorithms) {
        this.algorithms = algorithms;
    }

    public List<String> getCalcOpsList() {
        return calcOpsList;
    }

    public void setCalcOpsList(List<String> calcOpsList) {
        this.calcOpsList = calcOpsList;
    }

    public  OpsListConf(List<String> opsList) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {

        Class[] clazz = new Class[opsList.size()];
        Constructor[] constructor = new Constructor[opsList.size()];
        Object[] object = new Object[opsList.size()];

        for(int i = 0; i < opsList.size(); i ++) {
            clazz[i] = Class.forName(opsList.get(i));
            constructor[i] = clazz[i].getConstructor();
            object[i] = constructor[i].newInstance();
            this.algorithms.add((UserFlip) object[i]);
        }
    }
}
