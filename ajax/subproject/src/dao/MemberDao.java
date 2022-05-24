package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {
	
private static MemberDao dao = null;
	
	private MemberDao() {
		DBConnection.initConnection();
	}
	
	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	public boolean addMemeber(MemberDto dto) {
		String sql = " insert into subjectcr "
				+ " values(?,?,?,?,?,?,?) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 addMember success");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getBirth());
			psmt.setString(6, dto.getEmail());
			psmt.setInt(7, dto.getTall());
			System.out.println("2/3 addMember success");
			count = psmt.executeUpdate();	
			System.out.println("3/3 addMember success");
		} catch (SQLException e) {
			System.out.println("addMember fail");
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, null);		
		}
		return count>0?true:false;
	}
	
	//delete
	public boolean delete(String id) {
		String sql = "delete from subjectcr where id=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			
			conn = DBConnection.getConnection();
			System.out.println("1/3 deleteMember success");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			System.out.println("2/3 deleteMember success");
			count = psmt.executeUpdate();	
			System.out.println("3/3 deleteMember success");

		} catch (SQLException e) {
			System.out.println("deleteMember fail");
			e.printStackTrace();
			
		}finally {
			DBClose.close(conn, psmt, null);		
		}
		return count>0?true:false;
		
	}
	
	public MemberDto login(MemberDto dto) {
		String sql =  "select * from subjectcr where id = ? and password = ? ";
		
		Connection conn = null;			
		PreparedStatement psmt = null; 	
		ResultSet rs = null;
		
		MemberDto mem = null;
		
		try {			
			conn = DBConnection.getConnection();
			System.out.println("1/3 login success");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			System.out.println("2/3 login success");
			rs = psmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String birth  = rs.getString(5);
				String email = rs.getString(6);
				int tall = rs.getInt(7);
				
				
				mem = new MemberDto(id, pwd,name, email,tall, birth, age);
			}	
			System.out.println("3/3 login success");
			
			if(mem != null) {
				System.out.println("dao mem 있음");
			}else {
				System.out.println("dao mem 없음");

			}
			
		} catch (SQLException e) {
			System.out.println("login fail");
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		return mem;
	}
	

}
