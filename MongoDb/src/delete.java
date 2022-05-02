import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class delete {
	public static void main(String[] args) {
		
		
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mydb");
			MongoCollection collection = mongoDatabase.getCollection("test");
			Document query = new Document("title", "javascript");
			collection.deleteOne(query);
			
			FindIterable iterDoc = collection.find();
			int i=1;
			Iterator it = iterDoc.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
				i++;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + e.getMessage());
		}
		
		
	}

}
