package DataAccess;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDbConnection {

	public MongoDbConnection(String host, int port) {
		
		Mongo = new MongoClient(host, port);
		MongoDataBase = Mongo.getDatabase("DesarrollosElectronicosProcesos");		
	}
	
	private MongoClient Mongo;
	
	private MongoDatabase MongoDataBase;

	public MongoClient getMongo() {
		return Mongo;
	}

	public MongoDatabase getMongoDataBase() {
		return MongoDataBase;
	}	
	
	
}
