package com.edutilos.main


println("hello world")


def filename = "foo.txt"

def  name = "foo"
int   age = 10
double wage = 100.0
def active = true
def nl = "\r\n"

new File(filename).withWriter('utf-8') {writer ->
  writer.write(name)
    writer.write(nl)
  writer.write(age.toString()+nl)
    //writer.write(nl)
    writer.write(wage.toString()+nl)
    //writer.write(nl)
    writer.writeLine(active.toString())
    //writer.write(nl)
}



new File(filename).each {line ->
 println(line)
}

println("file.text method: ")
println(new File(filename).text)



def file = new File(filename)
file.isAbsolute()
file.isDirectory()
file.isFile()
file.isHidden()



def dir = new File("foo")
dir.mkdir()

dir = new File("edu/tilos")
dir.mkdirs()
def file2 = new File("newfoo.txt")
file2 << file.text


new File(filename).delete()


file = new File("c:/Windows/system32")
def files = file.listFiles(new FilenameFilter() {
  @Override
  boolean accept(File d, String n) {
    return n.endsWith(".dll")
  }
});



int counter  = 0 ;

file.eachFile {f ->
++counter
}

int counter2 = 0
file.eachFileRecurse {f ->
 ++counter2
}

println("eachFile = "+ counter)
println("eachFileRecurse = "+ counter2)

