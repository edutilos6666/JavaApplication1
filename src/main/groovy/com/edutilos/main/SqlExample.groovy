package com.edutilos.main

import groovy.sql.Sql

import java.sql.DriverManager


final String user = "root"
final String pass = ""
final String url = "jdbc:mysql://localhost/test"

DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver())



//drop table
def cmd = """
drop table if exists worker
"""

def sql = Sql.newInstance(url, user, pass)
sql.executeUpdate(cmd)
sql.close()

//create table
cmd = """
create table if not exists worker (
id bigint not null primary key ,
name varchar(50) not null ,
age int not null,
wage double not null
)
"""

sql = Sql.newInstance(url, user, pass)
sql.executeUpdate(cmd)
sql.close()


//insert into table
def workerList = [
        new Worker(1, "foo", 10, 100.0),
        new Worker(2, "bar", 20, 200.0),
        new Worker(3, "bim", 30, 300.0)
]

sql = Sql.newInstance(url, user, pass)
workerList.each{worker ->
 cmd = "insert into worker values(${worker.id}, ${worker.name}, ${worker.age}, ${worker.wage})"
   sql.executeUpdate(cmd)
}

sql.close()


//select all workers
sql = Sql.newInstance(url, user, pass)
sql.eachRow("select * from worker") {row ->
  println("${row.ID}, ${row.NAME}, ${row.AGE}, ${row.WAGE}")
}

sql.close()


//update by id
sql = Sql.newInstance(url, user, pass)
String name = "newFoo"
int age = 66
double wage = 666.6
long id = 1
cmd = """
update worker
set name = ${name}, age = ${age}, wage = ${wage}
where id = ${id}
"""

sql.executeUpdate(cmd)
sql.close()

println("select after update")
sql = Sql.newInstance(url, user, pass)
sql.eachRow("select * from worker where id = ${id}") { row ->
    println("${row.ID}, ${row.NAME}, ${row.AGE}, ${row.WAGE}")
}
sql.close()



//delete
id = 2
cmd = """
delete from worker
where id = ${id}"""

sql = Sql.newInstance(url, user, pass)
sql.executeUpdate(cmd)
sql.close()

println("after delete: ")
sql = Sql.newInstance(url, user , pass)
sql.eachRow("select * from worker") {row  ->
    println("${row.ID}, ${row.NAME}, ${row.AGE}, ${row.WAGE}")
}

sql.close()