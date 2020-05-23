package com.jonathan.model;

/**
 * Purpose: Superclass for Items
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public abstract class Item implements Comparable<Item> {
    protected String name;
    protected int cost;
    protected int minimumEffect;
    protected int maxEffect;

    /**
     * Alternate Constructor for items.
     * @param inName name of item
     * @param inCost cost of item
     * @param inMinEffect minimum effect of item
     * @param inMaxEffect maximum effect of item
     */
    public Item(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        name = inName;
        cost = inCost;
        minimumEffect = inMinEffect;
        maxEffect = inMaxEffect;
    }

    /**
     * return a string detailing the item
     * @return a string detailing the item
     */
    public abstract String toString();

    /**
     * cost getter
     * @return cost
     */
    public int getCost() { return cost; }

    /**
     * name getter
     * @return name
     */
    public String getName() { return name; }

    /**
     * max getter
     * @return max
     */
    public int getMax() { return maxEffect; }

    /**
     * min getter
     * @return min
     */
    public int getMin() { return minimumEffect; }

    /**
     * Calculates the effect of item.
     * @return calculated effect
     */
    public abstract int getEffect();

    /**
     * For sorting, tells java how to compare two items.
     * @param other item to compare to
     * @return an integer representing whether its greater less or equal.
     */
    public int compareTo(Item other) { /* Compare By Price. */
        return Integer.compare(getCost(), other.getCost());
    }

    /**
     * Equals method, returns whether two objects equal
     * @param inObject object to compare to
     * @return whether objects equal.
     */
    public abstract boolean equals(Object inObject);
}
