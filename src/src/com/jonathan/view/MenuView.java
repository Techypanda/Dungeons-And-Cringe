package com.jonathan.view;

public class MenuView extends View {
    public int getMenuChoice() {
        return prompt("1 - Go To Shop\n2 - Choose Character Name\n3 - Choose Weapon\n4 - Choose Armour\n5 - Start A Battle\n6 - Exit Game", 1, 6);
    }
    public String namePrompt() {
        System.out.println("What would you like your new name to be?");
        return prompt();
    }
    public void gameOver() {
        System.out.println("You Have Lost The Game!");
    }
}
