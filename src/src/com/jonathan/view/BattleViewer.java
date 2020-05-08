package com.jonathan.view;

import com.jonathan.model.Character;
import com.jonathan.model.Battle;
import com.jonathan.model.BattleObserver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleViewer extends View implements BattleObserver {
    private Battle battle;
    public int requestOption() {
        int response = 0;
        while (response < 1 || response > 2) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Would you like to: \n   1: Use A Potion From Inventory\n   2: Attack with current weapon");
                response = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That is a invalid option!");
            }
        }
        return response;
    }
    public void setBattle(Battle battle) {
        this.battle = battle;
        this.battle.addObserver(this);
    }
    @Override
    public void updateBattle() {
        System.out.println(battle.getBattleDetails());
        if (battle.getWinner() != null) {
            Character winner = battle.getWinner();
            System.out.printf("%s has won the battle and has taken the loser's gold of: %d!%n", winner.getName(), battle.getReward());
        }
    }
    public void announceBattle(String characterOne, String characterTwo) {
        System.out.println("A New Battle has begun");
        System.out.println(characterOne + " vs " + characterTwo);
        System.out.println(characterOne + " will start.");
    }
    public String queryPotion(String potions) {
        System.out.println("Here are your potions: ");
        System.out.println(potions + "\nPlease select a potion.");
        return prompt();
    }
    public void noPotions() {
        System.out.println("You have no potions.");
    }
    public void damagePotion(String potionName, String enemyName, int potionDmg, int beforeHP, int afterHP) {
        System.out.printf("%s has been used on %s, %s has gone from %d HP to %d HP\n", potionName,
                enemyName, enemyName, beforeHP, afterHP);
    }
    public void healPotion(String potionName, String playerName, int potionHeal, int playerHP) {
        System.out.printf("%s has been drunk by %s, %d has been healed leaving %s with %d HP.%n", potionName,
                playerName, potionHeal, playerName, playerHP);
    }
    public void failedPotion(String potionName, String reason) {
        System.out.printf("%s cannot be used: %s%n", potionName, reason);
    }
}
