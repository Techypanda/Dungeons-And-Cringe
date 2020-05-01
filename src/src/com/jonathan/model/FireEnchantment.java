package com.jonathan.model;

import com.jonathan.model.Enchantment;
import com.jonathan.model.Wearable;

import java.util.Random;

public class FireEnchantment extends Enchantment {
    public FireEnchantment(Wearable next) {
        super(next, "Fire Enchantment");
    }
    @Override
    public int getEffect() {
        Random rand = new Random();
        int roll = rand.nextInt((10 - 5) + 1) + 5;
        return roll + next.getEffect();
    }
}
