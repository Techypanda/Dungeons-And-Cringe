package com.jonathan.tests;

import com.jonathan.controller.InventoryController;
import com.jonathan.controller.ShopController;
import com.jonathan.exceptions.DataLoadException;
import com.jonathan.exceptions.ShopException;
import com.jonathan.model.DataLoader;
import com.jonathan.model.Player;
import com.jonathan.model.Shop;
import com.jonathan.view.InventoryViewer;
import com.jonathan.view.ShopViewer;
// shop test
public class ShopTestHarness {
    public static void main(String[] args) {
        Shop myShop = new Shop();
        try {
            Player player = new Player();
            Shop shop = new Shop();
            ShopViewer shopView = new ShopViewer();
            InventoryViewer invView = new InventoryViewer();
            InventoryController invController = new InventoryController(player, invView);
            DataLoader loader = DataLoader.getLoader("Y:\\OOSE\\Assignment\\src\\src\\com\\jonathan\\exampleinput.txt");
            ShopController shopController = new ShopController(shop, shopView, player, invController, loader);
            shopController.beginShop();
        } catch (ShopException e) {
            System.out.println(e.getMessage());
        }
    }
}
