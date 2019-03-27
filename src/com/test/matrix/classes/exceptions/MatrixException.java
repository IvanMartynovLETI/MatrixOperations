package com.test.matrix.classes.exceptions;

public class MatrixException extends RuntimeException {
    public MatrixException(String msg) {
        super(msg);
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }
}
