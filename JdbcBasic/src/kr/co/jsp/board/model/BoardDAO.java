package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.jsp.util.JdbcUtil;

public class BoardDAO implements IBoardDAO {

	private BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	
	
	//////////////////////////////////////////////////////////
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	//Connection 객체를 얻을 수 있는 유틸 메서드
	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "jsp";
		String upw = "jsp";
		
		return DriverManager.getConnection(url, uid, upw);
	}
	
	
	@Override
	public boolean insert(BoardVO vo) {
		boolean flag = false;
		
		String sql = "INSERT INTO board "
				+ "(board_id, writer, title, content) "
				+ "VALUES(bid_seq.NEXTVAL,?,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			if(pstmt.executeUpdate() == 1) flag = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		return flag;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM board ORDER BY board_id DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
							rs.getInt("board_id"),
							rs.getString("writer"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getDate("reg_date")
						);
				articles.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return articles;
	}

	@Override
	public BoardVO selectOne(int bId) {
		BoardVO vo = null;
		
		String sql = "SELECT * FROM board WHERE board_id=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO(
							rs.getInt("board_id"),
							rs.getString("writer"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getDate("reg_date")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}

	@Override
	public boolean update(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int bId) {
		// TODO Auto-generated method stub
		return false;
	}

}
