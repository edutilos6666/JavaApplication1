package com.edutilos.main;

import java.util.List;

/**
 * Created by edutilos on 13/02/2017.
 */
public interface PersonDAO {
   public void save(Person p);
   public void update(long id, Person newPerson);
    public void delete(long id);
    public Person findById(long id);
    public List<Person> findAll();
}
