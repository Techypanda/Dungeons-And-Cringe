package com.jonathan;

public class Enchantment implements Wearable, Comparable<Item> { /* Decorator Base Class */
    protected Wearable next;
    protected String enchantmentTitle;
    public Enchantment(Wearable next) {
        this.next = next;
    }
    @Override
    public int getStat() {
        return next.getStat();
    }
    @Override
    public int compareTo(Item other) { return 0; } /* There is no way to compare Enchantment. */
}
