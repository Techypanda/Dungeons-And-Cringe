package com.jonathan.model;

import com.jonathan.model.Character;
import com.jonathan.model.Item;

import java.util.Random;

public abstract class Potion extends Item {
    public Potion(String inName, int inCost, int inMinEffect, int inMaxEffect) {
        super(inName, inCost, inMinEffect, inMaxEffect);
    }

    @Override
    public int getEffect() { /* No need to have the sub classes override this, it works the same. */
        Random rand = new Random();
        return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
    }
    @Override public String toString() {
        return String.format("%s, Effect: %d - %d", getName(), getMin(), getMax());
    }
}
