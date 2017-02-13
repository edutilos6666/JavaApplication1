package com.edutilos.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonSaveDialog extends JDialog implements MyFrameLayout{
    private PersonDAO dao ;
    private JLabel statusLbl ;

    public PersonSaveDialog(Frame owner, String title, boolean modal, PersonDAO dao, JLabel statusLbl) {
        super(owner, title, modal);
       this.dao = dao ;
        this.statusLbl = statusLbl;
        prepareGUI();
      }


    //other variables
    private JPanel rootPanel;
    private JLabel welcomeLbl , idLbl , nameLbl , ageLbl , wageLbl ;
    private JTextField idField, nameField, ageField, wageField;
    private JButton saveBtn , cancelBtn;

    @Override
    public void prepareGUI() {
       this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());

        setGUIContent();
        registerListeners();
       // this.setVisible(true);
    }

    @Override
    public void setGUIContent() {
        //rootPanel
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayout(6, 2));
        this.getContentPane().add(rootPanel);

        welcomeLbl = new JLabel("Save Person");
        rootPanel.add(welcomeLbl);
        rootPanel.add(new JLabel());

        //id
        idLbl =new JLabel("Id: ");
        idField = new JTextField();
        idField.setToolTipText("Enter id");
        rootPanel.add(idLbl);
        rootPanel.add(idField);

        //name
        nameLbl = new JLabel("Name: ");
        nameField = new JTextField();
        nameField.setToolTipText("Enter name");
        rootPanel.add(nameLbl);
        rootPanel.add(nameField);

        //age
        ageLbl = new JLabel("Age: ");
        ageField = new JTextField();
        ageField.setToolTipText("Enter age");
        rootPanel.add(ageLbl);
        rootPanel.add(ageField);

        //wage
        wageLbl = new JLabel("Wage: ");
        wageField = new JTextField();
        wageField.setToolTipText("Enter wage");
        rootPanel.add(wageLbl);
        rootPanel.add(wageField);

        //buttons
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");
        rootPanel.add(saveBtn);
        rootPanel.add(cancelBtn);
    }

    @Override
    public void registerListeners() {
     saveBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 long id = Long.parseLong(idField.getText()) ;
                 String name = nameField.getText();
                 int age = Integer.parseInt(ageField.getText());
                 double wage = Double.parseDouble(wageField.getText());
                 dao.save(new Person(id, name, age, wage));
                 statusLbl.setText("status: Successfully saved person.");
             } catch(Exception ex){
                 statusLbl.setText(ex.getMessage());
             } finally {
                 PersonSaveDialog.this.dispose();
             }

         }
     });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 statusLbl.setText("status: Nothing was saved , action was cancelled.");
                PersonSaveDialog.this.dispose();
            }
        });
    }
}
