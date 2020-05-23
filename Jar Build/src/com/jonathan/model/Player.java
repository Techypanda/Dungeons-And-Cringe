package com.jonathan.model;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * PURPOSE: A Player Controlled Character.
 * AUTHOR: Jonathan Wright
 * DATE: 23/05/2020
 */
public class Player extends Character {
    /* private Map<String, Item> inventory; Why I chose not to implement it this way is covered in the docs, basically
    * I cant think of a good way with containing just the items to seperate into potions sword and armour
    * because otherwise i'd need instanceof, and while i'm likely to lose marks for avoiding polymorphism, i use polymorphism
    * in other places so I decided to avoid instanceof alltogether.                                                     */
    private List<Weapon> weapons;
    private List<Armour> armours;
    private List<Damage> damagePotions;
    private List<Healing> healingPotions;
    private Weapon weapon;
    private Armour armour;

    /**
     * Default Constructor for the player.
     */
    public Player() {
        super("The Player", 30, 100);
        weapon = new Melee("No Weapon", 0, 0, 0, "Punching", "Fists");
        armour = new Armour("No Armour", 0, 0, 0, "Bare Skin");
        weapons = new ArrayList<>();
        armours = new ArrayList<>();
        damagePotions = new ArrayList<>();
        healingPotions = new ArrayList<>();
    }

    /**
     * Alternate Constructor for the player
     * @param inName name of player
     * @param inHP hp of plyer
     * @param inGold gold of player
     * @param inWeapon strating weapon
     * @param inArmour starting armour
     */
    public Player(String inName, int inHP, int inGold, Weapon inWeapon, Armour inArmour) {
        super(inName, inHP, inGold);
        weapon = inWeapon;
        armour = inArmour;
        weapons = new ArrayList<>();
        armours = new ArrayList<>();
    }

    /**
     * Calculates damage of the player and returns it.
     * @return calculated damage.
     */
    @Override
    public int getDamage() {
        int dmgVal = weapon.getEffect();
        damageDetails = name + " inflicts " + weapon.getDamageType() + " on opponent";
        return dmgVal;
    }

    /**
     * Calculates actual damage to take, (armour reduces it + defensive enchants if implemented.)
     * @param inDmg the damage to take
     * @return the actual damage to take
     */
    @Override
    public int takeDamage(int inDmg) {
        int defenceVal = armour.getEffect();
        int damageToTake = Math.max(0, inDmg - defenceVal);
        currHP = currHP - damageToTake;
        if (currHP < 0)
            currHP = 0; /* Cant go negative, you are already dead. */
        return damageToTake;
    }

    /**
     * Returns a string detailing the player
     * @return a string detailing player
     */
    @Override
    public String toString() {
        return String.format("%s, HP: %d, gold: %d, Equipped Weapon: %s, Equipped Armour: %s\nWeapon Details: %s\nArmour Details: %s",
                name, currHP, gold, weapon.getName(), armour.getName(), weapon.toString(), armour.toString());
    }
    /*
    Although I am not being polymorphic here, the alternative would be to use a ItemHandler, and have the items handle
    equip and adding into inventory, however the problem with this is that the Coupling would be increased by this.
    I could also use instanceof but this is both expensive and not polymorphic so I either had to lose polymorphism or
    coupling, and I thought the logical decision would be to increase coupling but decrease polymorphism.
     */

    /**
     * Equips a weapon
     * @param toEquip weapon to equip
     */
    public void equip(Weapon toEquip) {
        weapon = toEquip;
    }

    /**
     * Equips a armour
     * @param toEquip armour to equip
     */
    public void equip(Armour toEquip) {
        armour = toEquip;
    }

    /**
     * Adds weapon to inv
     * @param inWeapon weapon to add
     */
    public void addItem(Weapon inWeapon) {
        weapons.add(inWeapon);
    }

    /**
     * Adds armour to inv
     * @param inArmour armour to add
     */
    public void addItem(Armour inArmour) {
        armours.add(inArmour);
    }

    /**
     * Adds damage potion to inv
     * @param inPotion potion to add
     */
    public void addItem(Damage inPotion) { damagePotions.add(inPotion); }

    /**
     * Adds healing potion to inv
     * @param inPotion healing to add
     */
    public void addItem(Healing inPotion) { healingPotions.add(inPotion); }
    public String showWeapons() {
        return invCollection(weapons.toArray(new Weapon[0]));
    }

    /**
     * Removes weapon from inv
     * @param inWeapon to remove
     * @return weapon that was removed
     */
    public Weapon removeWeapon(Weapon inWeapon) {
        if (weapons.remove(inWeapon)) {
            if (weapon.equals(inWeapon)) {
                weapon = new Melee("No Weapon", 0, 0, 0, "Punching", "Fists");
            }
            return inWeapon;
        }
        return null;
    }

    /**
     * Armour to remove from inv
     * @param inArmour to rem ove
     * @return armour removed
     */
    public Armour removeArmour(Armour inArmour) {
        if (armours.remove(inArmour)) {
            if (inArmour.equals(armour)) {
                armour = new Armour("No Armour", 0, 0, 0, "Bare Skin");
            }
            return inArmour;
        }
        return null;
    }

