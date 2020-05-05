package com.jonathan.controller;

import com.jonathan.model.*;
import com.jonathan.view.InventoryViewer;

public class InventoryController {
    private Player player;
    private InventoryViewer view;
    private int itemCount;
    private final int MAX_INVENTORY = 15;
    public InventoryController(Player inPlayer, InventoryViewer view) {
        this.player = inPlayer;
        this.itemCount = 0;
        this.view = view;
    }
    public boolean addToInventory(Weapon inWeapon) {
        if (itemCount >= MAX_INVENTORY) {
            view.unsuccessfulAdd(inWeapon.getName(), "inventory is full.");
            return false;
        } else {
            player.addItem(inWeapon);
            view.successfulAdd(inWeapon.getName());
            itemCount++;
            return true;
        }
    }
    public boolean addToInventory(Armour inArmour) {
        if (itemCount >= MAX_INVENTORY) {
            view.unsuccessfulAdd(inArmour.getName(), "inventory is full.");
            return false;
        } else {
            player.addItem(inArmour);
            view.successfulAdd(inArmour.getName());
            itemCount++;
            return true;
        }
    }
    public boolean addToInventory(Healing inHealing) {
        if (itemCount >= MAX_INVENTORY) {
            view.unsuccessfulAdd(inHealing.getName(), "inventory is full.");
            return false;
        } else {
            player.addItem(inHealing);
            view.successfulAdd(inHealing.getName());
            itemCount++;
            return true;
        }
    }
    public boolean addToInventory(Damage inDamage) {
        if (itemCount >= MAX_INVENTORY) {
            view.unsuccessfulAdd(inDamage.getName(), "inventory is full.");
            return false;
        } else {
            player.addItem(inDamage);
            view.successfulAdd(inDamage.getName());
            itemCount++;
            return true;
        }
    }
    public Weapon getWeapon() {
        if (itemCount <= 0)
            return null;
        Weapon outWeapon = null;

        return outWeapon;
    }
}
