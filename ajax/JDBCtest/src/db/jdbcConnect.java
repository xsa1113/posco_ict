package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Student;

public class jdbcConnect {
	
	public jdbcConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234");
			System.out.println("MYSQL connection success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public int insertData(int number, String name) {
		String sql = "insert into testtable(number, name)" 
				 	 + " values(" + number + ", '" + name + "')";
		System.out.println(sql);
		
		Connection conn = getConnection();
		Statement state = null;
		
		int count = 0;
		
		try {
			state = conn.createStatement();
			
			count = state.executeUpdate(sql);
			
			System.out.println("성공적으로 추가되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if(conn != null) {
						conn.close();						
					}
					if(state != null) {
						state.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
	}
	
	public boolean createData(String name, int number) {
		String sql = "INSERT INTO TESTTABLE(NUMBER, NAME)"
					+"VALUES(?,?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, name);
			
			count = pstmt.executeUpdate();
			
			System.out.println("정상적으로 추가되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}try {
			if(conn != null) {
				conn.close();						
			}
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count>0?true:false;
		}
	
	
		//insert delete update 0 아니면 1을 반환한다
		//select 90%
	
		public List<Student> allSelect(){
			String sql ="SELECT NUMBER, NAME FROM TESTTABLE";
			
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			List<Student> list = new ArrayList<Student>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Student st = new Student(rs.getInt(1),rs.getString(2));
					list.add(st);
				}
				
				System.out.println("모두 검색하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();						
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			return list;
		}
		
		public boolean update(String name, int number) {
			String sql = "UPDATE TESTTABLE SET NUMBER = ? WHERE NAME = ? ";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, name);
			
			count = pstmt.executeUpdate();
			System.out.println("정상적으로 수정되었습니다");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {

			try {
				if(conn != null) {
					conn.close();						
				}
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
			return count>0 ? true :false;
		}
}
