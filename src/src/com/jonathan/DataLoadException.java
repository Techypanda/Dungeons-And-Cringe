package com.jonathan;

public class DataLoadException extends Exception {
    public DataLoadException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataLoadException(String message) {
        super(message);
    }
}
