package com.jonathan.model;

import com.jonathan.model.Enchantment;

import java.util.Random;

public class FireEnchantment extends Enchantment {
    public FireEnchantment(Weapon next) {
        super(next, "Fire Enchantment");
    }
    @Override
    public int getEffect() {
        Random rand = new Random();
        int roll = rand.nextInt((10 - 5) + 1) + 5;
        return roll + next.getEffect();
    }
}
