package com.jonathan.view;

import com.jonathan.model.Character;
import com.jonathan.model.Battle;
import com.jonathan.model.BattleObserver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleViewer implements BattleObserver {
    private Battle battle;
    public BattleViewer() {}
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
}
