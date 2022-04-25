import java.sql.*;
//예제 mysql연동
public class Books {

	public static void main(String[] args) {
		// url 필요 
		// 1.드라이버 로딩
		// 2.데이터베이스 연결
		// 3.sql 실행
		// 4.결과
		
		String url = "jdbc:mysql://localhost:3306/web";
		String id = "root";
		String password = "1234";
		Connection conn = null; // database 연결하기 위한 conn 객체 생성, db에 접속
		Statement stmt = null; //sql 명령어 실행하기 위한 객체
		ResultSet rs =null; //결과셋 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버 로딩
			conn = DriverManager.getConnection(url, id, password);
			String sql = "select * from books";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // sql 실행 객체
			while(rs.next()) {
				int book_code = rs.getInt("book_code");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				System.out.println(book_code+"\t"+title+"\t"+author+"\t"+year+"\t"+price);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}

	}
