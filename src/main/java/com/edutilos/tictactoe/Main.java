package com.edutilos.tictactoe;


import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        Main main = new Main();
        main.prepareGUI();
    }

    public void prepareGUI() {
       //this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents();
        registerEvents();
        this.setVisible(true);
    }

    private JPanel panelRoot ;
    private Board board ;
    private JButton btnCheck , btnClear ;

    public void addComponents() {
        panelRoot = new JPanel();
        panelRoot.setLayout(new BoxLayout(panelRoot, BoxLayout.Y_AXIS));
        this.getContentPane().add(panelRoot);
        board = new Board();
        panelRoot.add(board);
        btnCheck = new JButton("Check");
        btnClear = new JButton("Clear");
        JPanel panelButtons = new JPanel();
        panelButtons.add(btnCheck);
        panelButtons.add(btnClear);
        panelRoot.add(panelButtons);
       // panelRoot.add(new TButton("|", "world"));
    }

    public void registerEvents() {

    }
}

