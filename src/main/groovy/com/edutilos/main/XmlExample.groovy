package com.edutilos.main

import groovy.xml.MarkupBuilder


//build xml
def xmlWriter = new StringWriter()
MarkupBuilder builder = new MarkupBuilder(xmlWriter)


def workerList = [
        new Worker(1, "foo", 10 , 100.0),
        new Worker(2, "bar", 20 , 200.0),
        new Worker(3, "bim", 30, 300.0)
]

builder.workers() {
 workerList.each {w ->
    worker("id": w.id) {
        name(w.name)
        age(w.age.toString())
        wage(w.wage.toString())
    }
 }
}


println(xmlWriter.toString())


File file = new File("workers.xml")
def writer = file.newWriter()


writer.write(xmlWriter.toString())


writer.close()



//parsing workers.xml
XmlParser parser = new XmlParser()
def workers = parser.parse("workers.xml")

workers.each {w->
  def id = w['@id']
    def name = w.name[0].text()
    def age = w.age[0].text()
    def wage = w.wage[0].text()
    println(id + " "+ name + " "+ age + " "+ wage)
}


