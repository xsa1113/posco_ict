package 자료구조;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex14 {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String,String>();
		
		dic.put("baby", "1");
		dic.put("love", "2");
		dic.put("apple", "3");
		
		Set<String> keys = dic.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			System.out.println("(" + key + "," + value + ")");
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			System.out.print("find word?");
			String eng = sc.next();
			String kor = dic.get(eng);
			
			if(kor == null)
				System.out.println(eng + "not word");
			else
				System.out.println(kor);
		}
	}

}
