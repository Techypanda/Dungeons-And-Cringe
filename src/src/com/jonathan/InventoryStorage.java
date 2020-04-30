package com.jonathan;

import java.util.HashMap;

public class InventoryStorage { /* Contains Detailed Information On The Items in players inventory, the generic 'inventory' is on the player. */
    private HashMap<String, Weapon> weaponStorage;
    private HashMap<String, Armour> armourStorage;
    private HashMap<String, Potion> potionStorage;
    public InventoryStorage() {
        weaponStorage = new HashMap<>();
        armourStorage = new HashMap<>();
        potionStorage = new HashMap<>();
    }
    public void insertItem(Potion p) {potionStorage.put(p.getName(), p);}
}
