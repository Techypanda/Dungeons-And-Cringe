package com.jonathan;
public class Healing extends Item implements Potion {
    public Healing(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }
    @Override
    public void effect(Character target) {
        System.out.println("Healing Potion!");
    }
    @Override
    public String toString() {
        return String.format("%s Healing Potion, Cost: %d, Heal: %d - %d", name, cost,
        minimumEffect, maxEffect);
    }
    @Override
    public int compareTo(Item other) { /* Compare By Price. */
        return Integer.compare(getCost(), other.getCost());
    }
}
