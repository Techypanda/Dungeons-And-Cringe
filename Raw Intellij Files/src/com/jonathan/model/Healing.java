package com.jonathan.model;

/**
 * Purpose: Healing Potion, Extends Potion
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class Healing extends Potion {
    /**
     * Constructs a Healing Potion (Alternate Constructor)
     * @param inName Name of healing potion
     * @param inCost Cost of healing potion
     * @param inMinEffect Minimum effect of healing potion
     * @param inMaxEffect maximum effect of healing potion
     */
    public Healing(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }

    /**
     * Constructs A Healing Potions (Copy Constructor)
     * @param inItem Healing potion to copy.
     */
    public Healing(Healing inItem) {
        super(inItem.getName(), inItem.getCost(), inItem.getMin(), inItem.getMax());
    }

    /**
     * Equals method, compare to objects to see if equal
     * @param inObject object to compare
     * @return whehter the objecvts are equaolsd or not
     */
    @Override public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof Healing) {
            Healing inH = (Healing)inObject;
            if (inH.minimumEffect == this.minimumEffect)
                if (inH.maxEffect == this.maxEffect)
                    if (inH.cost == this.cost)
                        if (inH.name.toUpperCase().equals(this.name.toUpperCase()))
                            isEquals = true;
        }
        return isEquals;
    }
}
