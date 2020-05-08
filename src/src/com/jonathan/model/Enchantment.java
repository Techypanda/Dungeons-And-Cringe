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
    public int getCost() {
        return next.getCost();
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
        return next.getName();
    }
    @Override
    public String getMeleeTitle() { return next.getMeleeTitle(); }
    @Override
    public String toString() {
        return next.toString() + this.enchantmentTitle + ", ";
    }
    public String getEnchantmentTitle() {return enchantmentTitle;}
    @Override
    public boolean equals(Object inObject) {
        boolean equals = false;
        if (inObject instanceof Enchantment) {
            if (next.equals(((Enchantment)inObject).next))
                equals = true;
        }
        return equals;
    }
}
