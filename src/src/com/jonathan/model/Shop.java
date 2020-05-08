package com.jonathan.model;

import com.jonathan.exceptions.DataLoadException;
import com.jonathan.model.*;

import java.util.*;

public class Shop {
    /* Keep The Items In Shop In Sorted Order, Sorted By Gold */
    private Map<String, Healing> healingPotions;
    private Map<String, Damage> harmingPotions;
    private Map<String, Armour> armour;
    private Map<String, Melee> weapons;
    public Shop() {
        healingPotions = new HashMap<>();
        harmingPotions = new HashMap<>();
        armour = new HashMap<>();
        weapons = new HashMap<>();
    }
    public void updateShop(DataLoader inDataLoader) throws DataLoadException { /* Dependency Injection however it now is coupled to the dataloader.... */
        try {
            harmingPotions = inDataLoader.loadDamagePotions();
            healingPotions = inDataLoader.loadHealingPotions();
            armour = inDataLoader.loadArmour();
            weapons = inDataLoader.loadWeapons();
        } catch (DataLoadException e) {
            throw e;
        }
    }
    public String describeShop() {
        String potionDetails = "Here are my potions: \n" + sortedDetails(healingPotions.values().toArray(new Item[0]), harmingPotions.values().toArray(new Item[0]));
        String armourDetails = "Here are is my armour: \n" + sortedDetails(armour.values().toArray(new Item[0]));
        String weaponDetails = "Here is my weapons: \n" + sortedDetails(weapons.values().toArray(new Item[0]));
        return potionDetails + armourDetails + weaponDetails;
    }
    public String describePotions() {
        return sortedDetails(healingPotions.values().toArray(new Item[0]), harmingPotions.values().toArray(new Item[0]));
    }
    public String describeArmour() {
        return sortedDetails(armour.values().toArray(new Item[0]));
    }
    public String describeWeapons() {
        return sortedDetails(weapons.values().toArray(new Item[0]));
    }
    private String sortedDetails(Item[]... toOut) { // Polymorphic Sort + varargs
        StringBuilder itemDetails = new StringBuilder();
        for (Item[] a: toOut) {
            Arrays.sort(a);
            for (Item item: a) {
                itemDetails.append(String.format("%d gold - %s - Effect: %d - %d%n", item.getCost(), item.getName(), item.getMin(), item.getMax()));
            }
        }
        return itemDetails.toString();
    }
    public Melee cheapestWeapon() {
        Melee cheapest = null;
        for (Melee w: weapons.values()) {
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
    public Weapon getWeapon(String selectedWeapon) {
        Melee m = weapons.get(selectedWeapon);
        if (m != null) {
            return new Melee(m);
        }
        return null;
    }
    public Armour getArmour(String selectedArmour) {
        Armour a = armour.get(selectedArmour);
        if (a != null)
            return new Armour(a);
        return null;
    }
    public Damage getDamagePotion(String selectedPotion) {
        Damage p = harmingPotions.get(selectedPotion);
        if (p != null)
            return new Damage(p);
        return null;
    }
    public Healing getHealingPotion(String selectedPotion) {
        Healing p = healingPotions.get(selectedPotion);
        if (p != null)
            return new Healing(p);
        return null;
    }
}
