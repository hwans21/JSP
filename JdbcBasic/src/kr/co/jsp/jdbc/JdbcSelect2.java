package kr.co.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcSelect2 {

	public static void main(String[] args) {

		/*
		 - 회원의 ID를 스캐너를 통해 입력받아
		  해당 ID의 모든 정보를 출력하는 Jdbc 프로그래밍 코드를 작성하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회하실 아이디를 입력하세요: ");
		String userId = sc.next();
		
		String sql = "SELECT * FROM members WHERE id=?";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "jsp";
		String upw = "jsp";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("---------- 회원 정보 ----------");
				System.out.println("# 아이디: " + rs.getString("id"));
				System.out.println("# 비밀번호: " + rs.getString("pw"));
				System.out.println("# 이름: " + rs.getString("name"));
				System.out.println("# 이메일: " + rs.getString("email"));
			} else {
				System.out.println("존재하지 않는 ID입니다.");
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close(); pstmt.close(); conn.close(); sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
















