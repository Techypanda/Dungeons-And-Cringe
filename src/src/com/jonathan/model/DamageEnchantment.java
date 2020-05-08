package com.jonathan.model;

import com.jonathan.model.Enchantment;

public class DamageEnchantment extends Enchantment { /* Basic Damage Increase, Can be used with any value. */
    private int dmgIncrease;
    public DamageEnchantment(Weapon next, int dmgIncrement) {
        super(next, String.format("Damage Enchantment (+%d)", dmgIncrement));
        dmgIncrease = dmgIncrement;
    }
    @Override
    public int getEffect() {
        return (dmgIncrease + next.getEffect()); /* This means that you can use this as a generic + increase, covers both +2 enchant and +5 aswell as any extra devs might want. */
    }
    @Override
    public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof DamageEnchantment) {
            if (((DamageEnchantment)inObject).next.equals(this.next))
                isEquals = true;
        }
        return isEquals;
    }
}
