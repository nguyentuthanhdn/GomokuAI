package com.company;

public class Board {

    public char[][] board2DArray;

    public Board() {
        board2DArray = new char[15][15];
    }

    public void update2DArray(char turn, int row, int col) {
        if (turn == 'X') {
            board2DArray[row][col] = 'X';
        }
        else if (turn == 'O') {
            board2DArray[row][col] = 'O';
        }
    }
    public char[][] getBoard() {
        return board2DArray;
    }
    public void resetBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board2DArray[i][j] = 0;
            }
        }
    }

    public boolean checkWin(int row, int col) {

        //TODO: HORIZONTAL
        int count = 0;
        //RIGHT
        int i, j = 1;
        while (col+j < board2DArray[0].length && board2DArray[row][col] == board2DArray[row][col + j]) {
            count++;
            j++;
        }
        //LEFT
        j = 1;
        while (col-j >= 0 && board2DArray[row][col] == board2DArray[row][col - j]) {
            count++;
            j++;
        }
        count++;
        if (count == 5)
            return true;


        //TODO: VERTICAL
        count = 0;
        i = 1;
        while (row + i < board2DArray.length && board2DArray[row][col] == board2DArray[row + i][col]) {
            count++;
            i++;
        }
        i = 1;
        while (row - i >= 0 && board2DArray[row][col] == board2DArray[row - i][col]) {
            count++;
            i++;
        }
        count++;
        if (count == 5)
            return true;

        //TODO: Diagonal \\
        i = 1;
        j = 1;
        count = 0;
        while (row + i < board2DArray.length && col + j < board2DArray.length && board2DArray[row][col] == board2DArray[row + i][col + j]) {
            count++;
            j++;
            i++;
        }
        i = 1;
        j = 1;
        while (row - i >= 0 && col - j >= 0 && board2DArray[row][col] == board2DArray[row - i][col - j]) {
            count++;
            j++;
            i++;
        }
        count++;
        if (count == 5)
            return true;

        //TODO Diagonal //
        count = 0;
        i = 1;
        j = 1;
        while (row + i < board2DArray.length && col - j >= 0 && board2DArray[row][col] == board2DArray[row + i][col - j]) {
            count++;
            j++;
            i++;
        }
        i = 1;
        j = 1;
        while (row - i >= 0 && col + j < board2DArray.length && board2DArray[row][col] == board2DArray[row - i][col + j]) {
            count++;
            j++;
            i++;
        }
        count++;
        if (count == 5)
            return true;
        return false;
    }

    public boolean isMoveLeft() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (board2DArray[i][j] != 'X' || board2DArray[i][j] != 'O')
                    return true;
            }
        }
        return false;
    }
}
