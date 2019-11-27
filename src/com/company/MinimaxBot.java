package com.company;

public class MinimaxBot {
    private Board board = new Board();
    private char[][] boardState;
    private int row, col;
    private char turn, otherTurn;
    public MinimaxBot(char turn) {
        this.turn = turn;
        if (this.turn == 'X')
            otherTurn = 'O';
        else
            otherTurn = 'X';
    }
    private int minimax(int depth, boolean isMinimaxBot, int alpha, int beta) {
        int score = evaluate(isMinimaxBot);
        int best;
        if (score == 100)
            return score;
        else if (score == -100)
            return score;
        else if (depth < 10)
            return 0;
        if (isMinimaxBot) {
            best = -10000;

        }
        else {

        }
        return 0;
    }

    /*
    * If the bot wins score is 100 (Good result)
    * If the other player would win becuase of this move return -100 (bad result)
    * If neither player would win based on this move, return 0 (Neutral option)
    * */
    private int evaluate(boolean isMinimaxBot) {
        if (isMinimaxBot && board.checkWin(row, col)) {
            return 100;
        }
        else if (!isMinimaxBot && board.checkWin(row,col))
            return -100;
        else
            return 0;
    }

    private void generateMoves() {

    }

}
