package com.edutilos.main;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

public class AllPeopleDialog extends JDialog implements MyFrameLayout{

    private PersonDAO dao ;
    private JLabel statusLbl ;

    public AllPeopleDialog(Frame owner, String title, boolean modal, PersonDAO dao , JLabel statusLbl) {
        super(owner, title, modal);
        this.dao = dao ;
        this.statusLbl = statusLbl;
        prepareGUI();
    }

    @Override
    public void prepareGUI() {
       this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setGUIContent();
        registerListeners();
    }

    //Variables
    private JPanel rootPanel;
    private JLabel welcomeLbl ;
    private JTable personTable;
    private DefaultTableModel personTableModel;
    private JButton closeBtn ;

    @Override
    public void setGUIContent() {
     rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        this.getContentPane().add(rootPanel);

        welcomeLbl = new JLabel("All people");
        rootPanel.add(welcomeLbl);

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Id");
        columnNames.add("Name");
        columnNames.add("Age");
        columnNames.add("Wage");
        personTableModel = new DefaultTableModel(columnNames, 0);
        personTable = new JTable(personTableModel);
        JScrollPane pane = new JScrollPane(personTable);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        rootPanel.add(pane);

        closeBtn = new JButton("Close");
        rootPanel.add(closeBtn);
    }

    @Override
    public void registerListeners() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                java.util.List<Person> allPeople = dao.findAll();
                for(Person p: allPeople) {
                    Vector<Object> v = new Vector<Object>();
                    v.add(p.getId());
                    v.add(p.getName());
                    v.add(p.getAge());
                    v.add(p.getWage());
                    personTableModel.addRow(v);
                }
            }
        });

        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLbl.setText("findAll action was executed.");
                AllPeopleDialog.this.dispose();
            }
        });
    }
}
