package com.jonathan.model;

import com.jonathan.exceptions.DataLoadException;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DataLoader { /* Base Class For All Loaders of Data */
    public static DataLoader getLoader(String dataSource) { /* Factory Method To Decide On Correct Data Loader. */
        DataLoader data = null;
        if (dataSource.endsWith(".csv") || dataSource.endsWith(".txt")) {
            data = new TextDataLoader(dataSource);
        }
        return data;
    }
    public abstract HashMap<String, Healing> loadHealingPotions() throws DataLoadException;
    public abstract HashMap<String, Damage> loadDamagePotions() throws DataLoadException;
    public abstract HashMap<String, Armour> loadArmour() throws DataLoadException;
    public abstract HashMap<String, Melee> loadWeapons() throws DataLoadException;
    public ArrayList<String> loadEnchants() { /* Hardcoded i.e. as loading this is the same for all extends, as there is no data source to load enchants from */
        ArrayList<String> enchants = new ArrayList<>();
        enchants.add("Damage +2 - Adds 2 to attack damage - 5 gold");
        enchants.add("Damage +5 - Adds 5 to attack damage - 10 gold");
        enchants.add("Power-Up - Multiplies attack damage by 1.1 - 10 gold");
        enchants.add("Fire Damage - Adds between 5-10 (randomly) to attack damage - 20 gold");
        return enchants;
    }
}
