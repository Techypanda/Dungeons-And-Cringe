package com.jonathan.tests;

import com.jonathan.DataLoadException;
import com.jonathan.DataLoader;
import com.jonathan.Shop;

public class ShopTestHarness {
    public static void main(String[] args) {
        Shop myShop = new Shop();
        try {
            myShop.updateShop(DataLoader.getLoader("Y:\\OOSE\\Assignment\\src\\src\\com\\jonathan\\exampleinput.csv"));
            System.out.println(myShop.describeShop());
        } catch (DataLoadException e) {
            System.out.println(e.getMessage());
        }
    }
}
