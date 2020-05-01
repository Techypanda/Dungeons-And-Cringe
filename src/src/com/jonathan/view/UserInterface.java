package com.jonathan.view;

import com.jonathan.model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public static int displayMenu() {
        boolean endLoop = false;
        return getResponse(1, 6, "1 - Go to Shop\n2 - Choose Character Name\n3 - Choose Weapon\n4 - Choose Armour\n5 - Start Battle\n6 - Exit Game");
    }
    public static void displayStats(Player p) {
        System.out.println(p.toString());
    }
    public static int displayShopPrompt(String name, String shopDesc) {
        int response = getResponse(1, 3, String.format("Hello %s\nWould you like to:\n1 - Purchase New Items\n2 - Add Enchantments To Weapons In Inventory\n3 - Sell Items In Inventory", name));
        switch (response) {
            case 1:
                System.out.println(shopDesc);
                break;
            case 2:

                break;
            case 3:

                break;
        }
        return 0;
    }
    public static String displayNamePrompt() {
        return getResponse("What would you like your new name to be?: ");
    }
    public static void error(Exception e) {
        System.out.printf("An Error has occurred and the program will need to terminate, here are the details: \n%s\n%s\n",
                e.getMessage(), e.getCause());
    }
    private static int getResponse(int low, int high, String prompt) {
        boolean endLoop = false;
        int response = -1;
        while (!endLoop) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(prompt);
                response = sc.nextInt();
                endLoop = response > (low-1) && response < (high+1);
                if (!endLoop)
                    System.out.println("Invalid Response, Please Enter A Correct Option.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Response, Please Enter A Correct Option.");
            }
        }
        return response;
    }
    private static String getResponse(String prompt) {
        Scanner sc = new Scanner(System.in);
        String chosenName = "";
        while (chosenName.equals("")) {
            System.out.print(prompt);
            chosenName = sc.nextLine().trim();
            if (!chosenName.equals(""))
                chosenName = capitalize(chosenName);
        }
        return chosenName;
    }
    private static String capitalize(String in) {
        String out = "";
        String[] toCap = in.split(" ");
        for(String s: toCap) {
            String temp = s.substring(0, 1).toUpperCase() + s.substring(1);
            out += temp + " ";
        }
        out = out.trim();
        return out;
    }
}
