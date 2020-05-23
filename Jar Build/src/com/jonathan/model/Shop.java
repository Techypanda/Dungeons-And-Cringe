package com.jonathan.model;

import com.jonathan.exceptions.DataLoadException;

import java.util.*;

/**
 * Purpose: The Shop Data Model
 * Date: 23/05/2020
 * Author: Jonathan Wright
 */
public class Shop {
    /* Keep The Items In Shop In Sorted Order, Sorted By Gold */
    private Map<String, Healing> healingPotions;
    private Map<String, Damage> harmingPotions;
    private Map<String, Armour> armour;
    private Map<String, Melee> weapons;

    /**
     * Constructs the shop. Default Constructor
     */
    public Shop() {
        healingPotions = new HashMap<>();
        harmingPotions = new HashMap<>();
        armour = new HashMap<>();
        weapons = new HashMap<>();
    }

    /**
     * Updates the shop with a dataloader, this is now coupled to a dataloader, I could have also had all of the maps
     * injected and but that seemed harder for a external programmer to use.
     * @param inDataLoader the data source  to load data from.
     * @throws DataLoadException if the dataloader couldnt read the data.
     */
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

    /**
     * Describes the shops state
     * @return the current state of shop as a string
     */
    public String describeShop() {
        String potionDetails = "Here are my potions: \n" + sortedDetails(healingPotions.values().toArray(new Item[0]), harmingPotions.values().toArray(new Item[0]));
        String armourDetails = "Here are is my armour: \n" + sortedDetails(armour.values().toArray(new Item[0]));
        String weaponDetails = "Here is my weapons: \n" + sortedDetails(weapons.values().toArray(new Item[0]));
        return potionDetails + armourDetails + weaponDetails;
    }

    /**
     * Describes all potions in shop
     * @return string of potions sorted
     */
    public String describePotions() {
        return sortedDetails(healingPotions.values().toArray(new Item[0]), harmingPotions.values().toArray(new Item[0]));
    }

    /**
     * Describes all armour in shop
     * @return string of armour sorted
     */
    public String describeArmour() {
        return sortedDetails(armour.values().toArray(new Item[0]));
    }

    /**
     * Describes all weapons in shop
     * @return string of all weapons sorted
     */
    public String describeWeapons() {
        return sortedDetails(weapons.values().toArray(new Item[0]));
    }

    /** Polymorphic
     * using varargs + item[] it sorts the input array/s, and adds it to a string of all the details, returning a string describing items
     * @param toOut the array/s of items to output to string
     * @return string detailing array/s of items
     */
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

    /**
     * Returns the cheapest weapon in shop
     * @return cheapest weapon
     */
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

    /**
     * Returns the cheapest armour in shop
     * @return cheapest armour
     */
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

    /**
     * Gets weapon from shop based off input string
     * @param selectedWeapon string name of weapon
     * @return null if weapon doesnt exist or weapon if does (NULLABLE)
     */
    public Weapon getWeapon(String selectedWeapon) {
        Melee m = weapons.get(selectedWeapon);
        if (m != null) {
            return new Melee(m);
        }
        return null;
    }

    /**
     * Returns armour from shop based off input string
     * @param selectedArmour string name of armour
     * @return null if armour doesnt exist or armour if does (NULLABLE)
     */
    public Armour getArmour(String selectedArmour) {
        Armour a = armour.get(selectedArmour);
        if (a != null)
            return new Armour(a);
        return null;
    }

    /**
     * Returns damage potion based off input string
     * @param selectedPotion string name of potion
     * @return null if potion doesnt exist or potion if does (NULLABLE)
     */
    public Damage getDamagePotion(String selectedPotion) {
        Damage p = harmingPotions.get(selectedPotion);
        if (p != null)
            return new Damage(p);
        return null;
    }

    /**
     * Returns healing potion based off input string
     * @param selectedPotion string name of healing potion
     * @return null if potion doesnt exist or potion if does (NULLABLE)
     */
    public Healing getHealingPotion(String selectedPotion) {
        Healing p = healingPotions.get(selectedPotion);
        if (p != null)
            return new Healing(p);
        return null;
    }
}
