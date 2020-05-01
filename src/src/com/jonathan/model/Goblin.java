package com.jonathan.model;
import java.util.Random;
public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin", 30, 20, 3, 8, 4, 8);
    }
    @Override
    public void dealDamage(Character target) {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll <= 50) {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            target.takeDamage(dmgVal + 3);
        } else {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            target.takeDamage(dmgVal);
        }
    }
}
