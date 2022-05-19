package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import db.DBclose;
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
	
	public boolean addMember(MemberDto dto) {
		String sql = " INSERT INTO MEMBER(ID,PWD,NAME,EMAIL,AUTH) "
					+ " VALUES(?,?,?,?,3) ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0; 
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 addMember success");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			System.out.println("2/3 addMember success");

			count = pstmt.executeUpdate();
			System.out.println("3/3 addMember success");
			
		} catch (SQLException e) {
			System.out.println("addMember fail");

			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt, null);
		}
		return count>0?true:false;
	}
	
	
	public boolean idCheck(String id) {
		String sql = "SELECT ID FROM MEMBER WHERE ID = ?";
		
		// 합계를 낼 수 잇다, 중복체크를 위함 
		/* String sql2 = "SELECT COUNT(*) FROM MEMBER WHERE ID=?"; */
		
		Connection conn = null; // DB 연결용 
		PreparedStatement pstmt = null; // Query 실해용
		ResultSet rs = null; // 결과값 출력
		
//		List<MemberDto> list = new ArrayList<>();
		
		int count = 0; 
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				count = 1;
				//값이 있으면 
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt, rs);
		}
		return count>0?true:false;		
	}
	
	public MemberDto login(MemberDto dto) {
		String sql = "SELECT ID,NAME,EMAIL,AUTH FROM MEMBER WHERE ID=? AND PWD=?";
		
		Connection conn = null; // DB 연결용 
		PreparedStatement pstmt = null; // Query 실해용
		ResultSet rs = null; // 결과값 출력
		
		MemberDto mem = null;
	
		conn = DBConnection.getConnection();
		System.out.println("1/3 login success");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			System.out.println("2/3 login success");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int auth = rs.getInt(4);
				
				mem = new MemberDto(id,null,name,email,auth);
			}
			System.out.println("3/3login success");
		} catch (SQLException e) {
			System.out.println("login fail");
			e.printStackTrace();
		} finally {
			DBclose.close(conn, pstmt, rs);
		}
		return mem;
	}
	
	
}
