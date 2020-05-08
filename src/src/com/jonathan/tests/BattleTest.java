package com.jonathan.tests;

import com.jonathan.controller.BattleController;
import com.jonathan.controller.InventoryController;
import com.jonathan.model.*;
import com.jonathan.model.Character;
import com.jonathan.view.BattleViewer;
import com.jonathan.view.InventoryViewer;

public class BattleTest {
    public static void main(String[] args) {
        Player player = new Player();
        BattleViewer view = new BattleViewer();
        InventoryViewer invView = new InventoryViewer();
        InventoryController invControl = new InventoryController(player, invView);
        BattleController battleController = new BattleController(player, view, invControl);
        Weapon scythe = new Melee("Crescent Rose", 20, 4, 8, "Scythe");
        Armour shining = new Armour("Shining Armour", 20, 4, 8, "Leather");
        player.equip(scythe);
        player.equip(shining);
        battleController.beginBattle();
    }
}
