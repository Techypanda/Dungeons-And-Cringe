package com.jonathan.model;

import com.jonathan.model.Character;
import com.jonathan.model.Item;

import java.util.Random;

public class Potion extends Item {
    private char type; /* Harming Or Healing */
    public Potion(String inName, int inCost, int inMinEffect, int inMaxEffect, char type) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        this.type = type;
    }

    @Override
    public int getEffect() { /* Rather than distingushing Health and Harming could just make the formula a passed in function? */
        Random rand = new Random();
        if (type == 'H' || type == 'h') {
            return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
        } else { /* Assume That The Potion is a potion of damage. */
            return (rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect) * -1;
        }
    }
    @Override
    public String toString() {
        if (type == 'H')
            return String.format("%s, Healing: %d - %d%n", name, minimumEffect, maxEffect);
        return String.format("%s, Damage: %d - %d%n", name, minimumEffect, maxEffect);
    }
}
