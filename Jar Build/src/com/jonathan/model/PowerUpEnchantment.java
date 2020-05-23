package com.jonathan.model;

/**
 * Purpose: The powerup enchantment that extends enchantment (Decorator)
 * Date: 23/05/2020
 * Author: Jonathan Wright
 */
public class PowerUpEnchantment extends Enchantment {
    /**
     * Alternate constructor for powerup enchantment
     * @param next the weapon to enchant
     */
    public PowerUpEnchantment(Weapon next) {
        super(next, "Power Up Enchantment");
    }

    /**
     * Returns the effect of powerUp and then all other decorators.
     * @return effect of powerup + all other decorators
     */
    @Override
    public int getEffect() {
        return (int)Math.floor((double)next.getEffect() * 1.1);
    }

    /**
     * Compares to objects to see if they are equal
     * @param inObject object to comapre
     * @return whether objects are equal or not.
     */
    @Override
    public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (((PowerUpEnchantment)inObject).next.equals(this.next))
            isEquals = true;
        return isEquals;
    }
}
