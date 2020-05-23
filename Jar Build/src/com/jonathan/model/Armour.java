package com.jonathan.model;
import java.util.Random;

/**
 * Purpose: Defensive Item (Armour) that extends Item to be worn by player.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class Armour extends Item {
    private String material;

    /**
     * Alternate Constructor for armour.
     * @param inName the name of armour
     * @param inCost the cost of armour
     * @param inMinEffect the minimum effect of armour
     * @param inMaxEffect the maximum effect of armour
     * @param inMaterial the material of the armour
     */
    public Armour(String inName, int inCost, int inMinEffect, int inMaxEffect, String inMaterial) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        material = inMaterial;
    }

    /**
     * Copy Constructor for armour.
     * @param inItem the armour to copy
     */
    public Armour(Armour inItem) {
        super(inItem.getName(), inItem.getCost(), inItem.getMin(), inItem.getMax());
        material = inItem.material;
    }

    /**
     * Return a description of the armour.
     * @return String description of armour.
     */
    @Override
    public String toString() {
        return String.format("%s, Material: %s, Cost: %d, Armour: %d - %d", name, material, cost,
        minimumEffect, maxEffect);
    }

    /**
     * Return the calculated effect of armour.
     * @return effect of armour.
     */
    @Override
    public int getEffect() {
        Random rand = new Random();
        return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
    }

    /**
     * Return whether the object is equal or not (Equals Method)
     * @param inObject the object to compare
     * @return whether the object is the same or not.
     */
    @Override public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof Armour) {
            Armour a = (Armour)inObject;
            if (a.material.toUpperCase().equals(this.material.toUpperCase()))
                if (a.minimumEffect == this.minimumEffect)
                    if (a.maxEffect == this.maxEffect)
                        if (a.cost == this.cost)
                            if (a.name.toUpperCase().equals(this.name.toUpperCase()))
                                isEquals = true;
        }
        return isEquals;
    }
}
