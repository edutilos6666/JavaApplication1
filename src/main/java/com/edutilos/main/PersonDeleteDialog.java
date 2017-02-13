package com.edutilos.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by edutilos on 13/02/2017.
 */
public class PersonDeleteDialog extends JDialog implements MyFrameLayout {
    //variables from mainFrame
    private PersonDAO dao ;
    private JLabel statusLbl ;

    public PersonDeleteDialog(Frame owner, String title, boolean modal, PersonDAO dao , JLabel statusLbl) {
        super(owner, title, modal);
        this.dao = dao ;
        this.statusLbl = statusLbl;
        prepareGUI();
    }

    //other variables
    private JPanel rootPanel;
    private JLabel welcomeLbl , idLbl ;
    private JTextField idField;
    private JButton deleteBtn , cancelBtn ;

    @Override
    public void prepareGUI() {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setGUIContent();
        registerListeners();
    }

    @Override
    public void setGUIContent() {
      rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayout(3, 2));
        this.getContentPane().add(rootPanel);

        welcomeLbl = new JLabel("Delete Person");
        rootPanel.add(welcomeLbl);
        rootPanel.add(new JLabel());

        idLbl = new JLabel("Id:");
        idField = new JTextField();
        rootPanel.add(idLbl);
        rootPanel.add(idField);

        deleteBtn = new JButton("Delete");
        cancelBtn = new JButton("Cancel");
        rootPanel.add(deleteBtn);
        rootPanel.add(cancelBtn);
    }

    @Override
    public void registerListeners() {
     deleteBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 long id = Long.parseLong(idField.getText());
                 dao.delete(id);
                 statusLbl.setText("Status: person with id "+ id + " was deleted.");
             } catch(Exception ex) {
                 statusLbl.setText("Status: "+ ex.getMessage());
             } finally {
                 PersonDeleteDialog.this.dispose();
             }
         }
     });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLbl.setText("Status: delete action was cancelled.");
                PersonDeleteDialog.this.dispose();
            }
        });
    }
}
