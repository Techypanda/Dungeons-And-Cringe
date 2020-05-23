package com.jonathan.model;

/**
 * Purpose: The Enchantment Decorator, you can extend this to create a new enchantment easily.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class Enchantment implements Weapon {
    /* Decorator Base Class, Can be used for both Weapons & Armour. */
    protected Weapon next;
    protected String enchantmentTitle;

    /**
     * Alternate constructor for creating a new decoration.
     * @param next the next decorator (LinkedList)
     * @param enchantmentTitle the title of enchantment
     */
    public Enchantment(Weapon next, String enchantmentTitle) {
        this.next = next;
        this.enchantmentTitle = enchantmentTitle;
    }

    /**
     * Returns the cost of the weapon. (I.E the cost of enchantment isnt returned as they dont require one, it just calls
     * next.getCost() till it gets to the actual weapon.)
     * @return the cost of the weapon but not the enchantment
     */
    @Override
    public int getCost() {
        return next.getCost();
    }

    /**
     * Returns the effect of the Enchantment.
     * @return the effect of enchantment + next (Decorator.)
     */
    @Override
    public int getEffect() {
        return next.getEffect();
    }

    /**
     * Returns a string containing all enchantments
     * @return a string containing all enchantments.
     */
    @Override
    public String getEnchantments() {
        return this.enchantmentTitle;
    }

    /**
     * max effect of enchantment getter
     * @return 0, no enchantment has max or min, needed because melees are also weapons.
     */
    @Override
    public int getMax() {
        return 0;
    }

    /**
     * min effect of enchantment getter
     * @return 0, no enchantment has a min or max, needed because melees are also weapon.
     */
    @Override
    public int getMin() {
        return 0;
    }

    /**
     * Return the name of the enchantment
     * @return the name of enchantment
     */
    @Override
    public String getName() {
        return next.getName();
    }

    /**
     * Return the name of the actual weapon.
     * @return the title of the actual weapon
     */
    @Override
    public String getMeleeTitle() { return next.getMeleeTitle(); }

    /**
     * Return the type of damage the weapon deals.
     * @return the type of damage the weapon deals
     */
    @Override
    public String getDamageType() { return next.getDamageType(); }
    /**
     * return a string containing the actual weapon + all enchantments (this)
     * @return a string containing details on weapon + all enchantments
     */
    @Override
    public String toString() {
        return next.toString() + this.enchantmentTitle + ", ";
    }

    /**
     * returns the enchantments title
     * @return enchantments title - string
     */
    public String getEnchantmentTitle() {return enchantmentTitle;}

    /**
     * Equals method checks if two objects equal
     * @param inObject object to comapre
     * @return whehter obj is equal or not
     */
    @Override
    public boolean equals(Object inObject) {
        boolean equals = false;
        if (inObject instanceof Enchantment) {
            if (next.equals(((Enchantment)inObject).next))
                equals = true;
        }
        return equals;
    }
}
