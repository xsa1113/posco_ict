
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Update {
	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mydb");
			MongoCollection mongoCollection = mongoDatabase.getCollection("test");
			mongoCollection.updateOne(Filters.eq("title","javascript"), Updates.set("author","song"));
			
			FindIterable iterDoc = mongoCollection.find();
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
