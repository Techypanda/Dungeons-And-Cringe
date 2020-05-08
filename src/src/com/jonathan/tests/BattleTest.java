package com.jonathan.tests;

import com.jonathan.controller.BattleController;
import com.jonathan.model.*;
import com.jonathan.model.Character;
import com.jonathan.view.BattleViewer;

public class BattleTest {
    public static void main(String[] args) {
        Player player = new Player();
        BattleViewer view = new BattleViewer();
        BattleController battleController = new BattleController(player, view);
        Weapon scythe = new Melee("Crescent Rose", 20, 4, 8, "Scythe");
        Armour shining = new Armour("Shining Armour", 20, 4, 8, "Leather");
        player.equip(scythe);
        player.equip(shining);
        battleController.beginBattle();
    }
}
