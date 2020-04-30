package com.jonathan;
public abstract class Item {
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
}
