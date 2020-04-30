package com.jonathan;

public class EnchantmentTestHarness {
    public static void main(String[] args) {
        Wearable crescentRose = new Weapon("Crescent Rose", 10, 10, 12, "Scythe");
        System.out.println("Curr Dmg: " + crescentRose.getStat());
        crescentRose = new DamageEnchantment(crescentRose, 5);
        System.out.println("Curr Dmg: " + crescentRose.getStat());
        crescentRose = new FireEnchantment(crescentRose);
        System.out.println("Curr Dmg: " + crescentRose.getStat());
    }
}
