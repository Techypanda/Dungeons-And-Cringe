package com.jonathan.model;

/**
 * Abstract Super Class for characters in the game
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public abstract class Character {
    protected String name;
    protected int maxHP;
    protected int gold;
    protected int currHP;
    protected String damageDetails; // Contains the details of the damage they dealt

    /**
     * Abstract Alternate Constructor
     * @param inName name of character
     * @param inHP maxHP & starting HP of Character
     * @param inGold starting gold for character.
     */
    public Character(String inName, int inHP, int inGold) {
        name = inName;
        maxHP = inHP;
        gold = inGold;
        currHP = maxHP;
        damageDetails = "I haven't dealt damage yet.";
    }

    /**
     * currHP getter
     * @return currHP
     */
    public int getHP() {
        return currHP;
    }

    /**
     * gold getter
     * @return gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * hp setter
     * @param hp the hp to set to.
     */
    public void setHP(int hp) {
        this.currHP = hp;
    }

    /**
     * gold setter
     * @param gold the gold to set to.
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * heal the character after a battle.
     */
    public void battleHeal() {
        currHP = Math.min(maxHP, (int)(currHP * 1.5));
    }

    /**
     * returns the character's calculated damage.
     * @return the characters calculated damage.
     */
    public abstract int getDamage();

    /**
     * The character takes the damage based off calculation i.e armour taken into effect.
     * @param inDmg the damage to take
     * @return the actual damage taken after calculation
     */
    public abstract int takeDamage(int inDmg);

    /**
     * name getter
     * @return name
     */
    public String getName() {return name;}

    /**
     * description of the character
     * @return string description of the character.
     */
    public abstract String toString();

    /**
     * name setter
     * @param inName the name to set to.
     */
    public void setName(String inName) {name = inName;}

    /**
     * damageDetails getter
     * @return damageDetails
     */
    public String getDamageDetails() {
        return damageDetails;
    }
}
