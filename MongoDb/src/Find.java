import java.util.Iterator;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Find {
	public static void main(String[] args) {
		try {
			// mogodb에 접속
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// 데이터베이스 연결 
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mydb");
			// 컬렉션 연결
			MongoCollection collection = mongoDatabase.getCollection("books");			
			// 다큐멘트 조회
			FindIterable iterDoc = collection.find();
			int i=1;
			Iterator it = iterDoc.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getClass().getName() + e.getMessage());
			
		}
	}

}
