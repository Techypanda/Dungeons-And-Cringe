package com.jonathan;

public class PowerUpEnchantment extends Enchantment {
    public PowerUpEnchantment(Wearable next) {
        super(next);
    }
    @Override
    public int getStat() {
        return (int)Math.floor((double)next.getStat() * 1.1);
    }
}
