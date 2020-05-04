package com.jonathan.controller;

import com.jonathan.exceptions.DataLoadException;
import com.jonathan.exceptions.ShopException;
import com.jonathan.model.*;
import com.jonathan.view.ShopViewer;

public class ShopController {
    private Shop shop;
    private ShopViewer view;
    private Player player;
    private InventoryController invController;
    public ShopController(Shop inShop, ShopViewer inView, Player thePlayer, InventoryController invController) {
        shop = inShop;
        view = inView;
        player = thePlayer;
        this.invController = invController;
    }
    public void beginShop() throws ShopException {
        try {
            shop.updateShop(DataLoader.getLoader("Y:\\OOSE\\Assignment\\src\\src\\com\\jonathan\\exampleinput.csv"));
        } catch (DataLoadException e) {
            throw new ShopException(
                    String.format("Shop Was Unable to be loaded from input file via dataloader, here are the details: %s",
                            e.getMessage()));
        }
        view.displayStats(player.toString());
        int response = view.getShopResponse();
        while (response != 4) {
            switch (response) {
                case 1:
                    itemPurchase();
                    break;
                case 2:
                    System.out.println("Enchanting.");
                    break;
                case 3:
                    System.out.println("Sell Items at 50%");
                    break;
                default:
                    throw new ShopException("Unknown Shop Selection returned from the shop view.");
            }
            response = view.getShopResponse();
        }
    }
    private void itemPurchase() throws ShopException {
        view.displayStats(player.toString());
        int response = view.getShopItemType();
        while (response != 5) {
            switch (response) {
                case 1:
                    view.displayGeneral(shop.describeShop());
                    break;
                case 2:
                    String selectedWeapon = view.getItemSelection(shop.describeWeapons());
                    Weapon weaponToAdd = shop.getWeapon(selectedWeapon);
                    if (weaponToAdd != null) {
                        if (player.getGold() >= weaponToAdd.getCost()) {
                            boolean inventory = invController.addToInventory(weaponToAdd);
                            if (inventory) {
                                view.moneyDeducted(player.getName(), weaponToAdd.getName(), player.getGold(), weaponToAdd.getCost());
                                player.setGold(player.getGold() - weaponToAdd.getCost());
                            }
                        } else {
                            view.failPurchase(weaponToAdd.getName(), "Insufficient Funds.");
                        }
                    } else {
                        view.failPurchase(selectedWeapon.toLowerCase(), "The weapon does not exist.");
                    }
                    break;
                case 3:
                    String selectedPotion = view.getItemSelection(shop.describePotions());
                    Damage dmgPotion = shop.getDamagePotion(selectedPotion);
                    if (dmgPotion != null) {
                        if (player.getGold() >= dmgPotion.getCost()) {
                            boolean inventory = invController.addToInventory(dmgPotion);
                            if (inventory) {
                                view.moneyDeducted(player.getName(), dmgPotion.getName(), player.getGold(), dmgPotion.getCost());
                                player.setGold(player.getGold() - dmgPotion.getCost());
                            }
                        } else {
                            view.failPurchase(dmgPotion.getName(), "Insufficient Funds.");
                        }
                    } else {
                        Healing hpPotion = shop.getHealingPotion(selectedPotion);
                        if (hpPotion != null) {
                            if (player.getGold() >= hpPotion.getCost()) {
                                boolean inventory = invController.addToInventory(hpPotion);
                                if (inventory) {
                                    view.moneyDeducted(player.getName(), hpPotion.getName(), player.getGold(), hpPotion.getCost());
                                    player.setGold(player.getGold() - hpPotion.getCost());
                                }
                            } else {
                                view.failPurchase(hpPotion.getName(), "Insufficient Funds.");
                            }
                        } else {
                            view.failPurchase(selectedPotion.toLowerCase(), "The potion does not exist.");
                        }
                    }
                    break;
                case 4:
                    String selectedArmour = view.getItemSelection(shop.describeArmour());
                    Armour armourToAdd = shop.getArmour(selectedArmour);
                    if (armourToAdd != null) {
                        if (player.getGold() >= armourToAdd.getCost()) {
                            boolean inventory = invController.addToInventory(armourToAdd);
                            if (inventory) {
                                view.moneyDeducted(player.getName(), armourToAdd.getName(), player.getGold(), armourToAdd.getCost());
                                player.setGold(player.getGold() - armourToAdd.getCost());
                            }
                        } else {
                            view.failPurchase(armourToAdd.getName(), "Insufficient Funds.");
                        }
                    } else {
                        view.failPurchase(selectedArmour.toLowerCase(), "The armour does not exist.");
                    }
                    break;
                default:
                    throw new ShopException("Unknown Item Type Selection return from the shop view.");
            }
            response = view.getShopItemType();
            view.displayStats(player.toString());
        }
    }
}
