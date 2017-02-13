package com.edutilos.main

import groovy.transform.Canonical


@Canonical
class EmailMaker {
   String toProp
    String fromProp
    String titleProp
    String contentProp

    def to(String toProp) {
       this.toProp = toProp
    }

    def from(String fromProp) {
        this.fromProp = fromProp
    }

    def title(String titleProp) {
        this.titleProp = titleProp
    }

    def content(String contentProp) {
        this.contentProp = contentProp
    }


}


@Canonical
class EmailDSL {
     EmailMaker maker
    def make(Closure clo) {
        this.maker = new EmailMaker()
        clo.delegate = maker
        clo()

    }

    @Override String toString() {
        return maker.toString()
    }
}


EmailDSL dsl = new EmailDSL()
dsl.make {
    to "foo"
    from "bar"
    title "test closure"
    content "hello world"
}

println(dsl.toString())


