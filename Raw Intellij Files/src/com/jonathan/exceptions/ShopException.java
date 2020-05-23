package com.jonathan.exceptions;

/**
 * Purpose: Exceptions that occur in shop
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class ShopException extends Exception {
    /**
     * Alternate constructor for shop excep
     * @param message reason for except
     * @param cause cause for except
     */
    public ShopException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Alternate constructor for shop execp
     * @param message reason for excep
     */
    public ShopException(String message) {
        super(message);
    }
}
