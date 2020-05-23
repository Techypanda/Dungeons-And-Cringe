package com.jonathan;

import com.jonathan.controller.*;
import com.jonathan.model.DataLoader;
import com.jonathan.model.Player;
import com.jonathan.model.Shop;
import com.jonathan.view.*;

/**
 * Purpose: Starting Point For Program
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class Program {
    /**
     * Main, this is to start the game.
     * @param args commandline args, not used for this program.
     */
    public static void main(String[] args) {
        Player player = new Player();
        MainView mainViewer = new MainView();
        BattleViewer battleViewer = new BattleViewer();
        InventoryViewer invView = new InventoryViewer();
        InventoryController invController = new InventoryController(player, invView);
        BattleController battleController = new BattleController(player, battleViewer, invController);
        MenuView menuView = new MenuView();
        Shop theShop = new Shop();
        ShopViewer shopView = new ShopViewer();
        DataLoader loader = DataLoader.getLoader("exampleinput.txt");
        ShopController shopController = new ShopController(theShop, shopView, player, invController, loader);
        MenuController menuController = new MenuController(menuView, invController, battleController, shopController, player);
        MainController mainController = new MainController(battleController, invController, menuController, shopController, mainViewer);
        mainController.startControllers();
    }
}
