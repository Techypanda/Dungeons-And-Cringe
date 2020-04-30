package com.jonathan;

public class DamageEnchantment extends Enchantment { /* Basic Damage Increase, Can be used with any value. */
    private int dmgIncrease;
    public DamageEnchantment(Wearable next, int dmgIncrement) {
        super(next);
        dmgIncrease = dmgIncrement;
    }
    @Override
    public int getStat() {
        return (dmgIncrease + next.getStat()); /* This means that you can use this as a generic + increase, covers both +2 enchant and +5 aswell as any extra devs might want. */
    }
}
