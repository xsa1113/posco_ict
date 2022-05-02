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
			// 동적으로 실행할때 preparedstatement
			// 정적으로 실행할때 Statement stmt 라는 객체를 만들고
			// stmt.executeQuery(sql)로 실행
			String sql = "select * from 고객 where 등급 = ? and 나이 > ?";
//			stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// 처음 ? 에 silver 담기, 2째에 20 담기
			pstmt.setString(1, "gold");
			pstmt.setInt(2,20);

			rs = pstmt.executeQuery(); // sql 실행 객체
			while(rs.next()) {
				String book_code = rs.getString("고객아이디");
				String title = rs.getString("고객이름");
				String author = rs.getString("나이");
				String year = rs.getString("등급");
				String price = rs.getString("직업");
				int point = rs.getInt("적립금");
				System.out.println(book_code+"\t"+title+"\t"+author+"\t"+year+"\t"+price+"\t"+point);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}

	}