    /**
     * Returns if player has potions
     * @return if player has potions
     */
    public boolean hasPotions() {
        return (healingPotions.size() != 0) || (damagePotions.size() != 0);
    }

    /** -- polymorphic potion usage
     * removes potion from inv
     * @param p to remove
     * @return removed potion
     */
    public Potion removePotion(Potion p) {
        if (damagePotions.remove(p) || healingPotions.remove(p)) {
            return p;
        }
        return null;
    }

    /**
     * Replaces a weapon with new weapon
     * @param oldWeapon weapon to replace
     * @param newWeapon weapon to replace with
     */
    public void replaceWeapon(Weapon oldWeapon, Weapon newWeapon) {
        weapons.remove(oldWeapon);
        if (weapon.equals(oldWeapon)) {
            weapon = newWeapon;
        }
        weapons.add(newWeapon);
    }

    /**
     * returns weapon from inv
     * @param inWeaponTitle weapontitle to get
     * @return the weapon
     */
    public Weapon[] getWeapon(String inWeaponTitle) {
        ArrayList<Weapon> weaponList = new ArrayList<>();
        for (Weapon currWeapon: weapons) {
            if (currWeapon.getMeleeTitle().toUpperCase().equals(inWeaponTitle.toUpperCase())) {
                weaponList.add(currWeapon);
            }
        }
        return weaponList.toArray(new Weapon[0]);
    }

    /**
     * returns armour from inv
     * @param inArmourTitle armourtitle to get
     * @return the armour
     */
    public Armour[] getArmour(String inArmourTitle) {
        ArrayList<Armour> armourList = new ArrayList<>();
        for (Armour currArmour: armours) {
            if (currArmour.getName().toUpperCase().equals(inArmourTitle.toUpperCase())) {
                armourList.add(currArmour);
            }
        }
        return armourList.toArray(new Armour[0]);
    }

    /** Polymorphic.
     * returns potion to get from inv
     * @param inPotionTitle potion to get
     * @return the potion
     */
    public Potion[] getPotions(String inPotionTitle) {
        ArrayList<Potion> potionList = new ArrayList<>();
        for (Healing currPotion: healingPotions) {
            if (currPotion.getName().toUpperCase().equals(inPotionTitle.toUpperCase())) {
                potionList.add(currPotion);
            }
        }
        for (Damage currPotion: damagePotions) {
            if (currPotion.getName().toUpperCase().equals(inPotionTitle.toUpperCase())) {
                potionList.add(currPotion);
            }
        }
        return potionList.toArray(new Potion[0]);
    }

    /**
     * returns damage potion to get
     * @param inPotionTitle title of potion
     * @return damage potion to return
     */
    public Damage[] getDamagePotion(String inPotionTitle) {
        ArrayList<Damage> potionList = new ArrayList<>();
        for (Damage currPotion: damagePotions) {
            if (currPotion.getName().toUpperCase().equals(inPotionTitle.toUpperCase())) {
                potionList.add(currPotion);
            }
        }
        return potionList.toArray(new Damage[0]);
    }

    /**
     * returns healing potion to get
     * @param inPotionTitle title of potion
     * @return healing potion to return
     */
    public Healing[] getHealingPotion(String inPotionTitle) {
        ArrayList<Healing> potionList = new ArrayList<>();
        for (Healing currPotion: healingPotions) {
            if (currPotion.getName().toUpperCase().equals(inPotionTitle.toUpperCase())) {
                potionList.add(currPotion);
            }
        }
        return potionList.toArray(new Healing[0]);
    }

    /**
     * returns currently held weapon
     * @return the currently held weapon
     */
    public Weapon getHeldWeapon() {
        return weapon;
    }

    /**
     * returns currently held armour
     * @return the currently held armour
     */
    public Armour getHeldArmour() {
        return armour;
    }

    /**
     * return string of all armour in inv.
     * @return string of all armour
     */
    public String showArmour() {
        return invCollection(armours.toArray(new Item[0]));
    }

    /**
     * return string of all potions
     * @return string of all potions
     */
    public String showPotions() {
        return invCollection(damagePotions.toArray(new Damage[0])) + invCollection(healingPotions.toArray(new Healing[0]));
    }

    /** Polymorphic
     * Finds a item within a list of items, private as its intended to be used by the specific getters.
     * @param inList -- the list of items to search.
     * @param name -- the name of item to find
     * @return the item found
     */
    private Item find(List<Item> inList, String name) {
        for (Item curr: inList) {
            if (curr.getName().toUpperCase().equals(name.toUpperCase()))
                return curr;
        }
        return null;
    }

    /**
     * Returns a string detailing the item list fed in.
     * @param items array of items to iterate
     * @return string detailing the items
     */
    private String invCollection(Item[] items) {
        String outItems = "";
        for (Item curr: items) {
            outItems += curr.toString() + "\n";
        }
        return outItems;
    }

    /**
     * Specific method to detailing weapons, required for specific requirements that only weapons meet.
     * @param items weapons array to iterate
     * @return string detailing specific details regarding weapons (Enchantments.)
     */
    private String invCollection(Weapon[] items) { // Decorators dont extend item.
        String outItems = "";
        for (Weapon curr: items) {
            outItems += curr.toString() + "\n";
        }
        return outItems;
    }
}
