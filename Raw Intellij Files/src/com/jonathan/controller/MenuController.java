package com.jonathan.controller;

import com.jonathan.exceptions.MenuException;
import com.jonathan.exceptions.ShopException;
import com.jonathan.model.Player;
import com.jonathan.view.MenuView;

/**
 * Purpose: Controls the menu.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class MenuController {
    private Player player;
    private MenuView view;
    private InventoryController invController;
    private BattleController battleController;
    private ShopController shopController;

    /**
     * Alternate constructor for menu controller
     * @param view the view for menu injected
     * @param invController the controller for inventory injected
     * @param battleController the controller for battle injected
     * @param shopController the controller for shop injected
     * @param player the player injected
     */
    public MenuController(MenuView view, InventoryController invController, BattleController battleController,
                          ShopController shopController, Player player) {
        this.player = player;
        this.view = view;
        this.invController = invController;
        this.battleController = battleController;
        this.shopController = shopController;
    }

    /**
     * Begins the menu
     * @throws MenuException occurs only if an exception that cant be handled in IO occurs, passes it up to the main controller.
     */
    public void beginMenu() throws MenuException {
        int response = -1;
        try {
            while (response != 6) {
                if (player.getHP() > 0) {
                    view.outStats(player.toString());
                    response = view.getMenuChoice();
                    switch (response) {
                        case 1:
                            shopController.beginShop();
                            break;
                        case 2:
                            changeName();
                            break;
                        case 3:
                            invController.changeWeapon();
                            break;
                        case 4:
                            invController.changeArmour();
                            break;
                        case 5:
                            battleController.beginBattle();
                            break;
                    }
                } else {
                    response = 6;
                    view.gameOver();
                }
            }
        } catch (ShopException e) {
            throw new MenuException(e);
        }
    }

    /**
     * Changes name of player -- private method
     */
    private void changeName() {
        String name = view.namePrompt();
        String finalName = "";
        for (String temp: name.split(" ")) {
            finalName += temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase() + " ";
        }
        finalName = finalName.substring(0, finalName.length() - 1);
        player.setName(finalName);
    }
}
