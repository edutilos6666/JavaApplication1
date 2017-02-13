package com.edutilos.mongodb;


import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;


import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("test2");


        MongoIterable<String> dbNames = client.listDatabaseNames();
        System.out.println("All dbs in mongod");
        for (String dbName : dbNames)
            System.out.println(dbName);

        //no credentials
        List<MongoCredential> credentialList = client.getCredentialsList();
        for (MongoCredential cred : credentialList) {
            String userName = cred.getUserName();
            String password = new String(cred.getPassword());
            String mechanism = cred.getMechanism();
            String source = cred.getSource();
            System.out.println("user , pass, mechanism, source = " + userName + " " + password +
                    " " + mechanism + " " + source);
        }


        db.createCollection("Person");
        MongoCollection<Document> person = db.getCollection("Person");
        //insert some values
        Document doc = new Document("name", "foo")
                .append("age", 10)
                .append("wage", 100.0);
        person.insertOne(doc);
        doc = new Document("name", "bar")
                .append("age", 20)
                .append("wage", 200.0);
        person.insertOne(doc);
        //all people
        System.out.println("before updateOne");
        FindIterable<Document> allPeople = person.find();
        MongoCursor<Document> cursor = allPeople.iterator();
        while (cursor.hasNext()) {
            Document res = cursor.next();
            String name = res.get("name").toString();
            int age = Integer.parseInt(res.get("age").toString());
            double wage = Double.parseDouble(res.get("wage").toString());
            System.out.println(name + " , " + age + " , " + wage);
        }

        person.replaceOne(Filters.eq("name", "foo"), new Document("name", "newFoo").append("age", 66).append("wage", 666.6));

        //all people
        System.out.println("after updateOne");
         allPeople = person.find();
        cursor =  allPeople.iterator();
        while(cursor.hasNext()) {
            Document res = cursor.next();
            String name = res.get("name").toString();
            int age = Integer.parseInt(res.get("age").toString());
            double wage = Double.parseDouble(res.get("wage").toString());
            System.out.println(name + " , "+ age + " , "+ wage);
        }


        //delete
        person.deleteOne(Filters.eq("name", "foo"));
        System.out.println("after delete");
        allPeople = person.find();
        cursor =  allPeople.iterator();
        while(cursor.hasNext()) {
            Document res = cursor.next();
            String name = res.get("name").toString();
            int age = Integer.parseInt(res.get("age").toString());
            double wage = Double.parseDouble(res.get("wage").toString());
            System.out.println(name + " , "+ age + " , "+ wage);
        }


        System.out.println("All people with name bar");
        cursor = person.find(Filters.eq("name", "bar")).iterator();
        while(cursor.hasNext()) {
            Document res = cursor.next();
            String name = res.get("name").toString();
            int age = Integer.parseInt(res.get("age").toString());
            double wage = Double.parseDouble(res.get("wage").toString());
            System.out.println(name + " , "+ age + " , "+ wage);
        }

         db.drop();
        client.close();


    }
}



