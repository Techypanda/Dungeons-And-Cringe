package com.jonathan.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopViewer extends View {
    public int getShopResponse() {
        return prompt("Welcome to the Shop, what would you like to do?\n   1: Purchase new items\n   "
                + "2: Add an enchantment to a weapon\n   3: Sell an item in your inventory\n   4: Exit the shop.",
                1, 4);
    }
    public int getShopItemType() {
        return prompt("Would you like to:\n   1: See All Items\n   2: Purchase A Weapon\n   3: Purchase A Potion"
        + "\n   4: Purchase Armour\n   5: Exit Purchase", 1, 5);
    }
    public void displayGeneral(String items) {
        System.out.println(items);
    }
    public String getItemSelection(String itemSelection) {
        System.out.println("Here Are My Goods: \n" + itemSelection + "\nPlease select an item by typing its name.");
        String selectedItem = "";
        while (selectedItem.equals("")) {
            Scanner sc = new Scanner(System.in);
            selectedItem = sc.nextLine().trim();
            if (selectedItem.equals(""))
                System.out.println("Please select an item.");
        }
        return selectedItem.toUpperCase();
    }
    public void failPurchase(String itemName, String reason) {
        System.out.printf("Unable to purchase %s, %s%n", itemName, reason);
    }
    public void moneyDeducted(String playerName, String itemName, int playerCash, int itemCost) {
        int remaining = playerCash - itemCost;
        System.out.printf("%s has purchased %s, they had %d gold and the item cost %d gold, they now have %d gold remaining.%n",
                playerName, itemName, playerCash, itemCost, remaining);
    }
    private int prompt(String outPrompt, int min, int max) {
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
}
