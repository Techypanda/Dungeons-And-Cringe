package com.jonathan.model;
public abstract class Item implements Comparable<Item> {
    protected String name;
    protected int cost;
    protected int minimumEffect;
    protected int maxEffect;
    public Item(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        name = inName;
        cost = inCost;
        minimumEffect = inMinEffect;
        maxEffect = inMaxEffect;
    }
    public abstract String toString();
    public int getCost() { return cost; }
    public String getName() { return name; }
    public int getMax() { return maxEffect; }
    public int getMin() { return minimumEffect; }
    public abstract int getEffect();
    public int compareTo(Item other) { /* Compare By Price. */
        return Integer.compare(getCost(), other.getCost());
    }
}
