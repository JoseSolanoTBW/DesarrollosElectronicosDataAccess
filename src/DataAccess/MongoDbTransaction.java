package DataAccess;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;


public class MongoDbTransaction {

	private MongoDbConnection MongoConnection;
	
	public MongoDbTransaction() {
		MongoConnection = new MongoDbConnection("localhost" , 27017);
	}
	
	public void InsertDocuement(Object obj, String collectionName)
	{
		MongoCollection<Document> collection = MongoConnection.getMongoDataBase().getCollection(collectionName);
		
		Gson gson = new Gson();
	    
		String result = gson.toJson(obj);
	      
	    Document dbObject = gson.fromJson(result, Document.class);		
	    
	    collection.insertOne(dbObject);
	}
	
	public ArrayList<Object> GetData(Object obj, String collectionName) 
	{
		ArrayList<Object> results  = new ArrayList<Object>();
		MongoCollection<Document> collection = MongoConnection.getMongoDataBase().getCollection(collectionName);
		
		List<Document> documents = (List<Document>) collection.find().into(
				new ArrayList<Document>());
		
		Gson gson = new Gson();
		
		for(Document document : documents){
			
			String result = gson.toJson(document);			
			
			results.add((Object)gson.fromJson(result, obj.getClass()));
        }
		
		return results;
	}
	
}
