package com.edutilos.simpleproject

import groovy.swing.SwingBuilder

import javax.swing.JButton
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTable
import javax.swing.JTextField
import javax.swing.ScrollPaneConstants
import javax.swing.WindowConstants
import javax.swing.table.DefaultTableModel
import java.awt.GridLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

/**
 * Created by edutilos on 14/02/2017.
 */
class DialogFactory {


    public static JDialog makePeopleDialog(JFrame mainFrame, ProgrammerDAO dao, JLabel lblStatus) {
        Vector<String> colNames = new Vector<>()
        colNames.add("Id")
        colNames.add("Name")
        colNames.add("Age")
        colNames.add("Wage")
        colNames.add("Patient")
        DefaultTableModel model = new DefaultTableModel(colNames, 0)

        JLabel lblWelcome
        JTable tableProgrammer
        JButton btnClose
        SwingBuilder builder = new SwingBuilder()

        def rootPanel
        rootPanel = {
          builder.panel(layout: new GridLayout(3,1)) {
              lblWelcome = label(text: "Programmer List")
              scrollPane(horizontalScrollBarPolicy: ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED,
              verticalScrollBarPolicy:  ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED) {
                 tableProgrammer = table(model: model)
              }
              btnClose = button(text: "Close")
          }
        }

        JDialog dialog = builder.dialog(owner: mainFrame, modal: true ,
        size: [500, 500], defaultCloseOperation: WindowConstants.DISPOSE_ON_CLOSE) {
            rootPanel()
        }

        //register listeners
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            void windowOpened(WindowEvent e) {
                List<Programmer> list = dao.findAll()
                list.each {p->
                Vector data = new Vector()
                    data.add(p.id)
                    data.add(p.name)
                    data.add(p.age)
                    data.add(p.wage)
                    data.add(p.patient)
                    model.addRow(data)
                }
                lblStatus.text = "Status: findAll was executed."
            }
        })

        btnClose.addActionListener {l->
            lblStatus.text = "Status: People Dialog was closed."
            dialog.dispose()
        }

        return dialog
    }

    public static JDialog makeOnePersonDialog(JFrame mainFrame, ProgrammerDAO dao, JLabel lblStatus, long id) {
        def  panelRoot

        JLabel lblWelcome, lblId , lblName, lblAge, lblWage, lblPatient
        JLabel fieldId, fieldName , fieldAge, fieldWage, fieldPatient
        JButton btnClose
         SwingBuilder builder = new SwingBuilder()


        panelRoot = {
          builder.panel(layout: new GridLayout(7, 2)) {
              lblWelcome = label(text: "One Person Dialog")
              label()
              lblId = label(text: "Id:")
              fieldId = label(text: "")
              lblName = label(text:"Name:")
              fieldName = label()
              lblAge = label(text:"Age:")
              fieldAge = label()
              lblWage = label(text:"Wage:")
              fieldWage= label()
              lblPatient= label(text:"Patient:")
              fieldPatient = label()
              btnClose = button(text:"Close")
          }
        }

        JDialog dialog = builder.dialog(owner:mainFrame, modal:true,
        defaultCloseOperation: WindowConstants.DISPOSE_ON_CLOSE,
        size: [500, 500]) {
            panelRoot()
        }


        //register listeners
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            void windowOpened(WindowEvent e) {
                try {
                   Programmer p = dao.findById(id)
                    fieldId.text = p.id.toString()
                    fieldName.text = p.name
                    fieldAge.text = p.age.toString()
                    fieldWage.text = p.wage.toString()
                    fieldPatient.text = p.patient.toString()
                } catch(Exception ex) {
                    lblStatus.text = "Status: ${ex.message}"
                }
            }
        })


        btnClose.addActionListener {l ->
           lblStatus.text = "Status: findById action was executed."
            dialog.dispose()
        }

        return dialog
    }

    public static JDialog makeUpdateDialog(JFrame mainFrame, ProgrammerDAO dao , JLabel lblStatus) {
        def  panelRoot

        JLabel lblWelcome, lblId , lblName, lblAge, lblWage, lblPatient
        JTextField fieldId, fieldName , fieldAge, fieldWage, fieldPatient
        JButton btnUpdate, btnCancel

        SwingBuilder builder = new SwingBuilder()

        panelRoot = {
            builder.panel(layout: new GridLayout(8, 2)) {
                lblWelcome = label(text: "Programmer MainFrame")
                label()
                lblId = label(text: "Id: ")
                fieldId = textField(columns: 15)
                lblName = label(text: "Name: ")
                fieldName = textField(columns: 15)
                lblAge = label(text:"Age: ")
                fieldAge = textField(columns: 15)
                lblWage = label(text:"Wage: ")
                fieldWage = textField(columns: 15)
                lblPatient= label(text:"Patient: ")
                fieldPatient = textField(columns: 15)
                btnUpdate = button(text:"Update")
                btnCancel = button(text:"Cancel")

            }
        }


        JDialog dialog = builder.dialog(owner:mainFrame , modal: true, size: [500, 500],
                defaultCloseOperation: WindowConstants.DISPOSE_ON_CLOSE) {
            panelRoot()
        }

        //register listeners
        btnUpdate.addActionListener {l ->
         try {
             dao.update(fieldId.text.toLong(), new Programmer(
                     fieldId.text.toLong(),
                     fieldName.text ,
                     fieldAge.text.toInteger(),
                     fieldWage.text.toDouble(),
                     fieldPatient.text.toBoolean()
             ))
             lblStatus.text = "status: update action was executed."
         } catch (Exception ex) {
             lblStatus.text = "status: ${ex.message}"
         } finally {
             dialog.dispose()
         }
        }

        btnCancel.addActionListener {l ->
          lblStatus.text = "statu: update action was cancelled."
            dialog.dispose()
        }


        return dialog
    }


    public static JDialog makeSaveDialog(JFrame mainFrame, ProgrammerDAO dao, JLabel lblStatus) {
        def  panelRoot

        JLabel lblWelcome, lblId , lblName, lblAge, lblWage, lblPatient
        JTextField fieldId, fieldName , fieldAge, fieldWage, fieldPatient
        JButton btnSave, btnCancel

        SwingBuilder builder = new SwingBuilder()

        panelRoot = {
            builder.panel(layout: new GridLayout(8, 2)) {
                lblWelcome = label(text: "Programmer MainFrame")
                label()
                lblId = label(text: "Id: ")
                fieldId = textField(columns: 15)
                lblName = label(text: "Name: ")
                fieldName = textField(columns: 15)
                lblAge = label(text:"Age: ")
                fieldAge = textField(columns: 15)
                lblWage = label(text:"Wage: ")
                fieldWage = textField(columns: 15)
                lblPatient= label(text:"Patient: ")
                fieldPatient = textField(columns: 15)
                btnSave = button(text:"Save")
                btnCancel = button(text:"Cancel")

            }
        }


        JDialog dialog = builder.dialog(owner:mainFrame , modal: true, size: [500, 500],
        defaultCloseOperation: WindowConstants.DISPOSE_ON_CLOSE) {
            panelRoot()
        }

        //register listeners
        btnSave.addActionListener{ l->
           try {
               Programmer p = new Programmer(
                       fieldId.text.toLong(),
                       fieldName.text ,
                       fieldAge.text.toInteger(),
                       fieldWage.text.toDouble(),
                       fieldPatient.text.toBoolean()
               )
               dao.save(p)
               lblStatus.text = "status: save action was executed."
           } catch(Exception ex) {
               lblStatus.text = "status: ${ex.message}"
               dialog.dispose()
           } finally {
               dialog.dispose()
           }
        }

        btnCancel.addActionListener {l ->
            lblStatus.text = "status: save action cancelled."
            dialog.dispose()
        }

        return dialog
    }
}
