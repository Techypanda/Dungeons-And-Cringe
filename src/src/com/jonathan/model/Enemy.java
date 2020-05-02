package com.jonathan.model;
import java.util.Random;
import java.lang.Math;
public abstract class Enemy extends Character {
    protected int[] damage;
    protected int[] defence;
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
    @Override
    public int getDamage() { // Override again for ability.
        Random rand = new Random();
        int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
        return dmgVal;
    }
    @Override
    public int takeDamage(int inDmg) { // Override again for ability.
        Random rand = new Random();
        int armourVal = rand.nextInt((defence[1] - defence[0]) + 1) + defence[0];
        int damageTaken = Math.max(0, inDmg - armourVal);
        currHP = currHP - damageTaken;
        if (currHP < 0)
            currHP = 0; /* Cant go negative, you are already dead. */
        return damageTaken;
    }
    @Override
    public String toString() {
        return String.format("%s, HP: %d, GoldValue: %d, Damage: %d - %d, Defence: %d - %d",
        name, currHP, gold, damage[0], damage[1], defence[0], defence[1]);
    }
}
