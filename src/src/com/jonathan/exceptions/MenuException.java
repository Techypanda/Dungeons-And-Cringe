package com.jonathan.exceptions;

public class MenuException extends Exception {
    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }
    public MenuException(String message) {
        super(message);
    }
    public MenuException(Exception e) {
        super(e);
    }
}
