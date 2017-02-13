package com.edutilos.main;

import java.util.*;

/**
 * Created by edutilos on 13/02/2017.
 */
public class PersonDAOMemory implements  PersonDAO{

    private Map<Long , Person> personMap ;
     private int counter = 0 ;

    public PersonDAOMemory() {
      personMap = new HashMap<>();
    }


    @Override
    public void save(Person p) {
        if(checkIfExists(p.getId())) {
            System.out.println("person with id "+ p.getId() + " exists");
            return ;
        }
        long  index = counter ;
         personMap.put(p.getId() , p);
         counter++;
    }

    private boolean checkIfExists(long id) {
        Set<Map.Entry<Long , Person>> entrySet = personMap.entrySet();
       for(Map.Entry<Long , Person> entry: entrySet) {
            if(id == entry.getKey()) return true ;
       }

        return false;
    }

    @Override
    public void update(long id, Person newPerson) {
        if(!checkIfExists(id)) {
            System.out.println("Person with id "+ id + " does not exist.");
            return ;
        }
       personMap.put(id, newPerson);
    }

    @Override
    public void delete(long id) {
       if(!checkIfExists(id)) {
           System.out.println("Person with id " + id + " does not exist.");
           return ;
       }

        personMap.remove(id);
    }

    @Override
    public Person findById(long id) {
        return personMap.get(id);
    }

    @Override
    public List<Person> findAll() {
         List<Person> personList = new ArrayList<>();
        Set<Map.Entry<Long , Person>> entrySet = personMap.entrySet();
        for(Map.Entry<Long , Person> entry : entrySet) {
             personList.add(entry.getValue());
        }

        return personList;
    }
}
