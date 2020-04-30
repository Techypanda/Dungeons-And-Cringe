package com.jonathan;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
public class Player extends Character {
    private ArrayList<Item> inventory; /* Contains The Generic Item */
    private Weapon weapon;
    private Armour armour;
    private Wearable weaponHandler; /* For Enchantments. */
    private Wearable armourHandler; /* For Enchantments. */
    public Player(String inName, int inHP, int inGold) {
        super(inName, inHP, inGold);
        inventory = new ArrayList<>();
    }
    public void equip(Weapon weapon) {
        this.weapon = weapon;
        this.weaponHandler = this.weapon;
    }
    public void equip(Armour armour) {
        this.armour = armour;
        this.armourHandler = this.armour;
    }
    @Override
    public void dealDamage(Character target) {
        int dmgVal = weaponHandler.getStat(); // MODIFIER NEEDS TO BE ADDED
        target.takeDamage(dmgVal);
    }
    @Override
    public void takeDamage(int inDmg) {
        int defenceVal = armourHandler.getStat();
        currHP = currHP - Math.max(0, inDmg - defenceVal);
    }
    @Override
    public String toString() {
        return String.format("%s, HP: %d, gold: %d, Equipped Weapon: %s, Equipped Armour: %s\nWeapon Damage: %d - %d\nArmour Defence: %d - %d",
                name, currHP, gold, weapon.getName(), armour.getName(), weapon.getMin(), weapon.getMax(), armour.getMin(),
                armour.getMax());
    }
}
