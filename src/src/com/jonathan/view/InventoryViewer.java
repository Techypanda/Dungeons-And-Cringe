package com.jonathan.view;

public class InventoryViewer extends View {
    public void successfulAdd(String itemName) {
        System.out.println(itemName + " has been added to inventory.");
    }
    public void unsuccessfulAdd(String itemName, String reason) {
        System.out.println(itemName + " cannot be added to inventory: " + reason);
    }
    public void emptyInventory() {
        System.out.println("You have a empty inventory!");
    }
    public void equipped(String playerName, String itemName) {
        System.out.printf("%s has equipped %s%n", playerName, itemName);
    }
    public void unsuccessfulGet(String itemName, String reason) {
        System.out.printf("%s cannot be retrieved: %s%n", itemName, reason);
    }
    public String chooseItem(String itemList) {
        System.out.println("Which item would you like to equip?");
        System.out.println(itemList);
        return prompt();
    }
}
