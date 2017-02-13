package com.edutilos.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OnePersonDialog extends JDialog implements MyFrameLayout{
  private PersonDAO dao ;
    private JLabel statusLbl;
    private Long id ;

    public OnePersonDialog(Frame owner, String title, boolean modal, PersonDAO dao , JLabel statusLbl, Long id) {
        super(owner, title, modal);
       this.dao = dao ;
        this.statusLbl = statusLbl;
        this.id = id ;

        prepareGUI();
    }


    //other variables
    private JPanel rootPanel ;
    private JLabel welcomeLbl , idLbl, idValueLbl , nameLbl, nameValueLbl , ageLbl , ageValueLbl ,
    wageLbl , wageValueLbl;
    private JButton closeBtn ;

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
        rootPanel.setLayout(new GridLayout(6, 2));
        this.getContentPane().add(rootPanel);

        welcomeLbl = new JLabel("One Person");
        rootPanel.add(welcomeLbl);
        rootPanel.add(new JLabel());

        idLbl = new JLabel("Id:");
        idValueLbl = new JLabel();
        rootPanel.add(idLbl);
        rootPanel.add(idValueLbl);

        nameLbl = new JLabel("Name:");
        nameValueLbl = new JLabel();
        rootPanel.add(nameLbl);
        rootPanel.add(nameValueLbl);

        ageLbl = new JLabel("Age:");
        ageValueLbl = new JLabel();
        rootPanel.add(ageLbl);
        rootPanel.add(ageValueLbl);

        wageLbl = new JLabel("Wage:");
        wageValueLbl = new JLabel();
        rootPanel.add(wageLbl);
        rootPanel.add(wageValueLbl);

        closeBtn = new JButton("Close");
        rootPanel.add(closeBtn);
    }

    @Override
    public void registerListeners() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                Person p = dao.findById(id);
                if(p != null) {
                    idValueLbl.setText(p.getId()+"");
                    nameValueLbl.setText(p.getName());
                    ageValueLbl.setText(p.getAge()+"");
                    wageValueLbl.setText(p.getWage()+"");
                    statusLbl.setText("One person action was executed.");
                   // OnePersonDialog.this.dispose();
                } else {
                    statusLbl.setText("No person with id "+ id);
                    OnePersonDialog.this.dispose();
                }
            }
        });
         closeBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 OnePersonDialog.this.dispose();
             }
         });
    }
}
