package com.jonathan.view;

public class InventoryViewer extends View {
    public void successfulAdd(String itemName) {
        System.out.println(itemName + " has been added to inventory.");
    }
    public void unsuccessfulAdd(String itemName, String reason) {
        System.out.println(itemName + " cannot be added to inventory: " + reason);
    }
    public void equipped(String playerName, String itemName) {

    }
}
