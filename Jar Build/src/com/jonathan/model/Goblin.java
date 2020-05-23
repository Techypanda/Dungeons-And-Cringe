package com.jonathan.model;
import java.util.Random;

/**
 * Purpose: Goblin Enemy
 * Date: 23/05/2020
 * Author: Jonathan Wright
 */
public class Goblin extends Enemy {
    /**
     * Default Constructor for Goblin, Constructs a goblin
     */
    public Goblin() {
        super("Goblin", 30, 20, 3, 8, 4, 8);
    }

    /**
     * Returns Goblins Damage + Special Ability Damage.
     * @return Calculated Damage
     */
    @Override
    public int getDamage() {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll <= 50) {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = "Goblin has critically hit for +3 damage on opponent.";
            return dmgVal + 3;
        } else {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = "Goblin has used basic attack on opponent.";
            return dmgVal;
        }
    }
}
