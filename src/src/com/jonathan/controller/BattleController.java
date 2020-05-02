package com.jonathan.controller;

import com.jonathan.model.*;
import com.jonathan.model.Character;
import com.jonathan.view.BattleViewer;

import java.util.Random;

public class BattleController {
    private double[] probabilities;
    private Battle battle;
    private BattleViewer theView;
    public BattleController() {
        probabilities = new double[4];
        probabilities[0] = 0.5;
        probabilities[1] = 0.3;
        probabilities[2] = 0.2;
        probabilities[3] = 0;
        theView = new BattleViewer();
    } /* Battle Controller Does Not need to start battle here. */
    private Character generateEnemy() {
        /* Statistics Problem?? */
        double fullWeight = 1.0; /* Should Never Add Up to more than this, so no need to sum them. */
        double roll = Math.random() * fullWeight;
        int selection = -1;
        double weightSum = 0;
        int i = 0;
        for (; i < probabilities.length; i++) {
            weightSum += probabilities[i];
            if (weightSum >= roll)
                break;
        }
        selection = i + 1;
        switch(selection) {
            case 1:
                return new Slime();
            case 2:
                return new Goblin();
            case 3:
                return new Ogre();
            case 4:
                return new Dragon();
            default:
                System.out.println("Received selection = " + selection);
                return null;
        }
    }
    private void adjustProbabilities() {
        double dragonInc = 0;
        if (probabilities[0] > 0.05) {
            probabilities[0] -= 0.05;
            dragonInc += 0.05;
        }
        if (probabilities[1] > 0.05) {
            probabilities[1] -= 0.05;
            dragonInc += 0.05;
        }
        if (probabilities[2] > 0.05) {
            probabilities[2] -= 0.05;
            dragonInc += 0.05;
        }
        probabilities[3] += dragonInc;
    }
    public void beginBattle(Character player) {
        Random rand = new Random();
        Character enemy = generateEnemy();
        Battle battle = new Battle(player, enemy);
        theView.setBattle(battle);
        while (battle.getWinner() == null) {
            if (battle.getTurn() == 1) { /* Player */
                int response = theView.requestOption();
                if (response == 1) {

                } else
                    battle.doBattle();
            } else { /* AI */
                battle.doBattle();
            }
        }
        adjustProbabilities();
    }
}
