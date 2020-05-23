package com.jonathan.exceptions;

/**
 * Purpose: An exception that occurs during data load
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class DataLoadException extends Exception {
    /**
     * Alternate Constructor for Dataloadexception
     * @param message details about why exception happened
     * @param cause cause of exception
     */
    public DataLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Alternate Constructor for dat...
     * @param message details about why exception happened
     */
    public DataLoadException(String message) {
        super(message);
    }
}
