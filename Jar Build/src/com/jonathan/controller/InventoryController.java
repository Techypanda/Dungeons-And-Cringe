package com.jonathan.controller;

import com.jonathan.model.*;
import com.jonathan.view.InventoryViewer;

/**
 * Purpose: Controls Player's Inventory, handles all manipulation and storage details, limits are defined here rather
 * than in the player as this is game specific rather than model specific.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class InventoryController {
    private Player player;
    private InventoryViewer view;
    private int itemCount;
    private final int MAX_INVENTORY = 15;

    /**
     * Alternate constructor for inventory controller.
     * @param inPlayer the player to control inventory -- injected
     * @param view the view to attach to controller -- injected
     */
    public InventoryController(Player inPlayer, InventoryViewer view) {
        this.player = inPlayer;
        this.itemCount = 0;
        this.view = view;
    }

    /**
     * Returns if the inventory is full.
     * @return whether inv is full or not
     */
    public boolean isFull() {
        return this.itemCount >= MAX_INVENTORY;
    }

    /**
     * Returns if the inventory is empty.
     * @return whether inv is empty or not.
     */
    public boolean isEmpty() {
        return this.itemCount <= 0;
    }

    /**
     * Changes player's weapon
     */
    public void changeWeapon() {
        if (itemCount == 0) {
            view.unsuccessfulGet("Inventory", "empty");
        } else {
            String weaponChoice = view.chooseItem(player.showWeapons());
            Weapon[] chosen = player.getWeapon(weaponChoice);
            if (chosen.length == 0) {
                view.unsuccessfulGet(weaponChoice, "no such weapon exists.");
            } else if (chosen.length == 1) {
                view.equipped(player.getName(), chosen[0].getMeleeTitle());
                player.equip(chosen[0]);
            } else {
                String[] weaponDescs = new String[chosen.length];
                for (int i = 0; i < weaponDescs.length; i++)
                    weaponDescs[i] = chosen[i].toString();
                Weapon toEquip = chosen[view.multipleSelection(weaponDescs)];
                view.equipped(player.getName(), toEquip.getMeleeTitle());
                player.equip(toEquip);
            }
        }
    }

    /**
     * Changes player's armour
     */
    public void changeArmour() {
        if (itemCount == 0) {
            view.unsuccessfulGet("Inventory", "empty");
        } else {
            String armourChoice = view.chooseItem(player.showArmour());
            Armour[] chosen = player.getArmour(armourChoice);
            if (chosen.length == 0) {
                view.unsuccessfulGet(armourChoice, "no such armour exists.");
            } else if (chosen.length == 1) {
                view.equipped(player.getName(), chosen[0].getName());
                player.equip(chosen[0]);
            } else {
                String[] armourDescs = new String[chosen.length];
                for (int i = 0; i < armourDescs.length; i++)
                    armourDescs[i] = chosen[i].toString();
                Armour toEquip = chosen[view.multipleSelection(armourDescs)];
                view.equipped(player.getName(), toEquip.getName());
                player.equip(toEquip);
            }
        }
    }

    /**
     * Adds weapon to players inventory
     * @param inWeapon the weapon to add
     * @return whether it could add it or not.
     */
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

    /**
     * Adds armour to players inventory
     * @param inArmour the armour toa dd
     * @return whether it could add it or not.
     */
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

    /**
     * Adds healing to players inventory
     * @param inHealing the potion to add
     * @return whether it could add it or not
     */
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

    /**
     * Adds damage to players inventory
     * @param inDamage the potion to add
     * @return whether it could add it or not
     */
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

    /**
     * Removes a weapon from players inventory
     * @param inWeapon the weapon to remove
     */
    public void removeFromInventory(Weapon inWeapon) {
        player.removeWeapon(inWeapon);
        itemCount--;
    }

    /**
     * Removes a armour from players inventory
     * @param inArmour the armour to remove
     */
    public void removeFromInventory(Armour inArmour) {
        player.removeArmour(inArmour);
        itemCount--;
    }

    /** Polymorphic removal
     * Removes a potion from players inventory
     * @param p the potion to remove
     */
    public void removeFromInventory(Potion p) {
        player.removePotion(p);
    }

    /**
     * Returns a weapon from inventory
     * @return null if empty, else the weapon (NULLABLE)
     */
    public Weapon getWeapon() {
        if (itemCount <= 0) {
            view.emptyInventory();
        } else {
            String weaponTitle = view.getInventorySelection(player.showWeapons());
            Weapon[] selectedWeapons = player.getWeapon(weaponTitle);
            if (selectedWeapons.length == 0)  {
                view.unsuccessfulGet(weaponTitle, "weapon does not exist!");
            } else if (selectedWeapons.length == 1) {
                return selectedWeapons[0];
            } else { /* >1 multiple versions of the item. */
                String[] itemDescs = new String[selectedWeapons.length];
                for (int i = 0; i < selectedWeapons.length; i++)
                    itemDescs[i] = selectedWeapons[i].toString();
                return selectedWeapons[view.multipleSelection(itemDescs)];
            }
        }
        return null;
    }
}
