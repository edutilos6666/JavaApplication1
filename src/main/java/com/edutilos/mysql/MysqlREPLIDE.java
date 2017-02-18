package com.edutilos.mysql;


import javax.swing.*;
import java.awt.*;

public class MysqlREPLIDE {


    public static void main(String[] args) {
         MysqlREPLIDE ide = new MysqlREPLIDE();
        ide.prepareGUI();
    }
    //variables
    private JFrame mainFrame ;
    private JPanel panelRoot ;
    private JLabel lblInput , lblOutput ;
    private JTextArea areaInput , areaOutput ;
    private JButton btnRun , btnClear ;

    MysqlREPL repl = new MysqlREPL();

    public void prepareGUI() {
       mainFrame = new JFrame("MysqlREPL IDE");
        mainFrame.setSize(new Dimension(500, 500));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents();;
        registerEvents();


        mainFrame.setVisible(true);
    }


    public void addComponents() {
         panelRoot = new JPanel();
        panelRoot.setLayout(new BoxLayout(panelRoot, BoxLayout.Y_AXIS));
        mainFrame.getContentPane().add(panelRoot);

        lblInput = new JLabel("Input: ");
        areaInput = new JTextArea(10 , 10);
        panelRoot.add(lblInput);
        panelRoot.add(areaInput);

        lblOutput = new JLabel("Output: ");
        areaOutput = new JTextArea(10, 10);
        panelRoot.add(lblOutput);
        panelRoot.add(areaOutput);

        btnRun = new JButton("Run");
        btnClear = new JButton("Clear");
        JPanel panelButtons = new JPanel();
        panelButtons.add(btnRun);
        panelButtons.add(btnClear);
        panelRoot.add(panelButtons);
    }

    public void registerEvents() {
       btnRun.addActionListener(l -> {
          String input = areaInput.getText();
           String res = repl.executeMsqlCmd(input);
           areaOutput.setText(res);
       });


        btnClear.addActionListener(l -> {
           areaInput.setText("");
            areaOutput.setText("");
        });
    }
}
