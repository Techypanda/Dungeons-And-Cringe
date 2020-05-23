package com.jonathan.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Purpose: Superclass View that all views extend.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public abstract class View { // SuperClass of views.
    /**
     * Displays user's stats to screen. without lines
     * @param stats string of stats to display
     */
    public void displayStats(String stats) {
        System.out.println(stats);
    }

    /**
     * Outputs inventory, gets response from user
     * @param inventory string inventory to output
     * @return response from user
     */
    public String getInventorySelection(String inventory) {
        System.out.println(inventory);
        return prompt();
    }

    /**
     * Prompts user with a string, gets a response within min and max (int)
     * @param outPrompt the prompt
     * @param min minimum value (exclusive)
     * @param max maximum value (exclusive)
     * @return the response
     */
    public int prompt(String outPrompt, int min, int max) {
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

    /**
     * Gets string response
     * @return string response
     */
    public String prompt() {
        String selectedItem = "";
        while (selectedItem.equals("")) {
            Scanner sc = new Scanner(System.in);
            selectedItem = sc.nextLine().trim();
            if (selectedItem.equals(""))
                System.out.println("Please select an item.");
        }
        return selectedItem.toUpperCase();
    }

    /**
     * Gets a response within min and max with multiple item descriptions
     * @param itemDescriptions array of item descriptions
     * @return response between min and max
     */
    public int multipleSelection(String[] itemDescriptions) {
        String promptString = "You have multiple items under that name, please select from the following by the associated number:\n";
        int curr = 0;
        for (String x: itemDescriptions) {
            promptString += curr + " - " + itemDescriptions[curr] + "\n";
            curr += 1;
        }
        return prompt(promptString, 0, curr-1);
    }

    /**
     * display stats to screen with lines
     * @param stats the players stats
     */
    public void outStats(String stats) {
        System.out.println("------------- PLAYER STATS -------------");
        System.out.println(stats);
        System.out.println("----------------------------------------");
    }
}
