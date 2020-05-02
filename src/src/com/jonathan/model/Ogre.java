package com.jonathan.model;
import java.util.Random;
public class Ogre extends Enemy {
    public Ogre() {
        super("Ogre", 40, 40, 5, 10, 6, 12);
    }
    @Override
    public int getDamage() {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll > 20) {
              int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
              return dmgVal;
        } else {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            dmgVal += rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            return dmgVal;
        }
     }
}
