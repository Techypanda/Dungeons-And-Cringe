package com.jonathan.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Purpose: To represent the data around a battle.
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class Battle { /* Observer Pattern used. */
    private Character characterOne;
    private Character characterTwo;
    private Set<BattleObserver> obs;
    private String battleDetails;
    private Character winner;
    private Character loser;
    private int turn;

    /**
     * Returns the winner of the battle.
     * @return winner if there is one else it returns null (NULLABLE)
     */
    public Character getWinner() {
        return winner;
    }

    /**
     * Returns the loser of the battle.
     * @return loser if there is one else it returns null (NULLABLE)
     */
    public Character getLoser() {
        return loser;
    }

    /**
     * Returns reward of battle, implemented here as if two players are in battle then the winner should take all the
     * losers gold.
     * @return the gold of the winner
     */
    public int getReward() {
        return loser.getGold();
    }

    /**
     * Adds an observer to the battleobservers set. (Observer Pattern)
     * @param ob The observer to add.
     */
    public void addObserver(BattleObserver ob) {
        obs.add(ob);
    }

    /**
     * Removes an observer from the battleobservers set. (Observer Pattern)
     * @param ob The observer to remove.
     */
    public void removeObserver(BattleObserver ob) {
        obs.remove(ob);
    }

    /**
     * Notifies all observers of the battle needing updating.
     */
    private void notifyObservers() {
        for (BattleObserver observer: obs) {
            observer.updateBattle();
        }
    }

    /**
     * Returns the current details of the battle.
     * @return battleDetails - String
     */
    public String getBattleDetails() {
        return battleDetails;
    }

    /**
     * Returns the current user's turn i.e 1 - player 1, 2 - player 2, this is bad but I just cant be bothered to rework
     * this again, an alternative could have been returning a Character but that seemed even worse to me.
     * @return turn - int
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Alternate constructor for battle
     * @param firstCharacter Character 1 for the battle - AI or Player
     * @param secondCharacter Character 2 for the battle - AI or Player
     */
    public Battle(Character firstCharacter, Character secondCharacter) { /* Dependency Injection */
        characterOne = firstCharacter;
        characterTwo = secondCharacter;
        obs = new HashSet<>();
        battleDetails = "Battle Has Not Begun!";
        winner = null;
        turn = 1;
    }

    /**
     * Handle a turn of the battle.
     */
    public void doBattle() {
        int damageTaken;
        if (turn == 1) {
            damageTaken = characterTwo.takeDamage(characterOne.getDamage());
            battleDetails = String.format("%s%n%s has dealt %d damage to %s!%n%s remains with %d HP.",
                    characterOne.getDamageDetails(), characterOne.getName(), damageTaken, characterTwo.getName(), characterTwo.getName(),
                    characterTwo.getHP());
            checkWin();
            notifyObservers();
            turn = 2;
        } else {
            damageTaken = characterOne.takeDamage(characterTwo.getDamage());
            battleDetails = String.format("%s%n%s has dealt %d damage to %s!%n%s remains with %d HP.",
                    characterTwo.getDamageDetails(), characterTwo.getName(), damageTaken, characterOne.getName(), characterOne.getName(),
                    characterOne.getHP());
            checkWin();
            notifyObservers();
            turn = 1;
        }
    }

    /**
     * Increment the turn to the next person.
     */
    public void incrementTurn() {
        if (turn == 1) {
            turn = 2;
            checkWin();
        }
        else if (turn == 2) {
            turn = 1;
            checkWin();
        }
    }

    /**
     * Private method to check if a Character has won yet.
     */
    private void checkWin() {
        if (characterOne.getHP() <= 0) {
            winner = characterTwo;
            loser = characterOne;
        }
        if (characterTwo.getHP() <= 0) {
            winner = characterOne;
            loser = characterTwo;
            characterOne.battleHeal();
        }
    }
}
