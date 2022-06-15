package chap17_jdbc_01_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLExample {

	public static void main(String[] args) throws Exception {
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
		// statement or prepareStatememt 객체 생성
		String insert = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(insert);
		
		pst.setInt(1, 1000);
		pst.setString(2, "Kil-dong");
		pst.setString(3, "Hong");
		pst.setString(4, "kdHong123");
		pst.setString(5, "82.10.1234.1234");
		pst.setString(6, "21/11/05");
		pst.setString(7, "SA_REP");
		pst.setInt(8, 6000);
		pst.setDouble(9, 0.15);
		pst.setInt(10, 149);
		pst.setInt(11, 80);
		
		// 결과 출력
		int result = pst.executeUpdate();
		System.out.println("insert결과" + result);
		
		// -----------------update----------------
		// 쿼리문 작성
		// prepareStatement 객체에 update집어 넣기
		String update = "UPDATE employees SET last_name = ? WHERE employee_id = ? ";
		pst = con.prepareStatement(update);
		pst.setString(1, "Kang");
		pst.setInt(2, 1000);
		// 결과문 축력
		result = pst.executeUpdate();
		System.out.println("update 결과 " + result);
		
		// -----------------select-----------------
		// 쿼리문 작성
		String select = "SELECT * FROM employees ORDER BY employee_id";
		// prepareStatement 객체에 select집어 넣기
		pst = con.prepareStatement(select);
		// 결과문 출력
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String name = rs.getInt("employee_id") + " : " + rs.getString("first_name");
			System.out.println(name);
		}
		
		// -----------------delete-----------------
		// 쿼리문 작성
		// prepareStatement객체에 delete넣기
		String delete = "DELETE from employees where employee_id = ?";
		pst = con.prepareStatement(delete);
		pst.setInt(1, 1000);
		
		// 결과문 출력
		result = pst.executeUpdate();
		System.out.println("DELETE 결과 " + result);
		
		// 4. 자원 해제하기
		if (rs != null) rs.close();
		if (pst != null) pst.close();
		if (con != null) con.clearWarnings();
		
	}

}
