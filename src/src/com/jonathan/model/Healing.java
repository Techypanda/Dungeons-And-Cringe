package com.jonathan.model;

public class Healing extends Potion {
    public Healing(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }
    public Healing(Healing inItem) {
        super(inItem.getName(), inItem.getCost(), inItem.getMin(), inItem.getMax());
    }
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
