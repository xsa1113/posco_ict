package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import db.DBclose;
import dto.BbsDto;

public class BbsDao {
	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {

	}
	
	public static BbsDao getInstance() {
		return dao;
	}
	
	public List<BbsDto> getBbsList(){
		String sql  = "SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT FROM BBS ORDER BY REF DESC, STEP ASC";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
				
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 bbslist success");
		
			pstmt = conn.prepareStatement(sql);
			System.out.println("2/4 bbslist success");
			
			rs = pstmt.executeQuery();
			System.out.println("3/4 bbslist success");
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), 
										rs.getString(2), 
										rs.getInt(3), 
										rs.getInt(4), 
										rs.getInt(5), 
										rs.getString(6), 
										rs.getString(7), 
										rs.getString(8), 
										rs.getInt(9), 
										rs.getInt(10));
				
				list.add(dto);
			}
			System.out.println("4/4 bbslist success");
			
		} catch (SQLException e) {
			System.out.println("bbslist fail");
			e.printStackTrace();
		}finally {
			DBclose.close(conn,pstmt,rs);
		}
		
		return list;
		
	}
	
	public boolean insertBbs(BbsDto dto) {
		String sql  = " INSERT INTO BBS(ID,REF,STEP,DEPTH,TITLE,CONTENT,WDATE,DEL,READCOUNT) "
				+ " VALUES(?,(select ifnull(max(ref),0)+1 from bbs a), 0,0,?,?, now(),0,0) ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			System.out.println("2/3 writeBbs success");
			
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("놉");
			
			e.printStackTrace();
		}finally {
			DBclose.close(conn,pstmt,null);
		}
		
		return count > 0 ? true: false;
	}
	
	public BbsDto selectWriter(int seq){
		String sql = "SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT FROM BBS WHERE SEQ = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BbsDto dto = null;
		
	
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 selectWriter success");
			pstmt = conn.prepareStatement(sql);
			System.out.println("2/4 selectWriter success");
			pstmt.setInt(1, seq);
			
			
			rs = pstmt.executeQuery();
			System.out.println("3/4 bbslist success");
			
			if(rs.next()) {
				dto = new BbsDto(rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10));
				
			}
			System.out.println("4/4 bbslist success");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBclose.close(conn,pstmt,rs);
		}
		
		return dto ;
	}
	
	public boolean count(int seq) {
		String sql  = "update bbs set readcount = readcount+1 where seq = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0;
		try {
			
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			count = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose.close(conn,pstmt,null);
			
		}
		
		return count>0 ? true:false;
		
	}
	
}
