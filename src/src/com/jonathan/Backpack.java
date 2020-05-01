package com.jonathan;

import com.jonathan.model.Armour;
import com.jonathan.model.Potion;
import com.jonathan.model.Weapon;

import java.util.HashMap;

public class Backpack { /* Contains Detailed Information On The Items in players inventory, the generic 'inventory' is on the player. */
    private HashMap<String, Weapon> weaponStorage;
    private HashMap<String, Armour> armourStorage;
    private HashMap<String, Potion> potionStorage;
    public Backpack() {
        weaponStorage = new HashMap<>();
        armourStorage = new HashMap<>();
        potionStorage = new HashMap<>();
    }
}
