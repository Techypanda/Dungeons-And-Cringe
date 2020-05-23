package com.jonathan.model;

import com.jonathan.exceptions.DataLoadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * PURPOSE: To load data from text (.csv or .txt)
 * DATE: 23/05/2020
 * AUTHOR: Jonathan Wright
 */
public class TextDataLoader extends DataLoader {
    private String dataSource;

    /**
     * Constructs a text loader with a data source -- location of txt/csv (Alternate Constructor)
     * @param inDataSource location of data txt/csv
     */
    public TextDataLoader(String inDataSource) {
        dataSource = inDataSource;
    }

    /**
     * Returns a hashmap containing healing potions from the data source
     * @return hashmap containing healing potions
     * @throws DataLoadException if the file has errors being read.
     */
    @Override
    public HashMap<String, Healing> loadHealingPotions() throws DataLoadException {
        HashMap<String, Healing> potions = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
            String currLine = br.readLine();
            while (currLine != null) {
                String[] properties = currLine.split(",");
                if (properties.length != 6 && properties.length != 7)
                    throw new DataLoadException(String.format("Line does not have correct amount of properties: %s.", currLine));
                if (!(properties[0].toUpperCase().equals("P") || properties[0].toUpperCase().equals("W") || properties[0].toUpperCase().equals("A")))
                    throw new DataLoadException(String.format("Invalid Item Type Found In Line: %s", currLine));
                if (properties[0].toUpperCase().equals("P")) {
                    String potionTitle = properties[1].trim();
                    try {
                        int cost = Integer.parseInt(properties[4].trim());
                        int min = Integer.parseInt(properties[2].trim());
                        int max = Integer.parseInt(properties[3].trim());
                        String potionType = properties[5].trim().toUpperCase();
                        if (potionType.equals("H"))
                            potions.put(potionTitle.toUpperCase(), new Healing(potionTitle, cost, min, max));
                        else if (!potionType.equals("D"))
                            throw new DataLoadException(String.format("Unable to understand whether potion is healing or damaging on line: %s, what I read: %s", currLine, potionTitle));
                    } catch(NumberFormatException e) {
                        throw new DataLoadException(String.format("Unable to convert cost/max/min to numeric value on line: %s", currLine));
                    }
                }
                currLine = br.readLine();
            }
        } catch (IOException e) {
            throw new DataLoadException(e.getMessage(), e.getCause());
        }
        return potions;
    }

    /**
     * Returns a hashmap containing the damage potions from the data source
     * @return hashmap containing damage potions
     * @throws DataLoadException if the file cannot be read
     */
    @Override
    public HashMap<String, Damage> loadDamagePotions() throws DataLoadException {
        HashMap<String, Damage> potions = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
            String currLine = br.readLine();
            while (currLine != null) {
                String[] properties = currLine.split(",");
                if (properties.length != 6 && properties.length != 7)
                    throw new DataLoadException(String.format("Line does not have correct amount of properties: %s.", currLine));
                if (!(properties[0].toUpperCase().equals("P") || properties[0].toUpperCase().equals("W") || properties[0].toUpperCase().equals("A")))
                    throw new DataLoadException(String.format("Invalid Item Type Found In Line: %s", currLine));
                if (properties[0].toUpperCase().equals("P")) {
                    String potionTitle = properties[1].trim();
                    try {
                        int cost = Integer.parseInt(properties[4].trim());
                        int min = Integer.parseInt(properties[2].trim());
                        int max = Integer.parseInt(properties[3].trim());
                        String potionType = properties[5].trim().toUpperCase();
                        if (potionType.equals("D"))
                            potions.put(potionTitle.toUpperCase(), new Damage(potionTitle, cost, min, max));
                        else if (!potionType.equals("H"))
                            throw new DataLoadException(String.format("Unable to understand whether potion is healing or damaging on line: %s, what I read: %s", currLine, potionTitle));
                    } catch(NumberFormatException e) {
                        throw new DataLoadException(String.format("Unable to convert cost/max/min to numeric value on line: %s", currLine));
                    }
                }
                currLine = br.readLine();
            }
        } catch (IOException e) {
            throw new DataLoadException(e.getMessage(), e.getCause());
        }
        return potions;
    }

    /**
     * Returns a hashmap containing the armour from data source
     * @return hashmap containing armour
     * @throws DataLoadException if file cannot be read
     */
    @Override
    public HashMap<String, Armour> loadArmour() throws DataLoadException {
        HashMap<String, Armour> armour = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
            String currLine = br.readLine();
            while (currLine != null) {
                String[] properties = currLine.split(",");
                if (properties.length != 6 && properties.length != 7)
                    throw new DataLoadException(String.format("Line does not have correct amount of properties: %s.", currLine));
                if (!(properties[0].toUpperCase().equals("P") || properties[0].toUpperCase().equals("W") || properties[0].toUpperCase().equals("A")))
                    throw new DataLoadException(String.format("Invalid Item Type Found In Line: %s", currLine));
                if (properties[0].toUpperCase().equals("A")) {
                    String armourTitle = properties[1].trim();
                    try {
                        int cost = Integer.parseInt(properties[4].trim());
                        int min = Integer.parseInt(properties[2].trim());
                        int max = Integer.parseInt(properties[3].trim());
                        String material = properties[5].trim();
                        armour.put(armourTitle.toUpperCase(), new Armour(armourTitle, cost, min, max, material));
                    } catch(NumberFormatException e) {
                        throw new DataLoadException(String.format("Unable to convert cost/max/min to numeric value on line: %s", currLine));
                    }
                }
                currLine = br.readLine();
            }
        } catch (IOException e) {
            throw new DataLoadException(e.getMessage(), e.getCause());
        }
        return armour;
    }

    /**
     * returns a hashmap containg the weapons from data source
     * @return hashmap containing weapons
     * @throws DataLoadException if file cannot be read
     */
    @Override
    public HashMap<String, Melee> loadWeapons() throws DataLoadException {
        HashMap<String, Melee> weapons = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
            String currLine = br.readLine();
            while (currLine != null) {
                String[] properties = currLine.split(",");
                if (properties.length != 6 && properties.length != 7)
                    throw new DataLoadException(String.format("Line does not have correct amount of properties: %s.", currLine));
                if (!(properties[0].toUpperCase().equals("P") || properties[0].toUpperCase().equals("W") || properties[0].toUpperCase().equals("A")))
                    throw new DataLoadException(String.format("Invalid Item Type Found In Line: %s", currLine));
                if (properties[0].toUpperCase().equals("W")) {
                    String weaponTitle = properties[1].trim();
                    try {
                        int cost = Integer.parseInt(properties[4].trim());
                        int min = Integer.parseInt(properties[2].trim());
                        int max = Integer.parseInt(properties[3].trim());
                        String weaponType = properties[5].trim();
                        String damageType = properties[6].trim();
                        weapons.put(weaponTitle.toUpperCase(), new Melee(weaponTitle, cost, min, max, weaponType, damageType));
                    } catch(NumberFormatException e) {
                        throw new DataLoadException(String.format("Unable to convert cost/max/min to numeric value on line: %s", currLine));
                    }
                }
                currLine = br.readLine();
            }
        } catch (IOException e) {
            throw new DataLoadException(e.getMessage(), e.getCause());
        }
        return weapons;
    }
}
