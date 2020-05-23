package com.jonathan.model;

import java.util.Random;

/**
 * Purpose: The Potion Superclass.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public abstract class Potion extends Item {
    /**
     * Alternate Constructor for Potions
     * @param inName name of potion
     * @param inCost cost of potion
     * @param inMinEffect minimum effect of potion
     * @param inMaxEffect maximum effect of potion
     */
    public Potion(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }

    /**
     * Returns the effect of the potions
     * @return calculated effect
     */
    @Override
    public int getEffect() { /* No need to have the sub classes override this, it works the same. */
        Random rand = new Random();
        return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
    }

    /**
     * Returns a string detailing the potion.
     * @return string detailing potion
     */
    @Override public String toString() {
        return String.format("%s, Cost: %d, Effect: %d - %d", getName(), getCost(), getMin(), getMax());
    }
}
