package chap17_jdbc_01_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSQLExample {

	public static void main(String[] args) throws Exception {
		try {
			// 1. jdbc 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. db접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		Connection con = DriverManager.getConnection(url, id, pwd);
		// 3. crud 실행
		// ------------insert ---------------------
		// 쿼리문 구성
		String insert = "INSERT INTO departments value(?, ?, ?, ?)";
		// statement or prepareStatememt 객체 생성
		PreparedStatement pstmt = con.prepareStatement(insert);
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "YEDAM");
		pstmt.setInt(3, 200);
		pstmt.setInt(4, 1400);
		// 결과 출력
		int result = pstmt.executeUpdate();
		System.out.println("insert 결과 " + result);
		
		// -----------------update----------------
		// 쿼리문 작성
		String update = "UPDATE departments SET department_name = ? WHERE department_id = ?";
		// prepareStatement 객체에 update집어 넣기
		pstmt = con.prepareStatement(update);
		pstmt.setString(1, "YEDAM!");
		pstmt.setInt(2, 1400);
		// 결과문 출력
		result = pstmt.executeUpdate();
		System.out.println("update 결과 : " + result);
		
		// -----------------select-----------------
		// 쿼리문 작성
		String select = "SELECT * from departments order by department_id";
		// prepareStatement 객체에 select집어 넣기
		pstmt = con.prepareStatement(select);
		// 결과문 출력
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("department_id") + " : " + rs.getString("department_name"));
		}
		// -----------------delete-----------------
		// 쿼리문 작성
		String delete = "DELETE from departments WHERE department_id = ?";
		// prepareStatement객체에 delete넣기
		pstmt = con.prepareStatement(delete);
		pstmt.setInt(1, 1000);
		// 결과문 출력
		result = pstmt.executeUpdate();
		System.out.println("delete 결과 " + result);
		
		// 4. 자원 해제하기
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (con != null) con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("접속 실패");
		} catch (SQLException e) {
			System.out.println("Query 실행 실패");
		} finally {
			
		}
	}

}
