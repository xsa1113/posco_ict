package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;

import dto.BbsDto;

public class BbsDao {
	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {

	}
	
	public static BbsDao getInstance() {
		return dao;
	}
	
	public List<BbsDto> getBbsList(){
		String sql  = "SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT FROM BBS ORDER BY REF DESC, STEP ASC limit 10";
	
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
			DBClose.close(conn,pstmt,rs);
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
			DBClose.close(conn,pstmt,null);
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
			DBClose.close(conn,pstmt,rs);
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
			DBClose.close(conn,pstmt,null);
			
		}
		
		return count>0 ? true:false;
		
	}
	
	// 댓글				//부모글의 번호, 새로운 댓글
	public boolean answer(int seq, BbsDto bbs) {
		
		
		   String sql1  = " UPDATE BBS SET STEP= STEP +1 WHERE REF=(SELECT REF FROM(SELECT REF FROM BBS a WHERE SEQ=?) A)"
		            + "AND STEP > (SELECT STEP FROM (SELECT STEP FROM BBS b WHERE SEQ=?) B)";
		      
		      String sql2 = "INSERT INTO BBS(ID,REF,STEP,DEPTH,TITLE,CONTENT, WDATE, DEL, READCOUNT)"
		            + "VALUES (?, "
		            + "(SELECT REF FROM BBS a WHERE SEQ=?),"
		            + "(SELECT STEP FROM BBS a WHERE SEQ=?)+1,"
		            + "(SELECT DEPTH FROM BBS a WHERE SEQ=?)+1,"
		            + "?,?,NOW(),0,0)";

				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false); //이클립스는 자동적으로 db까지 커밋하기 때문에 sql2개쓸때 꺼두는게 좋다
			System.out.println("1/6 answer success");
			
			// update
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, seq);
			pstmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = pstmt.executeUpdate();
			System.out.println("count :" + count);
			System.out.println("3/6 answer success");
			
			// pstmt 초기화
			pstmt.clearParameters();
			
			// insert 
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, bbs.getId());
			pstmt.setInt(2, seq);
			pstmt.setInt(3, seq);
			pstmt.setInt(4, seq);
			pstmt.setString(5, bbs.getTitle());
			pstmt.setString(6, bbs.getContent());
			System.out.println("4/6 answer success");
			
			count = pstmt.executeUpdate();
			System.out.println("5/6 answer success");
			
			// 오토커밋을 꺼뒀기때문에 따로 진행
			conn.commit();
			System.out.println("6/6 answer success");

		} catch (SQLException e) {
			System.out.println(" answer fail ");
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			DBClose.close(conn, pstmt, null);
		}
		
		return count > 0 ? true:false;
		
	}
	
	
	// 검색했을때 확인 리스트 
	public List<BbsDto> getBbsSearchList(String choice, String search){
		String sql  = "SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT"
				+ " FROM BBS ";
			
			String sWord="";
			if(choice.equals("title")) {
				sWord = " WHERE  TITLE LIKE '%" + search +"%' ";
			}else if(choice.equals("content")) {
				sWord = " WHERE CONTENT LIKE '%" + search +"%' ";
			}else if(choice.equals("writer")) {
				sWord =" WHERE dID='" + search + "' ";

			}
			
			sql = sql + sWord;
				
			sql	+= " ORDER BY REF DESC, STEP ASC";
	
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
			DBClose.close(conn,pstmt,rs);
		}
		
		return list;
		
	}
	
	//페이징 리스트 10개 뽑아오기
	public List<BbsDto> getBbsPagingList(String choice, String search,int pageNumber){
		String sql  = " select seq, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT "
				+ " from "
				+ " (select row_number()over(order by ref desc, step asc) as runm, "
				+ "	seq, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT "
				+ " from bbs ";
		
		String sWord="where del = 0 "; 	
		if(choice.equals("title")) {
			sWord = " where del = 0 and TITLE LIKE '%" + search +"% '";
		}else if(choice.equals("content")) {
			sWord = "where del = 0 and CONTENT LIKE '%" + search +"% '";
		}else if(choice.equals("writer")) {
			sWord ="where del = 0 and ID='" + search + "'  ";

		}
		
		sql = sql + sWord;
			
		sql += " order by ref desc, step asc) a "
				+ "where runm between ? and ? ";
		
		int start, end;
		start = 1 + 10 * pageNumber; // 0 -> 1
		end = 10 + 10 * pageNumber; // 0 -> 10
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
				
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 bbslist success");
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
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
			DBClose.close(conn,pstmt,rs);
		}
		
		return list;
		
	}
	
	// 글의 총수 
	public int getAllBbs(String choice, String search) {
		String sql = "select count(*) from bbs ";
		
		String sWord="where del = 0";
		if(choice.equals("title")) {
			sWord = " where del = 0 and TITLE LIKE '%" + search +"%' ";
		}else if(choice.equals("content")) {
			sWord = "where del = 0 and CONTENT LIKE '%" + search +"% '";
		}else if(choice.equals("writer")) {
			sWord =" where del = 0 and ID='" + search + "' ";

		}
		
		sql = sql  + sWord;
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();

			pstmt = conn.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(conn,pstmt,rs);
		}
		
		return result;
	}
	
	
	// 글 수정
	
	public boolean writeUpdate(int seq, String content, String title) {
		String sql = "update bbs set content=? , title = ?  where seq = ?";
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setString(2, title);
			pstmt.setInt(3, seq);
	
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("업데이트 에러");
			e.printStackTrace();
		}finally {
			DBClose.close(conn,pstmt,rs);
		}
		
		return result>0? true:false;
		
	}
	
	
	// 글삭제 
	
	public boolean writeDelete(int seq) {
		String sql = "update bbs set del = 1 where seq=? ";
		
		int result = 0; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("삭제 에러");
			e.printStackTrace();
		}finally {
			DBClose.close(conn,pstmt,null);
		}
		
		return result>0? true: false;
		
		
		
	}
	
}
