package com.jonathan.model;
import java.util.Random;
public class Dragon extends Enemy {
    public Dragon() {
        super("Dragon", 100, 100, 15, 30, 15, 20);
    }
    @Override
    public void dealDamage(Character target) {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll <= 10) {
            // DOUBLE DAMAGE
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            target.takeDamage(dmgVal * 2);
        } else if (roll >= 11 && roll <= 35) {
            // RECOVER
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            target.takeDamage(dmgVal);
            currHP += 10;
            if (currHP > maxHP) currHP = maxHP;
        } else {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            target.takeDamage(dmgVal);
        }
    }
}
