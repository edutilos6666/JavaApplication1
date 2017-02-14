package com.edutilos.simpleproject

import groovy.sql.Sql

import java.sql.DriverManager


class ProgrammerDAOSqlImpl implements ProgrammerDAO {

    private Sql sql

    //props
    private final String user = "root"
    private final String pass = ""
    private final String url = "jdbc:mysql://localhost/test"

    ProgrammerDAOSqlImpl() {
         setup()
    }

    private void setup() {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver())
        connect()
        String cmd = """
create table if not exists Programmer(
id bigint not null primary key ,
name varchar(50) not null ,
age int  not null,
wage double not null,
patient boolean not null
)"""
        sql.executeUpdate(cmd)
        disconnect()
    }

    private void connect() {
     sql = Sql.newInstance(url, user, pass)
    }

    private void disconnect() {
      sql.close()
    }

    @Override
    void save(Programmer pro) {
        connect()

        String cmd = """
insert into Programmer VALUES
(${pro.id}, "${pro.name.toString()}", ${pro.age}, ${pro.wage}, ${pro.patient})
"""
        sql.executeUpdate(cmd)
        disconnect()
    }

    @Override
    void update(long id, Programmer newPro) {
      connect()
        String cmd = """
update Programmer set name = "${newPro.name}", age = ${newPro.age},
wage = ${newPro.wage}, patient = ${newPro.patient} where id = ${newPro.id}
"""
         sql.executeUpdate(cmd)
        disconnect()
    }

    @Override
    void delete(long id) {
     connect()
        String cmd = """
delete from Programmer where id = ${id}
"""
        sql.executeUpdate(cmd)
        disconnect()
    }

    @Override
    Programmer findById(long id) {
        Programmer p = null
        connect()
        sql.eachRow("""select * from Programmer where id = ${id}"""){ row ->
            p = new Programmer(row.ID , row.NAME, row.AGE, row.WAGE, row.PATIENT)
        }
        disconnect()
        return p
    }

    @Override
    List<Programmer> findAll() {
        connect()
        List<Programmer> list = new ArrayList<>()
        sql.eachRow("""select * from Programmer""") {row ->
         list.add(new Programmer(row.ID , row.NAME, row.AGE, row.WAGE, row.PATIENT))
        }
        disconnect()
        return list
    }

    @Override
    void deleteAll() {
        connect()
        sql.executeUpdate("""delete from  Programmer""")
       disconnect()
    }
}
