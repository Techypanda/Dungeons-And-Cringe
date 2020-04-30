package com.jonathan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextDataLoader extends DataLoader {
    private String dataSource;
    public TextDataLoader(String inDataSource) {
        dataSource = inDataSource;
    }
    @Override
    public HashMap<String, Potion> loadPotions() throws DataLoadException {
        HashMap<String, Potion> potions = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Y:\\OOSE\\Assignment\\src\\src\\com\\jonathan\\exampleinput.txt"))) {
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
                            potions.put(potionTitle, new Healing(potionTitle, cost, min, max));
                        else if (potionType.equals("D"))
                            potions.put(potionTitle, new Harming(potionTitle, cost, min, max));
                        else
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
    @Override
    public HashMap<String, Armour> loadArmour() throws DataLoadException {
        HashMap<String, Armour> armour = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Y:\\OOSE\\Assignment\\src\\src\\com\\jonathan\\exampleinput.txt"))) {
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
                        String material = properties[5].trim().toUpperCase();
                        armour.put(armourTitle, new Armour(armourTitle, cost, min, max, material));
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
    @Override
    public HashMap<String, Weapon> loadWeapons() throws DataLoadException {
        HashMap<String, Weapon> weapons = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Y:\\OOSE\\Assignment\\src\\src\\com\\jonathan\\exampleinput.txt"))) {
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
                        String weaponType = properties[5].trim().toUpperCase();
                        weapons.put(weaponTitle, new Weapon(weaponTitle, cost, min, max, weaponType));
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
