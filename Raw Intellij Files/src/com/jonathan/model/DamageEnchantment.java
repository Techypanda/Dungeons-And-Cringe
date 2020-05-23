package com.jonathan.model;

/**
 * Purpose: To be the damage enchantment (You get to choose the + amount, modular as it makes sense.)
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class DamageEnchantment extends Enchantment { /* Basic Damage Increase, Can be used with any value. */
    private int dmgIncrease;

    /**
     * Alternate constructor for the damage enchantment
     * @param next the weapon to decorate.
     * @param dmgIncrement the damage increment i.e +2 for damage +2, +3 for damage +3, etc...
     */
    public DamageEnchantment(Weapon next, int dmgIncrement) {
        super(next, String.format("Damage Enchantment (+%d)", dmgIncrement));
        dmgIncrease = dmgIncrement;
    }

    /**
     * Get the calculated effect decoration
     * @return it's dmgIncrement + the next decorator + ...
     */
    @Override
    public int getEffect() {
        return (dmgIncrease + next.getEffect()); /* This means that you can use this as a generic + increase, covers both +2 enchant and +5 aswell as any extra devs might want. */
    }

    /**
     * Equals method to compare this to something else
     * (unsure if this REALLY works because its a decorator and this really hurts my brain to think about)
     * @param inObject the object to compare to
     * @return whether the objects are equal
     */
    @Override
    public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof DamageEnchantment) {
            if (((DamageEnchantment)inObject).next.equals(this.next))
                isEquals = true;
        }
        return isEquals;
    }
}
