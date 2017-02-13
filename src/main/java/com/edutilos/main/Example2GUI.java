package com.edutilos.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Example2GUI implements MyFrameLayout {
    //variables
    private JFrame mainFrame ;
    private JLabel welcomeLbl , statusLbl ;
    private JButton saveBtn , updateBtn , deleteBtn, findByIdBtn, findAllBtn;
    private JTextField findByIdField;
    //personDAO
    private PersonDAO personDAO ;

    public static void main(String[] args) {
        Example2GUI gui = new Example2GUI();
       gui.prepareGUI();
    }

    public void prepareGUI() {
        mainFrame = new JFrame("Person DAO GUI");
        mainFrame.setSize(new Dimension(500, 500));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        setGUIContent();
        registerListeners();
        addDAOSupport();
        mainFrame.setVisible(true);
    }


    private void addDAOSupport() {
        personDAO = new PersonDAOMysql();
    }

    public void setGUIContent() {
        welcomeLbl = new JLabel("Welcome to the DAO GUI");
         mainFrame.getContentPane().add(welcomeLbl);
        saveBtn = new JButton("Save Person");
        mainFrame.getContentPane().add(saveBtn);
        updateBtn = new JButton("Update Person");
        mainFrame.getContentPane().add(updateBtn);
        deleteBtn = new JButton("Delete Person");
        mainFrame.getContentPane().add(deleteBtn);
        findByIdBtn = new JButton("Find By Id");
        findByIdField = new JTextField(15);
        JPanel findByIdPanel = new JPanel(new FlowLayout());

        findByIdPanel.add(findByIdBtn); findByIdPanel.add(findByIdField);
        mainFrame.getContentPane().add(findByIdPanel);
        findAllBtn = new JButton("Find All");
        mainFrame.getContentPane().add(findAllBtn);
        statusLbl = new JLabel("Status: ");
        mainFrame.getContentPane().add(statusLbl);
    }


    public  void registerListeners() {
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               statusLbl.setText("Status: saveBtn was clicked.");
                PersonSaveDialog dialog = new PersonSaveDialog(mainFrame, "Save Person", true, personDAO, statusLbl);
                dialog.setVisible(true);
            }
        });


        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLbl.setText("Status: updateBtn was clicked.");
                PersonUpdateDialog dialog = new PersonUpdateDialog(mainFrame, "Update Person", true, personDAO, statusLbl);
                dialog.setVisible(true);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLbl.setText("Status: deleteBtn was clicked.");
              PersonDeleteDialog dialog = new PersonDeleteDialog(mainFrame, "Delete Person", true , personDAO, statusLbl);
                dialog.setVisible(true);
            }
        });

        findByIdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLbl.setText("Status: findByIdBtn was clicked.");
                try {
                    long id = Long.parseLong(findByIdField.getText());
                    OnePersonDialog dialog = new OnePersonDialog(mainFrame, "One Person", true, personDAO, statusLbl, id);
                   dialog.setVisible(true);
                }  catch(Exception ex) {
                    statusLbl.setText("status: "+ ex.getMessage());
                }
                }
        });

        findAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLbl.setText("Status: findAllBtn was clicked.");
                AllPeopleDialog dialog = new AllPeopleDialog(mainFrame, "All People", true, personDAO, statusLbl);
                dialog.setVisible(true);
            }
        });
    }
}
