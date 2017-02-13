package com.edutilos.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonUpdateDialog extends JDialog implements MyFrameLayout{
    //variables from mainFrame
    private PersonDAO dao ;
    private JLabel statusLbl ;

    public PersonUpdateDialog(Frame owner, String title, boolean modal, PersonDAO dao , JLabel statusLbl) {
        super(owner, title, modal);
        this.dao = dao ;
        this.statusLbl = statusLbl ;

        prepareGUI();
    }

    //other variables
    private JPanel rootPanel;
    private JLabel welcomeLbl , idLbl , nameLbl, ageLbl , wageLbl;
    private JTextField idField, nameField, ageField, wageField;
    private JButton updateBtn , cancelBtn ;

    @Override
    public void prepareGUI() {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());

        setGUIContent();
        registerListeners();
    }

    @Override
    public void setGUIContent() {
       //rootPanel
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayout(6, 2));
        this.getContentPane().add(rootPanel);

        //welcomeLbl
        welcomeLbl = new JLabel("Update Person");
        rootPanel.add(welcomeLbl);
        rootPanel.add(new JLabel());

        //id
        idLbl = new JLabel("Id:");
        idField = new JTextField();
        idField.setToolTipText("add id");
        rootPanel.add(idLbl);
        rootPanel.add(idField);

        //name
        nameLbl = new JLabel("Name:");
        nameField = new JTextField();
        nameField.setToolTipText("add name");
        rootPanel.add(nameLbl);
        rootPanel.add(nameField);

        //age
        ageLbl = new JLabel("Age:");
        ageField = new JTextField();
        ageField.setToolTipText("add age");
        rootPanel.add(ageLbl);
        rootPanel.add(ageField);

        //wage
        wageLbl = new JLabel("Wage:");
        wageField = new JTextField();
        wageField.setToolTipText("add wage");
        rootPanel.add(wageLbl);
        rootPanel.add(wageField);

        //buttons
        updateBtn = new JButton("Update");
        cancelBtn = new JButton("Cancel");
        rootPanel.add(updateBtn);
        rootPanel.add(cancelBtn);
    }

    @Override
    public void registerListeners() {
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long id = Long.parseLong(idField.getText());
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    double wage = Double.parseDouble(wageField.getText());
                    dao.update(id, new Person(id, name, age, wage));
                    statusLbl.setText("Status: person was updated.");
                } catch(Exception ex) {
                    statusLbl.setText("Status: "+ ex.getMessage());
                } finally {
                    PersonUpdateDialog.this.dispose();
                }
            }
        });


        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 statusLbl.setText("Status: update action was cancelled.");
                PersonUpdateDialog.this.dispose();
            }
        });
    }
}
