package com.jonathan.view;

/**
 * Purpose: Handles view of main controller.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class MainView extends View {
    /**
     * Notifies the user of a error in program that is fatal.
     * @param reason the reason of fatal error.
     */
    public void notifyError(String reason) {
        System.out.println("A Fatal Error has occured and the program will need to end reason: " + reason);
    }

    /**
     * Notifies user of successful log of error
     */
    public void errorLogged() {
        System.out.println("The Fatal Error has been logged, you can find it in the file error.txt.");
    }

    /**
     * Notifies user of unsuccessful log of error
     */
    public void failErrorLogged() {
        System.out.println("The Program is unable to log the fatal error, please contact IT Support");
    }
}
