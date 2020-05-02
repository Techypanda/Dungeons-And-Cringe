package com.jonathan.model;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class Player extends Character {
    /* private Map<String, Item> inventory; Why I chose not to implement it this way is covered in the docs, basically
    * I cant think of a good way with containing just the items to seperate into potions sword and armour  */
    private Map<String, Weapon> weapons;
    private Map<String, Armour> armours;
    private Map<String, Potion> potions;
    private Weapon weapon; /* For Enchantments. */
    private Armour armour; /* For Enchantments. */
    public Player(String inName, int inHP, int inGold) {
        super(inName, inHP, inGold);
        weapon = new Melee("cHANGe ThIS", 2, 2, 2, "2");
        armour = new Armour("ChAngeE thissS", 2, 2, 2, "2");
        weapons = new HashMap<>();
        armours = new HashMap<>();
        potions = new HashMap<>();
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
        weapons.put(inWeapon.getName(), inWeapon);
    }
    public void addItem(Armour inArmour) {
        armours.put(inArmour.getName(), inArmour);
    }
    public void addItem(Potion inPotion) {
        potions.put(inPotion.getName(), inPotion);
    }
    public Weapon removeWeapon() {
        return weapons.remove(weapon.getName());
    }
}
