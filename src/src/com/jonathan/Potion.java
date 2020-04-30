package com.jonathan;
public interface Potion extends Comparable<Item> {
    void effect(Character target);
    int getCost();
    String getName();
}
