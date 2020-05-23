package com.jonathan.exceptions;

/**
 * Purpose: Exceptions that occur in menu
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class MenuException extends Exception {
    /**
     * Alternate Constructor for menu exception
     * @param message reason for except
     * @param cause cause of except
     */
    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Alternate Constructor for menu exception
     * @param message reason for except
     */
    public MenuException(String message) {
        super(message);
    }

    /**
     * Alternate constructor for menu exception
     * @param e exception to wrap around.
     */
    public MenuException(Exception e) {
        super(e);
    }
}
