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

/**
 * Purpose: Controller of Controller's, it just 'starts up' the controllers, links them and begins the program.
 * (Main is contained in this file, however, it constructs itself to run a non-static method for testability of the class).
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class MainController {
    private BattleController battleController;
    private InventoryController inventoryController;
    private MenuController menuController;
    private ShopController shopController;
    private MainView view;

    /**
     * Alternate Constructor for the MainController
     * @param battleController controller of battles injected
     * @param inventoryController controller of inventory injected
     * @param menuController controller of menu injected
     * @param shopController controller of shop injected
     * @param view maincontroller's view, injected
     */
    public MainController(BattleController battleController, InventoryController inventoryController, MenuController menuController,
                          ShopController shopController, MainView view) {
        this.battleController = battleController;
        this.inventoryController = inventoryController;
        this.menuController = menuController;
        this.shopController = shopController;
        this.view = view;
    }

    /**
     * Starts up the controllers and is the final error checker point, where if a exception occurs it will handle this by
     * logging and informing the user and ending, Reattempts occur in the other controllers rather than here as this point
     * is supposed to be 'point of no return' where nothing can be done.
     */
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
                view.errorLogged();
            } catch (IOException f) {
                view.failErrorLogged();
            }
        }
    }
}
