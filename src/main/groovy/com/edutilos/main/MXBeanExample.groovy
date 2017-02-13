package com.edutilos.main

import java.lang.management.GarbageCollectorMXBean
import java.lang.management.ManagementFactory
import java.lang.management.OperatingSystemMXBean




   println("<<OS>>")
    def os = ManagementFactory.operatingSystemMXBean
    def name = os.getName()
    def arch = os.getArch()
    def version = os.getVersion()
    def processors = os.getAvailableProcessors()
    def systemLoadAverage = os.getSystemLoadAverage()


    println("name = "+ name)
    println("arch = "+ arch)
   println("version = "+ version)
println("processors = "+ processors)
println("systemLoadAverage = "+ systemLoadAverage)


     println("<<Classloader>>")
      def cl = ManagementFactory.classLoadingMXBean;
     def totalLoadedClassCount = cl.getTotalLoadedClassCount()
    def loadedClassCount = cl.getLoadedClassCount()
  def unloadedClassCount = cl.getUnloadedClassCount()
   def isVerbose = cl.isVerbose()
    println("totalLoadedClassCount = ${totalLoadedClassCount}")
println("loadedClassCount = ${loadedClassCount}")
println("unloadedClassCount = ${unloadedClassCount}")
println("isVerbose = ${isVerbose}")


  println("<<Runtime>>")
def runtime = ManagementFactory.runtimeMXBean;
def runtimeName = runtime.getName()
def runtimeVmName = runtime.getVmName()
def runtimeVmVendor = runtime.getVmVendor()
def runtimeVmVersion = runtime.getVmVersion()
def runtimeSpecName = runtime.getSpecName()
def runtimeSpecVendor = runtime.getSpecVendor()
def runtimeSpecVersion = runtime.getSpecVersion()
def runtimeManagementSpecVersion = runtime.getManagementSpecVersion()
def runtimeClassPath = runtime.getClassPath()
def runtimeLibraryPath = runtime.getLibraryPath()
def runtimeIsBootClassPathSupported = runtime.isBootClassPathSupported()
def runtimeBootClassPath = runtime.getBootClassPath()
def runtimeInputArguments = runtime.getInputArguments()
def runtimeUptime = runtime.getUptime()
def runtimeStartTime = runtime.getStartTime()
def runtimeSystemProperties = runtime.getSystemProperties()

println("runtimeName = ${runtimeName}")
println("runtimeVmName = ${runtimeVmName}")
println("runtimeVmVendor = ${runtimeVmVendor}")
println("runtimeVmVersion = ${runtimeVmVersion}")
println("runtimeSpecName = ${runtimeSpecName}")
println("runtimeSpecVendor = ${runtimeSpecVendor}")
println("runtimeSpecVersion = ${runtimeSpecVersion}")
println("runtimeManagementSpecVersion = ${runtimeManagementSpecVersion}")
println("runtimeClassPath = ${runtimeClassPath}")
println("runtimeLibraryPath = ${runtimeLibraryPath}")
println("runtimeIsBootClassPathSupported = ${runtimeIsBootClassPathSupported}")
println("runtimeBootClassPath = ${runtimeBootClassPath}")
println("runtimeInputArguments = ${runtimeInputArguments}")
println("runtimeUptime = ${runtimeUptime}")
println("runtimeStartTime = ${runtimeStartTime}")
println("runtimeSystemProperties = ${runtimeSystemProperties}")


println("<<Compilation>>")
def compilation = ManagementFactory.compilationMXBean
def compilationName = compilation.getName()
def compilationIsMonitoringSupported = compilation.isCompilationTimeMonitoringSupported()
def totalCompilationTime = compilation.getTotalCompilationTime()
println("compilationName = ${compilationName}")
println("compilationIsMonitoringSupported = ${compilationIsMonitoringSupported}")
println("totalCompilationTime = ${totalCompilationTime}")



println("<<GC>>")
List<GarbageCollectorMXBean> gcs = ManagementFactory.garbageCollectorMXBeans;
for(def gc in gcs) {
    def gcCollectionCount = gc.getCollectionCount()
    def gcCollectionTime = gc.getCollectionTime()
    println("collectionCount = ${gcCollectionCount}, collectiomTime = ${gcCollectionTime}")
    String[] poolNames = gc.memoryPoolNames
    println(poolNames)
}
