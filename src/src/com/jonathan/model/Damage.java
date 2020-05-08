package com.jonathan.model;

public class Damage extends Potion {
    public Damage(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }
    public Damage(Damage inItem) {
        super(inItem.getName(), inItem.getCost(), inItem.getMin(), inItem.getMax());
    }
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
