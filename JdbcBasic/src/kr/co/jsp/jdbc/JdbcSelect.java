package kr.co.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelect {

	public static void main(String[] args) {

		String sql = "SELECT * FROM members";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "jsp";
		String upw = "jsp";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // SELECT문에서만 사용하는 객체.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			//SELECT문은 executeQuery()를 통해 ResultSet 객체를 받아옵니다.
			//rs는 SELECT문의 쿼리 실행 결과 전체를 들고 있습니다.
			rs = pstmt.executeQuery();
			
			/*
			 - SELECT 쿼리문의 실행 결과, 조회할 데이터가 단 한 줄이라도 존재한다면
			  rs객체의 next()메서드는 true값을 리턴하면서 해당 행을 지목합니다.
			   한 명을 지목해서 물어볼 때는 한 번만 물어봐도 되기 때문에 if문을 사용.
			   여러 값을 얻어올 경우 지속적으로 조회되는 행이 있는지를 파악해야 하기 때문에
			   while문을 이용한 next()를 호출.
			 */
			
			while(rs.next()) {
				/*
				  - SELECT의 실행 결과 컬럼을 읽어오려면
				   rs의 getString(), getInt(), getDouble()....의
				    메서드를 사용합니다. (컬럼 타입에 따라)  
				 */
				String id = rs.getString("id"); //컬럼명!
				String pw = rs.getNString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				System.out.printf("# 아이디: %s\n# 비밀번호: %s\n"
						+
						"# 이름: %s\n# 이메일: %s\n", id, pw, name, email);
				System.out.println("-----------------------------------");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

}














