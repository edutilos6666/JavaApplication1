package com.edutilos.main;

/**
 * Created by edutilos on 13/02/2017.
 */
public class Person {
    private long id;
    private String name;
    private int age ;
    private double wage;


    public Person(long id, String name, int age, double wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", wage=" + wage +
                '}';
    }
}
