package com.edutilos.mongodb;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.edutilos.main.Person;
import com.edutilos.main.PersonDAO;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by edutilos on 13/02/2017.
 */
public class Example2 {
    public static void main(String[] args) {
        //turn off logger for mongodb
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.OFF);

        PersonDAO dao = new PersonDAOMongo();
        Person p1 = new Person(1 , "foo", 10, 100.0);
        Person p2 = new Person(2, "bar", 20, 200.0);
        dao.save(p1);
        dao.save(p2);

        System.out.println("all people: ");
        List<Person> personList = dao.findAll();
        for(Person p: personList) {
            System.out.println(p);
        }

       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        dao.update(1L , new Person(1, "newBar", 66, 666));
        System.out.println("all people after update: ");
        personList = dao.findAll();
        for(Person p: personList) {
            System.out.println(p);
        }



        dao.delete(1L);
        System.out.println("after delete by id = 1");
        personList = dao.findAll();
        for(Person p: personList) {
            System.out.println(p);
        }


        ((PersonDAOMongo)dao).drop();
    }
}
