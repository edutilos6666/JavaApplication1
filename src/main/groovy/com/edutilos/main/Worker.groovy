package com.edutilos.main

import groovy.transform.ToString
import groovy.transform.TupleConstructor

/**
 * Created by edutilos on 13/02/2017.
 */
@ToString
@TupleConstructor
class Worker {
    long id
  String name
    int age
    double wage
}
