package com.jonathan.model;

public abstract class Character {
    protected String name;
    protected int maxHP;
    protected int gold;
    protected int currHP;
    public Character(String inName, int inHP, int inGold) {
        name = inName;
        maxHP = inHP;
        gold = inGold;
        currHP = maxHP;
    }
    public int getHP() {
        return currHP;
    }
    public int getGold() {
        return gold;
    }
    public void setHP(int hp) {
        this.currHP = hp;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void battleHeal() {
        currHP = Math.min(maxHP, (int)(currHP * 1.5));
    }
    public abstract int getDamage();
    public abstract int takeDamage(int inDmg);
    public String getName() {return name;}
    public abstract String toString();
    public void setName(String inName) {name = inName;}
}
