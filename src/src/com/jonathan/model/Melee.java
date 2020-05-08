package com.jonathan.model;

import java.util.Random;

public class Melee extends Item implements Weapon {
    private String type;
    public Melee(String inName, int inCost, int inMinEffect, int inMaxEffect, String inType) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        type = inType;
    }
    public Melee(Melee inWeapon) {
        super(inWeapon.getName(), inWeapon.getCost(), inWeapon.getMin(), inWeapon.getMax());
        type = inWeapon.type;
    }
    @Override
    public String toString() {
        return String.format("%s, Damage Type: %s, Cost: %d, Damage: %d - %d, Enchantments: ", name, type, cost,
        minimumEffect, maxEffect);
    }
    @Override
    public int getEffect() {
        Random rand = new Random();
        return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
    }
    @Override
    public String getEnchantments() {
        return ""; /* The Decorators will append to this. */
    }
    @Override
    public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof Melee) {
            Melee inMelee = (Melee)inObject;
            if (inMelee.type.toUpperCase().equals(this.type.toUpperCase()))
                if (this.maxEffect == inMelee.maxEffect)
                    if (this.minimumEffect == inMelee.minimumEffect)
                        if (this.name.toUpperCase().equals(inMelee.name.toUpperCase()))
                            if (this.cost == inMelee.cost)
                                isEquals = true;
        }
        return isEquals;
    }
    @Override
    public String getMeleeTitle() {
        return this.name;
    }
}
