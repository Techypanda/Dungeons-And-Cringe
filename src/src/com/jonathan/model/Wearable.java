package com.jonathan.model;

public interface Wearable {
    int getEffect();
    String getEnchantments();
    int getMax();
    int getMin();
    String getName();
    void handleEquip(Player p);
}
