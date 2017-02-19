package com.edutilos.tictactoe;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel {

    public Board() {
        super();
        prepareGUI();
    }


    public void prepareGUI() {
        this.setLayout(new GridLayout(3, 3));
        addComponents();
    }

    private List<TButton> buttons ;
    public void addComponents() {
        buttons = new ArrayList<>();
        for(int i= 0 ; i< 6; ++i) {
            TButton btn = new TButton("|" , "nop");
            btn.setText("|");
            buttons.add(btn);

        }


        for(TButton btn: buttons) {
            this.add(btn);
        }
    }


    public List<TButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<TButton> buttons) {
        this.buttons = buttons;
    }
}
