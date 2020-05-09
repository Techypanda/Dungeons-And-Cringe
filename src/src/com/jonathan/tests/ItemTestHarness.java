package com.jonathan.tests;
import com.jonathan.model.*;

import java.util.*;

public class ItemTestHarness {
    public static void main(String[] args) {
        List<Item> TestInventory = new ArrayList<>();
        TestInventory.add(new Armour("Chainmail", 50, 2, 4, "Chains"));
        TestInventory.add(new Melee("Cutlass", 75, 4, 8, "Sharp"));
        TestInventory.add(new Healing("Koolaid", 20, 4, 8));
        TestInventory.add(new Damage("Poison", 20, 3, 7));
        for (Item currItem: TestInventory) {
            System.out.println(currItem.toString());
        }
        Armour shiningAm = new Armour("Chainmail", 50, 2, 4, "Chains");
        Weapon crescentRose = new Melee("Cutlass", 75, 4, 8, "Sharp");
        Player p = new Player();
        p.equip(shiningAm);
        p.equip(crescentRose);
        System.out.println(p.toString());
        crescentRose = new PowerUpEnchantment(crescentRose);
        System.out.println(crescentRose.toString());
        p.equip(crescentRose);
        System.out.println(p.toString());
        /* INVENTORY TESTS */
        Potion firstItem = new Healing("Potion Of Health", 4, 4, 4);
    }
}
