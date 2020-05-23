package com.jonathan.model;

/**
 * PURPOSE: Weapon Interface, Melee isa weapon but also isa item, whereas an enchantment isa weapon (and potentially in
 * future isa defensive for defensive enchants)
 * AUTHOR: Jonathan Wright
 * DATE: 23/05/2020
 */
public interface Weapon {
    int getEffect();
    String getEnchantments();
    int getMax();
    int getMin();
    int getCost();
    String getName();
    String getMeleeTitle();
    boolean equals(Object inObject);
    String getDamageType();
}
