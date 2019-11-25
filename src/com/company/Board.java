package com.company;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    public static char[][] board2DArray = new char[15][15];
    private JButton buttonsArray[][] = new JButton[15][15];
    private int col, row;
    public static char turn = 'X';
    public Board() {
        setLayout(new GridLayout(15,15));
        initialiseBoard();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked.getText().equals("")) {
            if (turn == 'X') {
                buttonClicked.setForeground(Color.RED);
                buttonClicked.setText("X");
                update2DArray(buttonClicked);
                turn = 'O';
                if (checkWin()) {
                    JOptionPane.showConfirmDialog(null, "Player 1 wins. Press any button to reset.");
                    resetGame();
                    turn = 'X';
                }
            }
            else if (turn == 'O') {
                buttonClicked.setForeground(Color.BLACK);
                buttonClicked.setText("O");
                update2DArray(buttonClicked);
                turn = 'X';
                if (checkWin()) {
                    JOptionPane.showConfirmDialog(null, "Player 2 wins. Press any button to reset.");
                    resetGame();
                    turn = 'X';
                }
            }
        }
    }
    private void initialiseBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                buttonsArray[i][j] = new JButton();
                buttonsArray[i][j].setText("");
                buttonsArray[i][j].addActionListener(this::actionPerformed);
                buttonsArray[i][j].setActionCommand(i + " " + j);
                add(buttonsArray[i][j]);
            }
        }
    }

    private void update2DArray(@NotNull JButton buttonClicked) {
        String[] positionButtonClicked = buttonClicked.getActionCommand().split(" ");
        row = Integer.parseInt(positionButtonClicked[0]);
        col = Integer.parseInt(positionButtonClicked[1]);
        if (buttonClicked.getText().equals("X")) {
            board2DArray[row][col] = 'X';
        }
        else if ((buttonClicked.getText().equals("O"))) {
            board2DArray[row][col] = 'O';
        }

    }

    private void resetGame() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                buttonsArray[i][j].setText("");
                board2DArray[i][j] = 0;
            }
        }
    }


    private boolean checkWin() {

        //TODO: HORIZONTAL
        int count = 0;
        //RIGHT
        int i = 0, j = 1;
        while (col+j < board2DArray[0].length && board2DArray[row][col] == board2DArray[row][col + j]) {
            count++;
            j++;
        }
        //LEFT
        i = 0;
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

}
