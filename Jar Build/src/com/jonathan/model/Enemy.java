package com.jonathan.model;
import java.util.Random;
import java.lang.Math;

/**
 * Purpose: Superclass for enemies. (AI)
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public abstract class Enemy extends Character {
    protected int[] damage;
    protected int[] defence;

    /**
     * Alternate constructor for enemies
     * @param inName name of the enemy
     * @param inHP hp of the enemy
     * @param inGold gold of the enemy
     * @param minDamage minimum damage of enemy
     * @param maxDamage maxmimum damage of enemy
     * @param minDefence minimum defence of enemy
     * @param maxDefence maxmimum defence of enemy
     */
    public Enemy(String inName, int inHP, int inGold, int minDamage, int maxDamage, int minDefence,
    int maxDefence) {
        super(inName, inHP, inGold);
        damage = new int[2];
        defence = new int[2];
        damage[0] = minDamage;
        damage[1] = maxDamage;
        defence[0] = minDefence;
        defence[1] = maxDefence;
    }

    /**
     * Return the default implementation of getting damage, if you wish for a special ability you would extend this in
     * the subclass.
     * @return calculated damage
     */
    @Override
    public int getDamage() { // Override again for ability.
        Random rand = new Random();
        damageDetails = name + " has used basic attack on opponent.";
        int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
        return dmgVal;
    }

    /**
     * Return the default implementation of taking damage, if you wish for a special ability you would extend this in
     * the subclass.
     * @param inDmg the damage to take
     * @return calculated damage taken.
     */
    @Override
    public int takeDamage(int inDmg) { // Override again for ability.
        Random rand = new Random();
        int armourVal = rand.nextInt((defence[1] - defence[0]) + 1) + defence[0];
        int damageTaken = Math.max(0, inDmg - armourVal);
        currHP = currHP - damageTaken;
        if (currHP < 0) {
            currHP = 0; /* Cant go negative, you are already dead. */
        }
        return damageTaken;
    }

    /**
     * String describing the enemy
     * @return string that describes the enemy.
     */
    @Override
    public String toString() {
        return String.format("%s, HP: %d, GoldValue: %d, Damage: %d - %d, Defence: %d - %d",
        name, currHP, gold, damage[0], damage[1], defence[0], defence[1]);
    }
}
