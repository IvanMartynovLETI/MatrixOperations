package com.test.matrix.classes.config;

import com.test.matrix.classes.exceptions.MatrixException;
import com.test.matrix.interfaces.UserFlip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OpsListConf {

  private UserFlip instanceOperation(String operation) {
    try {
      Class<? extends UserFlip> flipClass = Class.forName(operation).asSubclass(UserFlip.class);
      return flipClass.newInstance();
    } catch (Exception e) {
      throw new MatrixException(String.format("Can not instance of class %s", operation), e);
    }
  }

  public Collection<UserFlip> instanceOperations(List<String> opsList) throws MatrixException {
    List<UserFlip> result = new ArrayList<>(opsList.size());

    for (String operation : opsList) {
      result.add(instanceOperation(operation));
    }

    return result;
  }

  public static OpsListConf newInstance() {
    return new OpsListConf();
  }
}

