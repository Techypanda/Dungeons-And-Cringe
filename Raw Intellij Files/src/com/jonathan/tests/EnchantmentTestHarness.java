package com.jonathan.tests;

import com.jonathan.model.*;
// enchant test
public class EnchantmentTestHarness {
    public static void main(String[] args) {
        Weapon crescentRose = new Melee("Crescent Rose", 10, 10, 12, "slashing", "scythe");
        System.out.println("Curr Dmg: " + crescentRose.getEffect());
        System.out.println(crescentRose.toString());
        crescentRose = new DamageEnchantment(crescentRose, 2);
        System.out.println("Curr Dmg: " + crescentRose.getEffect());
        System.out.println(crescentRose.toString());
        crescentRose = new DamageEnchantment(crescentRose, 5);
        System.out.println("Curr Dmg: " + crescentRose.getEffect());
        System.out.println(crescentRose.toString());
        crescentRose = new FireEnchantment(crescentRose);
        System.out.println("Curr Dmg: " + crescentRose.getEffect());
        System.out.println(crescentRose.toString());
        crescentRose = new PowerUpEnchantment(crescentRose);
        System.out.println("Curr Dmg: " + crescentRose.getEffect());
        System.out.println(crescentRose.toString());
    }
}
