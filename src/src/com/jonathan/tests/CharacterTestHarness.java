package com.jonathan.tests;

import com.jonathan.model.*;
import com.jonathan.model.Character;

public class CharacterTestHarness {
    public static void main(String[] args) {
        Player player = new Player();
        Character slime = new Slime();
        Character goblin = new Goblin();
        Character ogre = new Ogre();
        Character dragon = new Dragon();
        Weapon crescentRose = new Melee("Crescent Rose", 20, 40, 80, "Sword");
        Armour shiningStar = new Armour("Shining Star", 20, 32, 44, "Shiny");
        player.addItem(crescentRose);
        player.addItem(shiningStar);
        player.equip(crescentRose);
        player.equip(shiningStar);
        System.out.println(player.toString());
        player.equip(new DamageEnchantment(new PowerUpEnchantment(new FireEnchantment(player.removeWeapon(player.getHeldWeapon()))), 2));
        System.out.println(player.toString());
    }
}
