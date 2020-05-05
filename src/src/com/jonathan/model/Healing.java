package com.jonathan.model;

public class Healing extends Potion {
    public Healing(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }
    public Healing(Healing inItem) {
        super(inItem.getName(), inItem.getCost(), inItem.getMin(), inItem.getMax());
    }
}
