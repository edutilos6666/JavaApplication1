package com.edutilos.main

import groovy.swing.SwingBuilder

import javax.swing.WindowConstants
import java.awt.Dimension
import java.awt.GridLayout


def builder = new SwingBuilder()

def lblStatus
def fieldId, fieldName , fieldAge
def btnSave , btnCancel


def mainFrame = builder.frame(title:"SwingBuilder",
size: new Dimension(500, 500),
defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
  panel(layout: new GridLayout(6,2)) {
      label(text: "SwingBuilderExample")
      label()

      label(text: "Id:")
      fieldId = textField(columns: 15)

      label(text:"Name:")
      fieldName = textField(columns:15)

      label(text:"Age:")
      fieldAge = textField(columns: 15)

       btnSave = button(text: "Save")
      btnCancel = button(text: "Cancel" )

      lblStatus = label("Status:")
      label()
  }
}

//register listeners
btnSave.addActionListener {l ->
  lblStatus.setText("Status: ${fieldId.text} , ${fieldName.text} , ${fieldAge.text}")
}

btnCancel.addActionListener {l ->
lblStatus.setText("Status:")
    fieldId.text = ""
    fieldName.text = ""
    fieldAge.text = ""
}

mainFrame.setVisible(true)