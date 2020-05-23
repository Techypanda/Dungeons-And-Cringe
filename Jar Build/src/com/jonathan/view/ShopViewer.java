package com.jonathan.view;

import java.util.Scanner;

/**
 * Purpose: To handle view of shop
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class ShopViewer extends View {
    /**
     * Presents enchantments to player and gets response
     * @return the users response
     */
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

    /**
     * Presents shop prompt and gets response
     * @return the users response
     */
    public int getShopResponse() {
        return prompt("Welcome to the Shop, what would you like to do?\n   1: Purchase new items\n   "
                + "2: Add an enchantment to a weapon\n   3: Sell an item in your inventory\n   4: Exit the shop.",
                1, 4);
    }

    /**
     * Presents shop item type prompt and gets response
     * @return the users response
     */
    public int getShopItemType() {
        return prompt("Would you like to:\n   1: See All Items\n   2: Purchase A Weapon\n   3: Purchase A Potion"
        + "\n   4: Purchase Armour\n   5: Exit Purchase", 1, 5);
    }

    /**
     * Displays a list of items to user
     * @param items the String items to display
     */
    public void displayGeneral(String items) {
        System.out.println(items);
    }

    /**
     * presents items to player and gets response
     * @param itemSelection items to display
     * @return users response
     */
    public String getItemSelection(String itemSelection) {
        System.out.println("Here Are My Goods: \n" + itemSelection + "\nPlease select an item by typing its name.");
        return prompt();
    }

    /**
     * Presents a failure to purchase from shop
     * @param itemName name of item failed to purchase
     * @param reason reason of failure
     */
    public void failPurchase(String itemName, String reason) {
        System.out.printf("Unable to purchase %s, %s%n", itemName, reason);
    }

    /**
     * Presents a failure to enchant from shop
     * @param itemName name of item to enchant
     * @param reason reason of failure
     */
    public void failEnchant(String itemName, String reason) {
        System.out.printf("Unable to enchant %s, %s%n", itemName, reason);
    }

    /**
     * Notification of money being deducted due to shop purchaase
     * @param playerName name of player
     * @param itemName item of purchase
     * @param playerCash player's money
     * @param itemCost cost of item.
     */
    public void moneyDeducted(String playerName, String itemName, int playerCash, int itemCost) {
        int remaining = playerCash - itemCost;
        System.out.printf("%s has purchased %s, they had %d gold and the item cost %d gold, they now have %d gold remaining.%n",
                playerName, itemName, playerCash, itemCost, remaining);
    }

    /**
     * Prompts player to sell item
     * @param generalInventory their inventory as string
     * @return response
     */
    public String sellPrompt(String generalInventory) {
        System.out.println("All Items Will Sell For 50% Of Their Cost Price.");
        System.out.println(generalInventory);
        return prompt();
    }

    /**
     * Notification of failure of sell
     * @param itemName item to sell
     * @param reason reason of failure
     */
    public void failSell(String itemName, String reason) {
        System.out.printf("Failed to sell %s reason: %s%n", itemName, reason);
    }

    /**
     * Confirmation of sell is presented and response gotten
     * @param itemName item to sell
     * @param cost gold to gain
     * @return whether it was sold or not
     */
    public int sellConfirmation(String itemName, int cost) {
        System.out.println("Are you sure you want to sell " + itemName + " for " + cost + " gold?: (Yes/anything else for no)");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        if (response.toUpperCase().equals("YES"))
            return 1;
        return 0;
    }

    /**
     * Notification of sell
     * @param itemName item that was sold
     * @param cost amount sold for.
     */
    public void sold(String itemName, int cost) {
        System.out.println(itemName + " has been sold for " + cost);
    }
}
