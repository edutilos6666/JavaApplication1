package com.edutilos.multiplechoice;


import javax.swing.*;
import java.awt.*;

public class ResultDialog extends JDialog {


    private int rightAnswers ,
    wrongAnswers ;

    public ResultDialog(Frame owner, int rightAnswers , int wrongAnswers) {
        super(owner, "ResultAnswer", true);
      this.rightAnswers = rightAnswers ;
        this.wrongAnswers = wrongAnswers;
        prepareGUI();
    }

    //variables
    private JPanel panelRoot ;
    private JLabel lblWelcome , lblRight , lblWrong ;
    private JTextField fieldRIght , fieldWrong ;
    private JButton btnClose ;

    public void prepareGUI() {
        this.setSize(new Dimension(200, 300));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addComponents();
        registerEvents();
        this.setVisible(true);
    }
    public void addComponents() {
        panelRoot = new JPanel();
        panelRoot.setLayout(new GridLayout(4, 2));
        this.getContentPane().add(panelRoot);

        lblWelcome = new JLabel("Summary of answers");
        panelRoot.add(lblWelcome);
        panelRoot.add(new JLabel());

        lblRight = new JLabel("Right answers: ");
        fieldRIght = new JTextField();
        panelRoot.add(lblRight);
        panelRoot.add(fieldRIght);

        lblWrong = new JLabel("Wrong answer: ");
        fieldWrong = new JTextField();
        panelRoot.add(lblWrong) ;
        panelRoot.add(fieldWrong);

        btnClose = new JButton("Close");
        panelRoot.add(btnClose);

        fieldRIght.setEnabled(false);
        fieldWrong.setEnabled(false);
        fieldRIght.setText(rightAnswers+"");
        fieldWrong.setText(wrongAnswers+"");
    }

    public void registerEvents() {
         btnClose.addActionListener(l -> {
             this.dispose();
         });
    }
}
