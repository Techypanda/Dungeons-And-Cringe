package com.jonathan;

import com.jonathan.model.Armour;
import com.jonathan.model.Potion;
import com.jonathan.model.Weapon;

import java.util.HashMap;

public abstract class DataLoader { /* Base Class For All Loaders of Data */
    public static DataLoader getLoader(String dataSource) { /* Factory Method To Decide On Correct Data Loader. */
        DataLoader data = null;
        if (dataSource.endsWith(".csv") || dataSource.endsWith(".txt")) {
            data = new TextDataLoader(dataSource);
        }
        return data;
    }
    public abstract HashMap<String, Potion> loadPotions() throws DataLoadException;
    public abstract HashMap<String, Armour> loadArmour() throws DataLoadException;
    public abstract HashMap<String, Weapon> loadWeapons() throws DataLoadException;
}
