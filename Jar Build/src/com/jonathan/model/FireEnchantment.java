package com.jonathan.model;

import java.util.Random;

/**
 * Purpose: To Create a fire enchantment on a melee
 * Date: 23/05/2020
 * Author: Jonathan Wright
 */
public class FireEnchantment extends Enchantment {
    /**
     * Alternate Constructor for fire enchantment
     * @param next the weapon to enchant.
     */
    public FireEnchantment(Weapon next) {
        super(next, "Fire Enchantment");
    }

    /**
     * returns the effect of the fire enchantment + the rest of decorators.
     * @return the calculated damage
     */
    @Override
    public int getEffect() {
        Random rand = new Random();
        int roll = rand.nextInt((10 - 5) + 1) + 5;
        return roll + next.getEffect();
    }

    /**
     * Equals method to compare two objects
     * @param inObject object to comapre
     * @return whether the objects are equal.
     */
    @Override
    public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof FireEnchantment) {
            if (((FireEnchantment)inObject).next.equals(this.next))
                isEquals = true;
        }
        return isEquals;
    }
}
