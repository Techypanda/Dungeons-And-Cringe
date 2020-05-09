package com.jonathan.controller;

import com.jonathan.exceptions.MenuException;
import com.jonathan.model.DataLoader;
import com.jonathan.model.Player;
import com.jonathan.model.Shop;
import com.jonathan.view.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainController {
    private BattleController battleController;
    private InventoryController inventoryController;
    private MenuController menuController;
    private ShopController shopController;
    private MainView view;
    public MainController(BattleController battleController, InventoryController inventoryController, MenuController menuController,
                          ShopController shopController, MainView view) {
        this.battleController = battleController;
        this.inventoryController = inventoryController;
        this.menuController = menuController;
        this.shopController = shopController;
        this.view = view;
    }
    public void startControllers() {
        try {
            menuController.beginMenu();
        }
        catch (MenuException e) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd,HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            view.notifyError(e.getMessage());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("error.txt", true))) {
                bw.write(
                        String.format(
                                "------------ ERROR OCCURED DATE: %s ------------\n", dtf.format(now)
                        ) + String.format(
                                "Details: %s\nCause: %s\nStack Trace: %s\n----------------------------------------------------------------------------------------------",
                                e.getMessage(), e.getCause(), e.toString()
                        )
                );
                bw.newLine();
                view.errorLogged(true);
            } catch (IOException f) {
                view.errorLogged(false);
            }
        }
    }
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
