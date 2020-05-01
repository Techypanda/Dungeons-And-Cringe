package com.jonathan;

import com.jonathan.model.Armour;
import com.jonathan.model.Potion;
import com.jonathan.model.Weapon;

import java.util.Arrays;
import java.util.HashMap;

public class Shop {
    /* Keep The Items In Shop In Sorted Order, Sorted By Gold */
    private HashMap<String, Potion> potions;
    private HashMap<String, Armour> armour;
    private HashMap<String, Weapon> weapons;
    public Shop() {
        potions = new HashMap<>();
        armour = new HashMap<>();
        weapons = new HashMap<>();
    }
    public void updateShop(DataLoader inDataLoader) throws DataLoadException { /* Dependency Injection however it now is coupled to the dataloader.... */
        try {
            potions = inDataLoader.loadPotions();
            armour = inDataLoader.loadArmour();
            weapons = inDataLoader.loadWeapons();
        } catch (DataLoadException e) {
            throw e;
        }
    }
    public String describeShop() {
        String potionDetails = "";
        String armourDetails = "";
        String weaponDetails = "";
        if (potions.size() != 0) {
            potionDetails = "Here are my potions: \n";
            Potion[] sortedPotions = new Potion[potions.size()];
            int i = 0;
            for (Potion p : potions.values()) {
                sortedPotions[i] = p;
                i++;
            }
            Arrays.sort(sortedPotions);
            for (Potion p : sortedPotions) {
                potionDetails += String.format("%d gold - %s\n", p.getCost(), p.getName());
            }
        }
        if (weapons.size() != 0) {
            weaponDetails = "Here are my weapons: \n";
            Weapon[] sortedWeapons = new Weapon[weapons.size()];
            int i = 0;
            for (Weapon w : weapons.values()) {
                sortedWeapons[i] = w;
                i++;
            }
            Arrays.sort(sortedWeapons);
            for (Weapon w : sortedWeapons) {
                weaponDetails += String.format("%d gold - %s\n", w.getCost(), w.getName());
            }
        }
        if (armour.size() != 0) {
            armourDetails += "Here are my armours: \n";
            Armour[] sortedArmour = new Armour[armour.size()];
            int i = 0;
            for (Armour a : armour.values()) {
                sortedArmour[i] = a;
                i++;
            }
            Arrays.sort(sortedArmour);
            for (Armour a : sortedArmour) {
                armourDetails += String.format("%d gold - %s\n", a.getCost(), a.getName());
            }
        }
        return potionDetails + armourDetails + weaponDetails;
    }
    public Weapon cheapestWeapon() {
        Weapon cheapest = null;
        for (Weapon w: weapons.values()) {
            if (cheapest == null)
                cheapest = w;
            else if (w.getCost() < cheapest.getCost())
                cheapest = w;
        }
        return cheapest;
    }
    public Armour cheapestArmour() {
        Armour cheapest = null;
        for (Armour a: armour.values()) {
            if (cheapest == null)
                cheapest = a;
            else if (a.getCost() < cheapest.getCost())
                cheapest = a;
        }
        return cheapest;
    }
}
