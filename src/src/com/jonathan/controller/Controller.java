package com.jonathan.controller;

import com.jonathan.DataLoadException;
import com.jonathan.DataLoader;
import com.jonathan.Shop;
import com.jonathan.view.UserInterface;
import com.jonathan.model.Player;

/*public class Controller {
    public static void main(String[] args) {
        int response = -1;
        Player player = new Player("The Player", 30, 100);
        Shop theShop = new Shop();
        try {
            DataLoader shopDataLoader = DataLoader.getLoader("Y:\\OOSE\\Assignment\\src\\src\\com\\jonathan\\exampleinput.csv");
            if (shopDataLoader == null) throw new DataLoadException("Unsupported Data Source.");
            theShop.updateShop(shopDataLoader);
        } catch (DataLoadException e) {
            UserInterface.error(e);
            System.exit(1);
        }
        player.addItem(theShop.cheapestWeapon());
        player.addItem(theShop.cheapestArmour());
        player.equip(theShop.cheapestWeapon());
        player.equip(theShop.cheapestArmour());
        while (response != 6) {
            UserInterface.displayStats(player);
            response = UserInterface.displayMenu();
            switch (response) {
                case 1:
                    UserInterface.displayShopPrompt(player.getName(), theShop.describeShop());

                    break;
                case 2:
                    player.setName(UserInterface.displayNamePrompt());
                    break;
                case 3:
                    System.out.println("Choose Weapon");
                    break;
                case 4:
                    System.out.println("Choose Armour");
                    break;
                case 5:
                    System.out.println("Start Battle");
                    break;
            }
        }
        System.out.println("Ending!");
    }
}*/
