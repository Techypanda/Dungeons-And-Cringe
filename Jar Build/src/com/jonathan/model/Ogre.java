package com.jonathan.model;
import java.util.Random;

/**
 * Purpose: Ogre instance of enemy
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class Ogre extends Enemy {
    /**
     * Default Constructor for ogre.
     */
    public Ogre() {
        super("Ogre", 40, 40, 5, 10, 6, 12);
    }

    /**
     * Returns damage of the ogre with his special abilities.
     * @return calculated damage with special ability.
     */
    @Override
    public int getDamage() {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll > 20) {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = "Ogre has used basic attack on opponent.";
            return dmgVal;
        } else {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            int secondRoll = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            damageDetails = String.format("Ogre has used special ability and is attacking twice\nFirst for %d\nSecond for %d", dmgVal, secondRoll);
            dmgVal += secondRoll;
            return dmgVal;
        }
     }
}
