import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Insert {
	public static void main(String[] args) {
		
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mydb");
			MongoCollection collection = mongoDatabase.getCollection("test");
			//basicDbObject 클래스 이용하여 삽입
			Document docu1 = new Document("title", "javascript")
					.append("author","park" )
					.append("price", 300);
			Document docu2 = new Document("title", "HTML5")
					.append("author","sung" )
					.append("price", 400);
			
			// 리스트 하나 씩 만들어주기
			
			List<Document> list = new ArrayList<>();
			
			list.add(docu1);
			list.add(docu2);
			// 굳이 배열 돌 필요없다
//			for(Document x : list) {
//				collection.insertOne(x);
//			}
			
//			listMany를 통해서 가능
			collection.insertMany(list);
			
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
