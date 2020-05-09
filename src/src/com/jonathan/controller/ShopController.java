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
    private DataLoader loader;
    public ShopController(Shop inShop, ShopViewer inView, Player thePlayer, InventoryController invController, DataLoader loader) {
        shop = inShop;
        view = inView;
        player = thePlayer;
        this.invController = invController;
        this.loader = loader;
    }
    public void beginShop() throws ShopException {
        try {
            shop.updateShop(loader);
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
                    enchanting();
                    break;
                case 3:
                    sell();
                    break;
                default:
                    throw new ShopException("Unknown Shop Selection returned from the shop view.");
            }
            response = view.getShopResponse();
        }
    }
    private void sell() {
        if (!invController.isEmpty()) {
            String chosenToSell = view.sellPrompt(player.showWeapons() + player.showArmour() + player.showPotions());
            Weapon[] theWeapon = player.getWeapon(chosenToSell);
            if (theWeapon.length >= 1) {
                if (theWeapon.length == 1) {
                    int price = (int) ((float) theWeapon[0].getCost() * 0.50);
                    int confirmation = view.sellConfirmation(theWeapon[0].getName(), price);
                    if (confirmation == 1) {
                        invController.removeFromInventory(theWeapon[0]);
                        view.sold(theWeapon[0].getName(), price);
                        player.setGold(player.getGold() + price);
                    }
                } else {
                    String[] weaponDesc = new String[theWeapon.length];
                    for (int i = 0; i < theWeapon.length; i++)
                        weaponDesc[i] = theWeapon[i].toString();
                    Weapon selected = theWeapon[view.multipleSelection(weaponDesc)];
                    int price = (int) (selected.getCost() * 0.50);
                    int confirmation = view.sellConfirmation(selected.getName(), price);
                    if (confirmation == 1) {
                        invController.removeFromInventory(selected);
                        view.sold(selected.getName(), price);
                        player.setGold(player.getGold() + price);
                    }
                }
            } else {
                Armour[] theArmour = player.getArmour(chosenToSell);
                if (theArmour.length >= 1) {
                    if (theArmour.length == 1) {
                        int price = (int) ((float) theArmour[0].getCost() * 0.50);
                        int confirmation = view.sellConfirmation(theArmour[0].getName(), price);
                        if (confirmation == 1) {
                            invController.removeFromInventory(theArmour[0]);
                            view.sold(theArmour[0].getName(), price);
                            player.setGold(player.getGold() + price);
                        }
                    } else {
                        String[] armourDesc = new String[theArmour.length];
                        for (int i = 0; i < theArmour.length; i++)
                            armourDesc[i] = theArmour[i].toString();
                        Armour selected = theArmour[view.multipleSelection(armourDesc)];
                        int price = (int) ((float) selected.getCost() * 0.50);
                        int confirmation = view.sellConfirmation(selected.getName(), price);
                        if (confirmation == 1) {
                            invController.removeFromInventory(selected);
                            view.sold(selected.getName(), price);
                            player.setGold(player.getGold() + price);
                        }
                    }
                } else {
                    Potion[] thePotion = player.getPotions(chosenToSell);
                    if (thePotion.length >= 1) {
                        if (thePotion.length == 1) {
                            int price = (int) ((float) thePotion[0].getCost() * 0.50);
                            int confirmation = view.sellConfirmation(thePotion[0].getName(), price);
                            if (confirmation == 1) {
                                invController.removeFromInventory(thePotion[0]);
                                view.sold(thePotion[0].getName(), price);
                                player.setGold(player.getGold() + price);
                            }
                        } else {
                            String[] potionDesc = new String[thePotion.length];
                            for (int i = 0; i < thePotion.length; i++)
                                potionDesc[i] = thePotion[i].toString();
                            Potion selected = thePotion[view.multipleSelection(potionDesc)];
                            int price = (int) ((float) selected.getCost() * 0.50);
                            int confirmation = view.sellConfirmation(selected.getName(), price);
                            if (confirmation == 1) {
                                invController.removeFromInventory(selected);
                                view.sold(selected.getName(), price);
                                player.setGold(player.getGold() + price);
                            }
                        }
                    } else {
                        view.failSell(chosenToSell, "You don't have that item");
                    }
                }
            }
        } else {
            view.failSell("anything", "Empty Inventory");
        }
    }
    private void enchanting() throws ShopException {
        /* Enchantments are kept seperate from the shop model. */
        Weapon chosenWeapon = invController.getWeapon();
        if (chosenWeapon != null) {
            int response = view.getEnchantingChoice();
            switch (response) {
                case 0:
                    break; /* Unrecognized Enchantment */
                case 1:
                    if (player.getGold() >= 10) {
                        view.moneyDeducted(player.getName(), "Damage Enchantment +5", player.getGold(), 10);
                        player.setGold(player.getGold() - 10);
                        player.replaceWeapon(chosenWeapon, new DamageEnchantment(chosenWeapon, 5));
                    } else {
                        view.failEnchant("Damage Enchantment +5", "Insufficient Gold");
                    }
                    break;
                case 2:
                    if (player.getGold() >= 5) {
                        view.moneyDeducted(player.getName(), "Damage Enchantment +2", player.getGold(), 5);
                        player.setGold(player.getGold() - 5);
                        player.replaceWeapon(chosenWeapon, new DamageEnchantment(chosenWeapon, 2));
                    } else {
                        view.failEnchant("Damage Enchantment +2", "Insufficient Gold");
                    }
                    break;
                case 3:
                    if (player.getGold() >= 20) {
                        view.moneyDeducted(player.getName(), "Fire Enchantment", player.getGold(), 20);
                        player.setGold(player.getGold() - 20);
                        player.replaceWeapon(chosenWeapon, new FireEnchantment(chosenWeapon));
                    } else {
                        view.failEnchant("Fire Enchantment", "Insufficient Gold");
                    }
                    break;
                case 4:
                    if (player.getGold() >= 10) {
                        view.moneyDeducted(player.getName(), "Power-Up Enchantment", player.getGold(), 10);
                        player.setGold(player.getGold() - 10);
                        player.replaceWeapon(chosenWeapon, new PowerUpEnchantment(chosenWeapon));
                    } else {
                        view.failEnchant("Power-Up Enchantment", "Insufficient Gold");
                    }
                    break;
                default:
                    throw new ShopException("A Unrecognized Enchantment was returned from view.");
            }
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
