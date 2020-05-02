package com.jonathan.model;

public class Enchantment implements Weapon {
    /* Decorator Base Class, Can be used for both Weapons & Armour. */
    protected Weapon next;
    protected String enchantmentTitle;
    public Enchantment(Weapon next, String enchantmentTitle) {
        this.next = next;
        this.enchantmentTitle = enchantmentTitle;
    }
    @Override
    public int getEffect() {
        return next.getEffect();
    }
    @Override
    public String getEnchantments() {
        System.out.println(this.enchantmentTitle);
        String temp = this.enchantmentTitle;
        return temp;
    }
    @Override
    public int getMax() {
        return 0;
    }
    @Override
    public int getMin() {
        return 0;
    }
    @Override
    public String getName() {
        return this.enchantmentTitle;
    }
    public String toString() {
        return next.toString() + this.enchantmentTitle + ", ";
    }
}
