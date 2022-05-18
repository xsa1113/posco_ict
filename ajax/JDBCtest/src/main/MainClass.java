package main;

import java.util.List;

import db.jdbcConnect;
import dto.Student;

public class MainClass {
	public static void main(String[] args) {
		
		
		jdbcConnect jdbcconn = new jdbcConnect();
		
		//jdbcconn.getConnection();
		
		String name = "홍길동";
		int number = 1001;
		
		//int count = jdbcconn.insertData(number, name);
		//System.out.println("count : " + count );
		
		name = "성춘향";
		number = 1003;
		
//		boolean b = jdbcconn.createData(name, number);
//		if(b) {
//			System.out.println("문제없음");
//		}
		
		
		boolean b = jdbcconn.update(name, number);
		if(b) {
			System.out.println("업뎃문제없음");
		}
		
		List<Student> list = jdbcconn.allSelect();
		
		for(Student x : list) {
			System.out.println(x.toString());
		}
		
	}
}
