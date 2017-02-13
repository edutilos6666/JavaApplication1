package com.edutilos.mongodb;


import com.edutilos.main.Person;
import com.edutilos.main.PersonDAO;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOMongo implements PersonDAO{

    private MongoClient client ;
    private MongoDatabase db ;
    private MongoCollection<Document> personColl ;

    private void connect() {
      client = new MongoClient("localhost", 27017);
        db = client.getDatabase("test2");
        personColl = db.getCollection("Person");
    }

    private void disconnect() {
        client.close();
    }

    public void drop() {
        connect();
        db.drop();
        disconnect();
    }

    @Override
    public void save(Person p) {
       connect();
       personColl.insertOne(new Document("id", p.getId())
       .append("name", p.getName())
       .append("age", p.getAge())
       .append("wage", p.getWage()));

        disconnect();
    }

    @Override
    public void update(long id, Person newPerson) {
      connect();
        personColl.replaceOne(Filters.eq("id", id), new Document("id", id)
        .append("name", newPerson.getName())
        .append("age", newPerson.getAge())
        .append("wage", newPerson.getWage()));
        disconnect();
    }

    @Override
    public void delete(long id) {
      connect();
        personColl.deleteOne(Filters.eq("id", id));
        disconnect();
    }

    @Override
    public Person findById(long id) {
           connect();
        MongoCursor<Document> cursor = personColl.find(Filters.eq("id", id)).iterator();
        if(!cursor.hasNext()) {
            System.out.println("no person with id "+ id);
            return null ;
        }
        Document doc = cursor.next();
        disconnect();
         return documentTOPerson(doc);
    }

      private Person documentTOPerson(Document doc) {
          Person p = new Person();
          p.setId(Long.parseLong(doc.get("id").toString()));
          p.setName(doc.get("name").toString());
          p.setAge(Integer.parseInt(doc.get("age").toString()));
          p.setWage(Double.parseDouble(doc.get("wage").toString()));
          return p;
      }


    @Override
    public List<Person> findAll() {
        connect();
        List<Person> personList = new ArrayList<>();
        MongoCursor<Document> cursor = personColl.find().iterator();
        while(cursor.hasNext()) {
            Document doc = cursor.next();
            personList.add(documentTOPerson(doc));
        }
        disconnect();
        return personList;
    }
}
