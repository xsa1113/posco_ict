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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		List<MemberDto> list = new ArrayList<>();
		
		int count = 0; 
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			String name = "";
			while(rs.next()) {
				name = rs.getString(1);
			}
			
			if(id == name) {
				// 동일한게 있다는 것 
				count = 1;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt, rs);
		}
		return count>0?true:false;
		
		
	}
	
}
