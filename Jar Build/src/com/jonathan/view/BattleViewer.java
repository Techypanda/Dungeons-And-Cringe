package com.jonathan.view;

import com.jonathan.model.Battle;
import com.jonathan.model.BattleObserver;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Purpose: View for battles
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class BattleViewer extends View implements BattleObserver {
    private Battle battle;

    /**
     * Present prompt to user, return input to controller.
     * @return input from user
     */
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

    /**
     * Set the battle to observe and add yourself as a observer (Observer pattern)
     * @param battle battle to observe
     */
    public void setBattle(Battle battle) {
        this.battle = battle;
        this.battle.addObserver(this);
    }

    /**
     * Notified of battle event, update the display. -- observer pattern
     */
    @Override
    public void updateBattle() {
        System.out.println(battle.getBattleDetails());
        if (battle.getWinner() != null) {
            String winnerName = battle.getWinner().getName();
            int battleReward = battle.getLoser().getGold();
            System.out.printf("%s has won the battle and has taken the loser's gold of: %d!%n", winnerName, battleReward);
        }
    }

    /**
     * Announces a battle to user
     * @param characterOne first character name
     * @param characterTwo second character name
     */
    public void announceBattle(String characterOne, String characterTwo) {
        System.out.println("A New Battle has begun");
        System.out.println(characterOne + " vs " + characterTwo);
        System.out.println(characterOne + " will start.");
    }

    /**
     * Presents prompt to user of all potions and returns choice
     * @param potions potion string of all potions to display
     * @return the user response
     */
    public String queryPotion(String potions) {
        System.out.println("Here are your potions: ");
        System.out.println(potions + "\nPlease select a potion.");
        return prompt();
    }

    /**
     * Presents no potions to user.
     */
    public void noPotions() {
        System.out.println("You have no potions.");
    }

    /**
     * Presents Damage Potion being used in battle to user
     * @param potionName name of potion
     * @param enemyName name of enemy
     * @param potionDmg damage of potion
     * @param beforeHP hp before potion
     * @param afterHP hp after potion
     */
    public void damagePotion(String potionName, String enemyName, int potionDmg, int beforeHP, int afterHP) {
        System.out.printf("%s has been used on %s, %s has gone from %d HP to %d HP\n", potionName,
                enemyName, enemyName, beforeHP, afterHP);
    }

    /**
     * Presents Healing potion being used in battle to user
     * @param potionName name of potion
     * @param playerName name of player
     * @param potionHeal potion heal amount
     * @param playerHP hp of player
     */
    public void healPotion(String potionName, String playerName, int potionHeal, int playerHP) {
        System.out.printf("%s has been drunk by %s, %d has been healed leaving %s with %d HP.%n", potionName,
                playerName, potionHeal, playerName, playerHP);
    }

    /**
     * Presents failure of use of potion
     * @param potionName potion name
     * @param reason reason for failure
     */
    public void failedPotion(String potionName, String reason) {
        System.out.printf("%s cannot be used: %s%n", potionName, reason);
    }
}
