package com.edutilos.simpleproject

import groovy.swing.SwingBuilder

import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.WindowConstants
import java.awt.FlowLayout
import java.awt.GridLayout


//variables
JFrame mainFrame
def  panelRootClo
JPanel panelRoot
JLabel lblWelcome, lblStatus
JButton btnSave , btnUpdate , btnDelete , btnFindById, btnFindAll
JTextField fieldDelete, fieldFindById


SwingBuilder builder = new SwingBuilder()


panelRootClo = {
    panelRoot = builder.panel() {
      lblWelcome = label(text: "Main GUI")
        label()
        btnSave = button(text: "Save Person")
        btnUpdate = button(text:"Update Person")
        panel(layout: new FlowLayout()) {
            btnDelete = button(text:"Delete Person")
            fieldDelete = textField(columns: 15)
        }
        panel(layout:new FlowLayout()) {
            btnFindById = button(text: "FindById")
            fieldFindById = textField(columns: 15)
        }
        btnFindAll = button(text: "Find All")
        lblStatus = label(text: "Status: ")
    }
}




mainFrame = builder.frame(title: "Programmer GUI", size: [500, 500],
defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
    panelRootClo()
}

panelRoot.setLayout(new BoxLayout(panelRoot, BoxLayout.Y_AXIS))

//register events
ProgrammerDAO dao = new ProgrammerDAOSqlImpl()
btnSave.addActionListener {l ->
   JDialog dialog = DialogFactory.makeSaveDialog(mainFrame, dao, lblStatus)
   dialog.setVisible(true)
 }
btnUpdate.addActionListener {l ->
JDialog dialog = DialogFactory.makeUpdateDialog(mainFrame, dao , lblStatus)
    dialog.setVisible(true)
}

btnDelete.addActionListener {l ->
    try {
        dao.delete(fieldDelete.text.toLong())
       lblStatus.text = "status: delete action executed."
   }catch(Exception ex) {
        lblStatus.text = "status: ${ex.message}"
    }
}

btnFindById.addActionListener {l ->
  try {
      long id = fieldFindById.text.toLong()
    JDialog dialog = DialogFactory.makeOnePersonDialog(mainFrame, dao , lblStatus, id)
      dialog.setVisible(true)
  } catch(Exception ex) {
      lblStatus.text = "status: ${ex.message}"
  }
}


btnFindAll.addActionListener {l ->
   JDialog dialog = DialogFactory.makePeopleDialog(mainFrame, dao, lblStatus)
    dialog.setVisible(true)
}

mainFrame.setVisible(true)


