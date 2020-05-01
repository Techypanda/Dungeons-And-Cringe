package com.jonathan.model;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class Player extends Character {
    private Map<String, Item> inventory; /* Contains The Generic Item */
    private Wearable weapon; /* For Enchantments. */
    private Wearable armour; /* For Enchantments. */
    public Player(String inName, int inHP, int inGold) {
        super(inName, inHP, inGold);
        inventory = new HashMap<>();
        weapon = new Weapon("cHANGe ThIS", 2, 2, 2, "2");
        armour = new Armour("ChAngeE thissS", 2, 2, 2, "2");
    }
    public void equip(Wearable toEquip) {
        toEquip.handleEquip(this);
    }
    @Override
    public void dealDamage(Character target) {
        int dmgVal = weapon.getEffect(); // MODIFIER NEEDS TO BE ADDED
        target.takeDamage(dmgVal);
    }
    @Override
    public void takeDamage(int inDmg) {
        int defenceVal = armour.getEffect();
        currHP = currHP - Math.max(0, inDmg - defenceVal);
    }
    @Override
    public String toString() {
        return String.format("%s, HP: %d, gold: %d, Equipped Weapon: %s, Equipped Armour: %s\nWeapon Details: %s\nArmour Details: %s",
                name, currHP, gold, weapon.getName(), armour.getName(), weapon.toString(), armour.toString());
    }
    public void setWeapon(Wearable inWeapon) {
        weapon = inWeapon;
    }
    public void setArmour(Wearable inArmour) {
        armour = inArmour;
    }
}
