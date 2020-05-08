package com.jonathan.tests;

import com.jonathan.controller.BattleController;
import com.jonathan.controller.InventoryController;
import com.jonathan.controller.MenuController;
import com.jonathan.controller.ShopController;
import com.jonathan.model.Player;
import com.jonathan.model.Shop;
import com.jonathan.view.BattleViewer;
import com.jonathan.view.InventoryViewer;
import com.jonathan.view.MenuView;
import com.jonathan.view.ShopViewer;

public class MenuTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ShopViewer shopView = new ShopViewer();
        Player player = new Player();
        InventoryViewer invView = new InventoryViewer();
        BattleViewer battleView = new BattleViewer();
        InventoryController invController = new InventoryController(player, invView);
        MenuController menu = new MenuController(new MenuView(),
                invController,
                new BattleController(player, battleView, invController),
                new ShopController(shop, shopView, player, invController),
                player);
        try {
            menu.beginMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
