package com.jonathan.model;

import com.jonathan.model.Item;
import com.jonathan.model.Wearable;

public class Enchantment implements Wearable { /* Decorator Base Class */
    protected Wearable next;
    protected String enchantmentTitle;
    public Enchantment(Wearable next, String enchantmentTitle) {
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
    @Override
    public void handleEquip(Player p) {
        p.setWeapon(this);
    }
}
