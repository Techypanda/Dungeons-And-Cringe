package com.jonathan.view;

/**
 * Purpose: Handles view of menu
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class MenuView extends View {
    /**
     * presents menu to user and gets response
     * @return the response of user
     */
    public int getMenuChoice() {
        return prompt("1 - Go To Shop\n2 - Choose Character Name\n3 - Choose Weapon\n4 - Choose Armour\n5 - Start A Battle\n6 - Exit Game", 1, 6);
    }

    /**
     * presents name prompt and gets response
     * @return the response of player
     */
    public String namePrompt() {
        System.out.println("What would you like your new name to be?");
        return prompt();
    }

    /**
     * Presents game over to player.
     */
    public void gameOver() {
        System.out.println("You Have Lost The Game!");
    }
}
