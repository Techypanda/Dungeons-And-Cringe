package com.jonathan.model;

import com.jonathan.exceptions.DataLoadException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Super Class for DataLoaders, if you wished to create a new way of loading data i.e off a database, off a website
 * you would extend this and extend each method.
 */
public abstract class DataLoader { /* Base Class For All Loaders of Data */
    /**
     * This is a factory method, I decided there is no reason for a whole class for this, based off the data source it
     * decides which dataloader is needed, if you were to create a new dataloader i.e off a website
     * you would have to update the factory method to include a way to return the new dataloader.
     * @param dataSource the datasource to load the data from i.e a .txt file or .csv file etc
     * @return null if it wasnt possible (NULLABLE) or a dataloader that supports the type.
     */
    public static DataLoader getLoader(String dataSource) { /* Factory Method To Decide On Correct Data Loader. */
        DataLoader data = null;
        if (dataSource.endsWith(".csv") || dataSource.endsWith(".txt")) {
            data = new TextDataLoader(dataSource);
        }
        return data;
    }

    /**
     * loads all healing potions
     * @return a hashmap containing healing potions.
     * @throws DataLoadException if an error occured during IO.
     */
    public abstract HashMap<String, Healing> loadHealingPotions() throws DataLoadException;

    /**
     * load all damage potions
     * @return a hashmap containing all damage potions.
     * @throws DataLoadException if an error occured during IO.
     */
    public abstract HashMap<String, Damage> loadDamagePotions() throws DataLoadException;

    /**
     * load all armour
     * @return a hashmap containing all armour
     * @throws DataLoadException if an error occured during IO
     */
    public abstract HashMap<String, Armour> loadArmour() throws DataLoadException;

    /**
     * load all weapons
     * @return a hashmap containing all weapons
     * @throws DataLoadException if an error occured during IO
     */
    public abstract HashMap<String, Melee> loadWeapons() throws DataLoadException;
}
