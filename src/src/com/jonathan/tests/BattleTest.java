package com.jonathan.tests;

import com.jonathan.controller.BattleController;
import com.jonathan.model.Armour;
import com.jonathan.model.Melee;
import com.jonathan.model.Player;
import com.jonathan.model.Weapon;
import com.jonathan.model.Character;

public class BattleTest {
    public static void main(String[] args) {
        BattleController battleController = new BattleController();
        Player player = new Player();
        Weapon scythe = new Melee("Crescent Rose", 20, 4, 8, "Scythe");
        Armour shining = new Armour("Shining Armour", 20, 4, 8, "Leather");
        player.equip(scythe);
        player.equip(shining);
        battleController.beginBattle(player);
    }
}
