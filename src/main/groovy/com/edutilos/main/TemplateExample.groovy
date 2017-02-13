package com.edutilos.main

import groovy.text.SimpleTemplateEngine


def file = new File("PersonTemplate.xml")

def templateEngine = new SimpleTemplateEngine()
def template = templateEngine.createTemplate(file.newReader())
def writable = template.make([name: 'foo', age: 10, wage: 100.0])
println writable