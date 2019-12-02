package com.company;

import java.util.HashMap;

public class QLearning_MyOwnVersion {
    private char[][] board;
    private int win = 0;
    private int loss = 0;
    private HashMap<char[][],Action> qValues = new HashMap<char[][],Action>();
    public QLearning_MyOwnVersion() {

    }
    public void setBoard(char[][] board) {
        this.board =  board.clone();
    }

}
