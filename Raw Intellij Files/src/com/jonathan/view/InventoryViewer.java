package com.jonathan.view;

/**
 * Purpose: Handles the view of inventory
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class InventoryViewer extends View {
    /**
     * Presents a succesful addition of item to user
     * @param itemName name of item added
     */
    public void successfulAdd(String itemName) {
        System.out.println(itemName + " has been added to inventory.");
    }

    /**
     * Presents a failure addition of item to user
     * @param itemName name of item failed to dd
     * @param reason reason of failure
     */
    public void unsuccessfulAdd(String itemName, String reason) {
        System.out.println(itemName + " cannot be added to inventory: " + reason);
    }

    /**
     * Presents empty inventory to user
     */
    public void emptyInventory() {
        System.out.println("You have a empty inventory!");
    }

    /**
     * Presents equip to player
     * @param playerName player name of equipper
     * @param itemName name of item equipped
     */
    public void equipped(String playerName, String itemName) {
        System.out.printf("%s has equipped %s%n", playerName, itemName);
    }

    /**
     * Presents failure of aquirement of item to user
     * @param itemName item attempted to aquire
     * @param reason reason of failure
     */
    public void unsuccessfulGet(String itemName, String reason) {
        System.out.printf("%s cannot be retrieved: %s%n", itemName, reason);
    }

    /**
     * Presents Items to choose and gets users response
     * @param itemList items to choose
     * @return users response
     */
    public String chooseItem(String itemList) {
        System.out.println("Which item would you like to equip?");
        System.out.println(itemList);
        return prompt();
    }
}
