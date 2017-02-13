package com.edutilos.main

import groovy.swing.SwingBuilder

import javax.swing.WindowConstants
import java.awt.FlowLayout
import java.awt.GridLayout


//variables
def lblStatus
def fieldId , fieldName , fieldAge
def btnSave , btnCancel

def builder = new SwingBuilder()

def panelWelcome = {
    builder.panel(layout: new FlowLayout()) {
        label(text: "SWingBuilder Example 2")
        label()
    }
}

def panelId = {
    builder.panel(layout: new FlowLayout()) {
        label(text: "Id:")
        fieldId = textField(columns: 15)
    }
}

def panelName = {
     builder.panel(layout:new FlowLayout()) {
         label(text: "Name:")
         fieldName = textField(columns: 15)
     }
}

def panelAge = {
    builder.panel(layout: new FlowLayout()) {
        label(text:"Age:")
        fieldAge = textField(columns:15)
    }
}


def panelButtons = {
    builder.panel(layout:new FlowLayout()) {
        btnSave = button(text: "Save")
        btnCancel = button(text:"Cancel")
    }
}

def panelStatus = {
    builder.panel(layout: new FlowLayout()) {
        lblStatus = label(text: "Status")
        label()
    }
}

def panelRoot = {
    builder.panel(layout: new GridLayout(6, 1)) {
        panelWelcome()
        panelId()
        panelName()
        panelAge()
       panelButtons()
        panelStatus()
    }
}




def mainFrame = builder.frame(title: "Hello World", size: [500, 500],
defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
    panelRoot()
}


//register events
btnSave.addActionListener {l ->
    lblStatus.text = "Status: ${fieldId.text} , ${fieldName.text}, ${fieldAge.text}"
}

btnCancel.addActionListener {l ->
    lblStatus.text = ""
    fieldId.text = ""
    fieldName.text = ""
    fieldAge.text = ""
}


mainFrame.setVisible(true)





