package com.test.matrix.interfaces;

public interface UserFlip<T> {
    Matrix<T> flipMethod(Matrix<T> MRef);
    String getDescription();
}

