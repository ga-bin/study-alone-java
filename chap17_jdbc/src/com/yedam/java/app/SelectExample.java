package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws Exception {
		// 1. jdbc driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. db서버 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // db접근경로
		String id = "hr"; // 계정 정보
		String pws = "hr"; // 패스워드
		
		Connection con = DriverManager.getConnection(url, id, pws);
		
		// 3. statement or preparedstatement 객체 생성하기
		Statement stmt = con.createStatement(); // connection이용해서 statement만드는 것
		
		// 4. query 구성
		String sql = "SELECT first_name, last_name FROM employees WHERE last_name = 'King'"; // SQL문 마지막에 세미콜론 빼자
		
		// 5. query 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		// 6. 결과값 출력하기
		// 총 크기를 알수없어서 while문 사용
		while(rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name"); // get~는 반환하는 데이터 타입을 지정해줘야한다. ""안에는 컬럼명 그대로
			System.out.println(name); // 컬럼명을 개별적으로 가져온다.

		}
		// 7. 자원해제하기
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
