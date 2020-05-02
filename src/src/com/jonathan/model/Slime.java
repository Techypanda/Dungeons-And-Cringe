package com.jonathan.model;
import java.util.Random;
public class Slime extends Enemy {
    public Slime() {
        super("Slime", 10, 10, 3, 5, 0, 2);
    }
    @Override
    public int getDamage() {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll > 20) {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            return dmgVal;
        } else {
            return 0;
        }
    }
}
