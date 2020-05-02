package com.jonathan.model;

import com.jonathan.model.Enchantment;

public class PowerUpEnchantment extends Enchantment {
    public PowerUpEnchantment(Weapon next) {
        super(next, "Power Up Enchantment");
    }
    @Override
    public int getEffect() {
        return (int)Math.floor((double)next.getEffect() * 1.1);
    }
}
