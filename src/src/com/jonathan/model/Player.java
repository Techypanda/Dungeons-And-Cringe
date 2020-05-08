package com.jonathan.model;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    /* private Map<String, Item> inventory; Why I chose not to implement it this way is covered in the docs, basically
    * I cant think of a good way with containing just the items to seperate into potions sword and armour  */
    private List<Weapon> weapons;
    private List<Armour> armours;
    private List<Damage> damagePotions;
    private List<Healing> healingPotions;
    private Weapon weapon; /* For Enchantments. */
    private Armour armour; /* For Enchantments. */
    public Player() {
        super("The Player", 30, 100);
        weapon = new Melee("No Weapon", 0, 0, 0, "Fists");
        armour = new Armour("No Armour", 0, 0, 0, "Bare Skin");
        weapons = new ArrayList<>();
        armours = new ArrayList<>();
        damagePotions = new ArrayList<>();
        healingPotions = new ArrayList<>();
    }
    public Player(String inName, int inHP, int inGold, Weapon inWeapon, Armour inArmour) {
        super(inName, inHP, inGold);
        weapon = inWeapon;
        armour = inArmour;
        weapons = new ArrayList<>();
        armours = new ArrayList<>();
    }
    @Override
    public int getDamage() {
        int dmgVal = weapon.getEffect(); // MODIFIER NEEDS TO BE ADDED
        return dmgVal;
    }
    @Override
    public int takeDamage(int inDmg) {
        int defenceVal = armour.getEffect();
        int damageToTake = Math.max(0, inDmg - defenceVal);
        currHP = currHP - damageToTake;
        if (currHP < 0)
            currHP = 0; /* Cant go negative, you are already dead. */
        return damageToTake;
    }
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
    public void equip(Weapon toEquip) {
        weapon = toEquip;
    }
    public void equip(Armour toEquip) {
        armour = toEquip;
    }
    public void addItem(Weapon inWeapon) {
        weapons.add(inWeapon);
    }
    public void addItem(Armour inArmour) {
        armours.add(inArmour);
    }
    public void addItem(Damage inPotion) { damagePotions.add(inPotion); }
    public void addItem(Healing inPotion) { healingPotions.add(inPotion); }
    public String showWeapons() {
        return invCollection(weapons.toArray(new Weapon[0]));
    }
    public Weapon removeWeapon(Weapon inWeapon) {
        if (weapons.remove(inWeapon))
            return inWeapon;
        else
            return null;
    }
    public Armour removeArmour(Armour inArmour) {
        if (armours.remove(inArmour))
            return inArmour;
        else
            return null;
    }
    public boolean hasPotions() {
        return (healingPotions.size() != 0) && (damagePotions.size() != 0);
    }
    public Potion removePotion(Potion p) {
        if (damagePotions.remove(p) || healingPotions.remove(p))
            return p;
        else
            return null;
    }
    public Weapon[] getWeapon(String inWeaponTitle) {
        ArrayList<Weapon> weaponList = new ArrayList<>();
        for (Weapon currWeapon: weapons) {
            if (currWeapon.getMeleeTitle().toUpperCase().equals(inWeaponTitle.toUpperCase())) {
                weaponList.add(currWeapon);
            }
        }
        return weaponList.toArray(new Weapon[0]);
    }
    public Armour[] getArmour(String inArmourTitle) {
        ArrayList<Armour> armourList = new ArrayList<>();
        for (Armour currArmour: armours) {
            if (currArmour.getName().toUpperCase().equals(inArmourTitle.toUpperCase())) {
                armourList.add(currArmour);
            }
        }
        return armourList.toArray(new Armour[0]);
    }
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
    public Damage[] getDamagePotion(String inPotionTitle) {
        ArrayList<Damage> potionList = new ArrayList<>();
        for (Damage currPotion: damagePotions) {
            if (currPotion.getName().toUpperCase().equals(inPotionTitle.toUpperCase())) {
                potionList.add(currPotion);
            }
        }
        return potionList.toArray(new Damage[0]);
    }
    public Healing[] getHealingPotion(String inPotionTitle) {
        ArrayList<Healing> potionList = new ArrayList<>();
        for (Healing currPotion: healingPotions) {
            if (currPotion.getName().toUpperCase().equals(inPotionTitle.toUpperCase())) {
                potionList.add(currPotion);
            }
        }
        return potionList.toArray(new Healing[0]);
    }
    public Weapon getHeldWeapon() {
        return weapon;
    }
    public Armour getHeldArmour() {
        return armour;
    }
    public String showArmour() {
        return invCollection(armours.toArray(new Item[0]));
    }
    public String showPotions() {
        return invCollection(damagePotions.toArray(new Damage[0])) + invCollection(healingPotions.toArray(new Healing[0]));
    }
    private Item find(List<Item> inList, String name) {
        for (Item curr: inList) {
            if (curr.getName().toUpperCase().equals(name.toUpperCase()))
                return curr;
        }
        return null;
    }
    private String invCollection(Item[] items) {
        String outItems = "";
        for (Item curr: items) {
            outItems += curr.toString() + "\n";
        }
        return outItems;
    }
    private String invCollection(Weapon[] items) { // Decorators dont extend item.
        String outItems = "";
        for (Weapon curr: items) {
            outItems += curr.toString() + "\n";
        }
        return outItems;
    }

}
