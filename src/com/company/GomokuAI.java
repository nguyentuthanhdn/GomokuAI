package com.company;

public class GomokuAI implements IExplorationPolicy {
    public static char[][] board;
    public static char turn;
    public static int state;
    public GomokuAI(char[][] board, char turn, int state) {
        this.board = board;
        this.turn = turn;
        this.state = state;
    }



    @Override
    public int ChooseAction(double[] actionEstimates) {
        return 0;
    }
}
