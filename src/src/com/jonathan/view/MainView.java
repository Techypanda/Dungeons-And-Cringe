package com.jonathan.view;

public class MainView extends View {
    public void notifyError(String reason) {
        System.out.println("A Fatal Error has occured and the program will need to end reason: " + reason);
    }
    public void errorLogged(boolean done) {
        if (done) {
            System.out.println("The Fatal Error has been logged, you can find it in the file error.txt.");
        } else {
            System.out.println("The Program is unable to log the fatal error, please contact IT Support");
            /* No idea what you do if you cant log the error. */
        }
    }
}
