package kr.co.jsp.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO {

	private DataSource ds;
	
	private UserDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	/////////////////////////////////////////////////////////
	
	
	@Override
	public boolean confirmId(String id) {
		boolean flag = false;
		
		String sql = "SELECT * FROM my_user WHERE user_id=?";
		
		/*
		 # try with resource
		 - try문을 작성할 때 자원 객체를 소괄호 안에 전달하면, 
		 try블록이 끝날 때 자동으로 자원을 해제해 줍니다.
		 - 자동으로 종료되는 자원은 반드시 AutoCloseable 인터페이스의 구현체여야 합니다.
		 */
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO my_user VALUES(?,?,?,?,?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int userCheck(String id, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO getUserInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(String id, String newPw) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub

	}

}
