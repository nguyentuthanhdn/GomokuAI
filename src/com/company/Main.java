package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Gomoku");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Board());
        window.setBounds(300,200,700,700);
        window.setVisible(true);
    }
}
