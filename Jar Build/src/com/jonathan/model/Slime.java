package com.jonathan.model;
import java.util.Random;

/**
 * PURPOSE: A Slime Enemy extension of Enemy
 * DATE: 23/05/2020
 * AUTHOR: Jonathan Wright
 */
public class Slime extends Enemy {
    /**
     * Default Cosntructr of slime
     */
    public Slime() {
        super("Slime", 10, 10, 3, 5, 0, 2);
    }

    /**
     * Returns slime's damage and his special ability.
     * @return slimes damage + special ability
     */
    @Override
    public int getDamage() {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll > 20) {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = "Slime has used basic attack on opponent.";
            return dmgVal;
        } else {
            damageDetails = "Slime has missed and dealt no damage.";
            return 0;
        }
    }
}
