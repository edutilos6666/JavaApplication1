package com.edutilos.main

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

//JsonOutput
JsonOutput jsonOut = new JsonOutput()

def workerList = [
        new Worker(1, "foo", 10 , 100),
        new Worker(2, "bar", 20, 200),
        new Worker(3, "bim", 30, 300)
]

println(jsonOut.toJson(workerList))




def map = ["foo": 10 , "bar": 20 , "bim": 30]
println(jsonOut.toJson(map))

Worker w = new Worker(100, "edutilos", 10, 100)
println(jsonOut.toJson(w))


//JsonSlurper
JsonSlurper slurper = new JsonSlurper()
Worker _w = (Worker) slurper.parseText(jsonOut.toJson(w))
println("parsed w = ${_w}")
println(slurper.parseText(jsonOut.toJson(w)))

def newList = slurper.parseText(jsonOut.toJson(workerList))
for(def x in newList)
    println(x)







