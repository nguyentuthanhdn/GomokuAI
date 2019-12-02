package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class QLearning_MyOwnVersion implements ExplorationPolicy{
    private char[][] board;
    private int win = 0;
    private int loss = 0;
    private double[][] actionEstimates = new double[4][2];
    private HashMap<char[][],Action> qValues = new HashMap<char[][],Action>();
    public QLearning_MyOwnVersion() {

    }
    public void setBoard(@NotNull char[][] board) {
        this.board =  board.clone();
    }

    @Override
    public double ChooseAction(@NotNull double[][] actionEstimates) {
        //find Max, greedy approach
        double max = -100000000;
        double action = -100000;
        for (int i = 0; i < actionEstimates.length; i++) {
            if (actionEstimates[i][1] > max) {
                max = actionEstimates[i][1];
                action = actionEstimates[i][0];
            }
        }
        return action;
    }
}
