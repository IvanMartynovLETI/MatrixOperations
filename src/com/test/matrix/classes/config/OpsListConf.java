package com.test.matrix.classes.config;

import com.test.matrix.classes.exceptions.MatrixException;
import com.test.matrix.interfaces.UserFlip;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    return opsList
        .stream()
        .map(this::instanceOperation)
        .collect(Collectors.toList());
  }

  public static OpsListConf newInstance() {
    return new OpsListConf();
  }
}

