package com.edutilos.main

import junit.textui.TestRunner


def suite = new GroovyTestSuite()
suite.addTestSuite(com.edutilos.main.TestSimpleMath)

TestRunner.run(suite)