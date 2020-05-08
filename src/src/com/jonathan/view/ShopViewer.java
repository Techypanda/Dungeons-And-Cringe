package com.jonathan.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopViewer extends View {
    public int getEnchantingChoice() {
        int enchant = 0;
        System.out.println("Here are my enchantments: \n   Damage +2 - 5 gold - Adds 2 to attack damage."
                + "\n   Damage +5 - 10 gold - Adds 5 to attack damage.\n   Fire Damage - 20 gold - Adds between 5-10 "
                + "(randomly) to attack damage.\n   Power-Up - 10 gold - Multiplies attack damage by 1.1");
        String choice = prompt();
        switch (choice) {
            case "DAMAGE +5":
                enchant = 1;
                break;
            case "DAMAGE +2":
                enchant = 2;
                break;
            case "FIRE DAMAGE":
                enchant = 3;
                break;
            case "POWER-UP":
                enchant = 4;
                break;
            default:
                System.out.println("That is not a enchantment.");
                break;
        }
        return enchant;
    }
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
        return prompt();
    }
    public void failPurchase(String itemName, String reason) {
        System.out.printf("Unable to purchase %s, %s%n", itemName, reason);
    }
    public void failEnchant(String itemName, String reason) {
        System.out.printf("Unable to enchant %s, %s%n", itemName, reason);
    }
    public void moneyDeducted(String playerName, String itemName, int playerCash, int itemCost) {
        int remaining = playerCash - itemCost;
        System.out.printf("%s has purchased %s, they had %d gold and the item cost %d gold, they now have %d gold remaining.%n",
                playerName, itemName, playerCash, itemCost, remaining);
    }
    public String sellPrompt(String generalInventory) {
        System.out.println("All Items Will Sell For 50% Of Their Cost Price.");
        System.out.println(generalInventory);
        return prompt();
    }
    public void failSell(String itemName, String reason) {
        System.out.printf("Failed to sell %s reason: %s%n", itemName, reason);
    }
    public int sellConfirmation(String itemName, int cost) {
        System.out.println("Are you sure you want to sell " + itemName + " for " + cost + " gold?: (Yes/anything else for no)");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        if (response.toUpperCase().equals("YES"))
            return 1;
        return 0;
    }
    public void sold(String itemName, int cost) {
        System.out.println(itemName + " has been sold for " + cost);
    }
}
