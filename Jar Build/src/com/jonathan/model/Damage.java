package com.jonathan.model;

/**
 * PURPOSE: This is the damage potion class, it extends potion and is so that you are able to differentiate that it is
 * a damaging potion rather than a healing potion. (No need to override getEffect as it is still the same math)
 * AUTHOR: Jonathan Wright
 * DATE: 23/05/2020
 */
public class Damage extends Potion {
    /**
     * Purpose: Alternate Constructor for creating a Damage potion, simply calls the super constructor.
     * @param inName the name of the potion
     * @param inCost the cost of the potion
     * @param inMinEffect the minimum effect of potion
     * @param inMaxEffect the maximum effect of potion
     */
    public Damage(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }

    /**
     * Purpose: Copy Constructor for creating a Damage potion, simply calls the super constructor with all fields from
     * inPotion
     * @param inItem the damage potion to copy.
     */
    public Damage(Damage inItem) {
        super(inItem.getName(), inItem.getCost(), inItem.getMin(), inItem.getMax());
    }

    /**
     * Purpose: Equals method, checks if two potions are equal.
     * @param inObject the object to compare
     * @return whether or not the object is equal (Boolean)
     */
    @Override public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof Damage) {
            Damage inD = (Damage)inObject;
            if (inD.minimumEffect == this.minimumEffect)
                if (inD.maxEffect == this.maxEffect)
                    if (inD.cost == this.cost)
                        if (inD.name.toUpperCase().equals(this.name.toUpperCase()))
                            isEquals = true;
        }
        return isEquals;
    }
}
