package com.jonathan.model;

import java.util.Random;

public class Weapon extends Item implements Wearable  {
    private String type;
    public Weapon(String inName, int inCost, int inMinEffect, int inMaxEffect, String inType) {
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
    @Override
    public void handleEquip(Player p) {
        p.setWeapon(this);
    }
}
