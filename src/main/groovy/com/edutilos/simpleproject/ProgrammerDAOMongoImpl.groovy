package com.edutilos.simpleproject

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoCursor
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.bson.Document


class ProgrammerDAOMongoImpl implements ProgrammerDAO {

    private MongoClient client
    private MongoDatabase db
    private MongoCollection<Document> docs

    //properties
    private final String host = "localhost"
    private final int port = 27017
    private final String dbName = "test2"
    private final String collProgrammers = "programmer"

    private void connect() {
      client = new MongoClient(host , port)
        db = client.getDatabase(dbName)
        docs = db.getCollection(collProgrammers)
    }

    private void disconnect() {
      // db.drop()
        client.close()
    }

    @Override
    void save(Programmer pro) {
       connect()
        docs.insertOne(new Document("id", pro.id)
        .append("name", pro.name)
        .append("age", pro.age)
        .append("wage", pro.wage)
        .append("patient", pro.patient))
        disconnect()
    }

    @Override
    void update(long id, Programmer newPro) {
        connect()
        docs.replaceOne(Filters.eq("id", id),
        new Document("id", newPro.id)
        .append("name", newPro.name)
        .append("age", newPro.age)
        .append("wage", newPro.wage)
        .append("patient", newPro.patient))
        disconnect()
    }

    @Override
    void delete(long id) {
       connect()
        docs.deleteOne(Filters.eq("id", id))
        disconnect()
    }

    @Override
    Programmer findById(long id) {
        connect()
        Document doc = docs.find(Filters.eq("id", id)).first()
        disconnect()
        return docToProgrammer(doc)
    }

    private Programmer docToProgrammer(Document doc) {
        long id = doc.get("id").toString().toLong()
        String name = doc.get("name").toString()
        int age = doc.get("age").toString().toInteger()
        double wage = doc.get("wage").toString().toDouble()
        boolean patient = doc.get("patient").toString().toBoolean()
        return new Programmer(id, name, age, wage, patient)
    }

    @Override
    List<Programmer> findAll() {
        connect()
        List<Programmer> list = []
        MongoCursor<Document> cursor = docs.find().iterator()
        while(cursor.hasNext()) {
            Document doc = cursor.next()
            list.add(docToProgrammer(doc))
        }

        disconnect()
        return list
    }

    @Override
    void deleteAll() {
        connect()
          db.drop()
        disconnect()
    }
}
