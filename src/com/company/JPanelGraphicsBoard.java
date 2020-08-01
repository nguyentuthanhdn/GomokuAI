package com.company;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelGraphicsBoard extends JPanel implements ActionListener {
    private JButton buttonsArray[][] = new JButton[15][15];
    private int col, row;
    public static int state = 0;
    public static char turn = 'X';

    private Board gameboard = new Board();
    public JPanelGraphicsBoard() {
        setLayout(new GridLayout(15,15));
        initialiseBoard();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (!gameboard.isMoveLeft()) {
            JOptionPane.showConfirmDialog(null, "No moves left. It's a draw. Press any button to reset.");
            resetGame();
            turn = 'X';
        }
        if (buttonClicked.getText().equals("")) {
            if (turn == 'X') {
                update(buttonClicked, Color.RED, "X");
                turn = 'O';
                if (gameboard.checkWin(row, col)) {
                    JOptionPane.showConfirmDialog(null, "Player 1 wins. Press any button to reset.");
                    resetGame();
                    turn = 'X';
                }

            }
            else if (turn == 'O') {
                update(buttonClicked, Color.BLACK, "O");
                turn = 'X';
                if (gameboard.checkWin(row, col)) {
                    JOptionPane.showConfirmDialog(null, "Player 2 wins. Press any button to reset.");
                    resetGame();
                    turn = 'X';
                }

            }
        }
    }

    private void update(JButton buttonClicked, Color c, String player) {
        buttonClicked.setForeground(c);
        buttonClicked.setText(player);
        setRowAndCol(buttonClicked);
        gameboard.update2DArray(turn, row, col);
    }

    private void initialiseBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                buttonsArray[i][j] = new JButton();
                buttonsArray[i][j].setText("");
                buttonsArray[i][j].addActionListener(this);
                buttonsArray[i][j].setActionCommand(i + " " + j);
                add(buttonsArray[i][j]);
            }
        }
    }

    private void setRowAndCol(@NotNull JButton buttonClicked){
        String[] positionButtonClicked = buttonClicked.getActionCommand().split(" ");
        row = Integer.parseInt(positionButtonClicked[0]);
        col = Integer.parseInt(positionButtonClicked[1]);
    }


    private void resetGame() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                buttonsArray[i][j].setText("");
                gameboard.resetBoard();
            }
        }
    }

}
