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
    public boolean isFull() {
        return this.itemCount >= MAX_INVENTORY;
    }
    public boolean isEmpty() {
        return this.itemCount <= 0;
    }
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
    public void removeFromInventory(Weapon inWeapon) {
        player.removeWeapon(inWeapon);
        itemCount--;
    }
    public void removeFromInventory(Armour inArmour) {
        player.removeArmour(inArmour);
        itemCount--;
    }
    public void removeFromInventory(Potion p) {
        player.removePotion(p);
    }
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
