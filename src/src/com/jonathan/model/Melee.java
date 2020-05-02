package com.jonathan.model;

import java.util.Random;

public class Melee extends Item implements Weapon {
    private String type;
    public Melee(String inName, int inCost, int inMinEffect, int inMaxEffect, String inType) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        type = inType;
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
}
