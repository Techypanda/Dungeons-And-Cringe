package com.jonathan.model;

import com.jonathan.model.Enchantment;
import com.jonathan.model.Wearable;

public class PowerUpEnchantment extends Enchantment {
    public PowerUpEnchantment(Wearable next) {
        super(next, "Power Up Enchantment");
    }
    @Override
    public int getEffect() {
        return (int)Math.floor((double)next.getEffect() * 1.1);
    }
}
