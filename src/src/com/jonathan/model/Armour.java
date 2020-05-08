package com.jonathan.model;

import java.util.Random;

public class Armour extends Item {
    private String material;
    public Armour(String inName, int inCost, int inMinEffect, int inMaxEffect, String inMaterial) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        material = inMaterial;
    }
    public Armour(Armour inItem) {
        super(inItem.getName(), inItem.getCost(), inItem.getMin(), inItem.getMax());
        material = inItem.material;
    }
    @Override
    public String toString() {
        return String.format("%s, Material: %s, Cost: %d, Armour: %d - %d", name, material, cost,
        minimumEffect, maxEffect);
    }
    @Override
    public int getEffect() {
        Random rand = new Random();
        return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
    }
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
