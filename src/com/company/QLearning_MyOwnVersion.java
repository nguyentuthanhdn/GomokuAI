package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class QLearning_MyOwnVersion implements ExplorationPolicy{
    private char[][] board;
    private int win = 0;
    private int loss = 0;
    private double[][] actionEstimates = {{1,0},{2,0},{3,0},{4,0}};
    private ArrayList<double[][]> Q = new ArrayList<>();
    private double[][] actionsPerformed;
    public QLearning_MyOwnVersion() {
        Action action = new Action() {
            @Override
            public void createThreatDiagonal() {

            }

            @Override
            public void createVerticalDiagonal() {

            }

            @Override
            public void createHorizontalDiagonal() {

            }

            @Override
            public void blockThreat() {

            }

            @Override
            public void getAction(double action) {

            }
        };
    }
    public void setBoard(@NotNull char[][] board) {
        this.board =  board.clone();
    }

    @Override
    public void ChooseAction(@NotNull double[][] actionEstimates) {
        //find max reward. Go for the approach that has the highest reward;
        double max = -1999999999;
        double actionAsDouble = -100000;
        for (int i = 0; i < actionEstimates.length; i++) {
            if (actionEstimates[i][1] > max) {
                max = actionEstimates[i][1];
                actionAsDouble = actionEstimates[i][0];
            }
        }
    }

}
