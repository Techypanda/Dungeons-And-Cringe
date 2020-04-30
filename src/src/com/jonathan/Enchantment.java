package com.jonathan;

public class Enchantment implements Wearable { /* Decorator Base Class */
    protected Wearable next;
    public Enchantment(Wearable next) {
        this.next = next;
    }
    @Override
    public int getStat() {
        return next.getStat();
    }
}
