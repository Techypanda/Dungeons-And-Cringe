package com.jonathan;

import java.util.Random;

public class Weapon extends Item implements Wearable  {
    private String type;
    public Weapon(String inName, int inCost, int inMinEffect, int inMaxEffect, String inType) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        type = inType;
    }
    @Override
    public String toString() {
        return String.format("%s, Damage Type: %s, Cost: %d, Damage: %d - %d", name, type, cost,
        minimumEffect, maxEffect);
    }
    @Override
    public int getStat() {
        Random rand = new Random();
        return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
    }
}
