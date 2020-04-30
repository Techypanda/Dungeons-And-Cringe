package com.jonathan;

import java.util.Random;

public class FireEnchantment extends Enchantment {
    public FireEnchantment(Wearable next) {
        super(next);
    }
    @Override
    public int getStat() {
        Random rand = new Random();
        int roll = rand.nextInt((10 - 5) + 1) + 5;
        return roll + next.getStat();
    }
}
