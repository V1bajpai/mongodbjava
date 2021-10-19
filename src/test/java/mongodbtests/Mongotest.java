package mongodbtests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//import com.mongodb.client.*;

public class Mongotest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating a Mongo client
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
//		MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));

		// Accessing the database
		MongoDatabase database = mongo.getDatabase("testing");
		
		// Creating a collection
//		database.createCollection("sampleCollection");
//		System.out.println("Collection created successfully");
		
		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("employees");
		System.out.println("Collection sampleCollection selected successfully");	
		insertSingleIntoDatabase(collection); // call fun insertSingleIntoDatabase
	    selectAllRecordsFromACollection(collection);  // call fun selectAllRecordsFromACollection
	}
	
	// Single node insertion
	public static void insertSingleIntoDatabase(MongoCollection collection) {
		Document document1 = new Document("name", "Peterson")
		.append("age", 22)
		.append("city", "Kabul")
		.append("salary", 22000);
		collection.insertOne(document1);   //       Inserting document into the collection
	}
	
	public void insertManyIntoDatabase(MongoCollection collection) {
		  Document document1 = new Document("name", "Ram").append("age", 26).append("city", "Hyderabad").append("salary", 10000);
	      Document document2 = new Document("name", "Robert").append("age", 27).append("city", "Vishakhapatnam").append("salary", 11000);
	      Document document3 = new Document("name", "Gonna").append("age", 30).append("city", "Delhi").append("salary", 12000);
	      Document document4 = new Document("name", "Jerry").append("age", 30).append("city", "Kanpur").append("salary", 13000);
	      Document document5 = new Document("name", "Backy").append("age", 30).append("city", "Nagpur").append("salary", 14000);
	      Document document6 = new Document("name", "Simon").append("age", 30).append("city", "Mumbai").append("salary", 15000);
	      Document document7 = new Document("name", "Mangos").append("age", 30).append("city", "Sujanpur").append("salary", 16000);
	      Document document8 = new Document("name", "Darvin").append("age", 30).append("city", "Noida").append("salary", 17000);
	      Document document9 = new Document("name", "Larry").append("age", 30).append("city", "Gurugram").append("salary", 18000);
	      Document document10 = new Document("name", "Mack").append("age", 30).append("city", "Agra").append("salary", 19000);
		  Document document11 = new Document("name", "Robin").append("age", 23).append("city", "London").append("salary", 23000);

	      //Inserting the created documents
	      List<Document> list = new ArrayList<Document>();
	      list.add(document1);
	      list.add(document2);
	      list.add(document3);
	      list.add(document4);
	      list.add(document5);
	      list.add(document6);
	      list.add(document7);
	      list.add(document8);
	      list.add(document9);
	      list.add(document10);
		  list.add(document11);

	      collection.insertMany(list);  // Insert many
		  System.out.println("Document inserted successfully");
	}
	
	private static void selectAllRecordsFromACollection(MongoCollection collection) 
	{
		  FindIterable<Document> iterDoc = collection.find();
	      Iterator it = iterDoc.iterator();
	      while (it.hasNext()) {
	         System.out.println(it.next());
	      }
	}

}
