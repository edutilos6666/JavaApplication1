package com.edutilos.main

import groovy.xml.MarkupBuilder


def adder = {n1, n2 -> n1 + n2}
def multiplier = {n1, n2 -> n1 * n2}



int n1 = 10 , n2 = 20

def sum = adder.call(n1, n2)
def multi = multiplier.call(n1, n2)

println("sum = "+ sum)
println("multi = "+ multi)



def myList = [1,2,3,4, 5,6, 7, 8,9]

myList.each {print it + " "}
println ""

def every = myList.every {it >= 1}
def any = myList.any{it >= 9}

println("every = "+ every)
println("any = "+ any)


def list2 = []
list2 = myList.collect {el -> el*2 }

list2.each {print it +" "}
println ""


def methodCall(Closure clo , double n1 , double n2) {
    double res = clo.call(n1, n2)
    println("res = "+ res)
}

n1 = 10
n2 = 20
methodCall({_n1, _n2 -> _n1 + _n2}, n1 , n2)
methodCall({_n1 , _n2 -> _n1 * _n2}, n1 , n2)
methodCall(multiplier, n1, n2)



def res = myList.find {el -> el%2 == 0}
def res2 = myList.findAll{el -> el%2 == 0}

println(res)
println(res2)


def map = ["name": "foo", "age": 10 , "wage": 100]
map.each{entry ->
  def key = entry.key
    def value= entry.value
    println(key + " => "+ value)
}


Person p1 , p2 , p3
p1 = new Person(1, "foo", 10, 100.0)
p2 = new Person(2, "bar", 20, 200.0)
p3 = new Person(3, "bim", 30, 300.0)

def personList = [p1, p2, p3]

def xmlWriter = new StringWriter()
def builder = new MarkupBuilder(xmlWriter)

builder.people("type": "people") {
  personList.each{p ->
     String _id = p.id.toString()
      String _name = p.name
      String _age = p.age.toString()
      String _wage = p.wage.toString()

      person() {
          id(_id)
          name(_name)
          age(_age)
          wage(_wage)
      }
  }
}

println(builder.toString())


def  people =new XmlSlurper().parseText(xmlWriter.toString())
def alls = people.person
println(alls.first().name.text())
println(alls.last().age+ " "+ alls.last().wage)


println(xmlWriter.toString())




def parser = new XmlParser()
def _people = parser.parse("person.xml")
_people.each{person ->
  def name = person.name[0].text()
    def age = person.age[0].text()
    println(name +  " " + age)
}


















