package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLExample {
	public static void main(String[] args) throws Exception {
		// 1. jdbc driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. db서버 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pws = "hr";
		
		Connection con = DriverManager.getConnection(url, id, pws);
		
		// 3. crud 실행
		// --------------------insert-----------------
		// -1. statement or preparestatemennt 객체 생성하기
		// -2. sql 구성 후 실행
		// -3. 결과 출력
		String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insert);
		pstmt.setInt(1, 1000); 
		// preparedstatement는 set을 통해 ?를 대체한다. 타입만 결정
		// 값으로 들어가는 위치에 ?-t를 이용해야한다.
		// 내가 넣은 ?의 개수만큼 set메소드가 있어야 한다
		// set메소드 순서대로 사용할 필요 없음
		// set메소드 쓸 때 db 컬럼의 데이터 타입 확인하고 그에 맞게 넣자
		pstmt.setString(2, "kil-Dong");
		pstmt.setString(3,  "Hong");
		pstmt.setString(4, "kdHong@google.com");
		pstmt.setString(5, "82.10.1234.1234");
		pstmt.setString(6,  "21/11/05");
		pstmt.setString(7,  "SA_REP");
		pstmt.setInt(8,  6000);
		pstmt.setDouble(9, 0.15);
		pstmt.setInt(10, 149);
		pstmt.setInt(11, 80);
		
		int result = pstmt.executeUpdate(); // insert, update, delete의 경우 executeupdate쓴다
		
		System.out.println("insert 결과 : " + result);
		// --------------------update-----------------
				// -1. statement or preparestatemennt 객체 생성하기
				// -2. sql 구성 후 실행
				// -3. 결과 출력
		String update = "UPDATE employees SET last_name = ? WHERE employee_id = ?";
		
		pstmt = con.prepareStatement(update);
		
		pstmt.setInt(2, 1000);
		pstmt.setString(1, "Kang");
		
		result = pstmt.executeUpdate();
		
		System.out.println("update 결과 : " + result);
		// --------------------SELECT-----------------
				// -1. statement or preparestatemennt 객체 생성하기
				// -2. sql 구성 후 실행
				// -3. 결과 출력
		String select = "SELECT * FROM employees ORDER BY employee_id";
		pstmt = con.prepareStatement(select);
		
		ResultSet rs = pstmt.executeQuery(select);
		
		while(rs.next()) {
			String info = rs.getInt("employee_id") + ":" + rs.getString("last_name");
			System.out.println(info);
	
		}
	
		
		
		// --------------------DELETE-----------------
				// -1. statement or preparestatemennt 객체 생성하기
				// -2. sql 구성 후 실행
				// -3. 결과 출력
		String delete = "DELETE FROM employees WHERE employee_id = ?";
		pstmt = con.prepareStatement(delete);
		
		pstmt.setInt(1, 1000);
		
		result = pstmt.executeUpdate();
		
		System.out.println("delete 결과 : " + result);
		// 4. 자원을 해제 
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (con != null) con.close();
	}
}
