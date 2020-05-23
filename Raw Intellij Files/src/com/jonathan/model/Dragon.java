package com.jonathan.model;
import java.util.Random;

/**
 * PURPOSE: A Dragon Enemy that extends Enemy
 * AUTHOR: Jonathan Wright
 * DATE: 23/05/2020
 */
public class Dragon extends Enemy {
    /**
     * Purpose: Constructs a Dragon Enemy using no parameters for convience.
     */
    public Dragon() {
        super("Dragon", 100, 100, 15, 30, 15, 20);
    }

    /**
     * Returns the damage of dragon, this is where special abilities for enemys are calculated and added on, I chose this
     * over a decorator as not all enemies will have special abilities.
     * @return the calculated damage.
     */
    @Override
    public int getDamage() {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll <= 10) {
            // DOUBLE DAMAGE
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = "Dragon has used special ability and is dealing double damage!";
            return dmgVal * 2;
        } else if (roll >= 11 && roll <= 35) {
            // RECOVER
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = "Dragon has used special ability and is healing for 10 hp!";
            currHP += 10;
            if (currHP > maxHP) currHP = maxHP;
            return dmgVal;
        } else {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = "Dragon has used basic attack on opponent";
            return dmgVal;
        }
    }
}
