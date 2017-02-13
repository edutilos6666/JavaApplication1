package com.edutilos.main

import org.junit.Test

/**
 * Created by edutilos on 13/02/2017.
 */
class TestSimpleMath extends GroovyTestCase {
    SimpleMath math = new SimpleMath()

    public void  testAdd() {
       int n1 = 10 , n2 = 20
       assertEquals(30 , math.add(n1, n2))
   }


    public void testMulti() {
        int n1 = 10 , n2 = 20

        assertEquals(200 , math.multi(n1, n2))
    }
}
