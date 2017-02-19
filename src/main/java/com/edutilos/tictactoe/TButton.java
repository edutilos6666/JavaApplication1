package com.edutilos.tictactoe;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TButton extends JButton implements ActionListener{

     private String player ;

    public TButton(String text, String player) {
        super(text);
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");
        //  if(this.getText().equals("|")) {
             // if(player.equals("player1")) this.setText("X");
              //else if(player.equals("player2"))this.setText("O");
              this.setText("O");
          //}
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
