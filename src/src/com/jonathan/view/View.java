package com.jonathan.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class View { // SuperClass of views.
    public View() {}
    public void displayStats(String stats) {
        System.out.println(stats);
    }
    public String getInventorySelection(String inventory) {
        System.out.println(inventory);
        return prompt();
    }
    protected int prompt(String outPrompt, int min, int max) {
        int response = -1;
        while (response < min || response > max) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println(outPrompt);
                response = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That is a invalid response");
            }
        }
        return response;
    }
    protected String prompt() {
        String selectedItem = "";
        while (selectedItem.equals("")) {
            Scanner sc = new Scanner(System.in);
            selectedItem = sc.nextLine().trim();
            if (selectedItem.equals(""))
                System.out.println("Please select an item.");
        }
        return selectedItem.toUpperCase();
    }
}
