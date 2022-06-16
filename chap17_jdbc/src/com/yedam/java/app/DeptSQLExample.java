package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSQLExample {

	public static void main(String[] args) {
		// 1. jdbc driver 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db서버 접속
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pws = "hr";
			
			Connection con = DriverManager.getConnection(url, id, pws);
			//커넥션 만들기 
			
			// 3. crud 실행
			// -1. statement or preparestatemennt 객체 생성하기
			//rr -2. sql 구성 후 실행
			// -3. 결과 출력
			
			// -----------------insert---------------
			String insert = "INSERT INTO departments VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(insert);
			
			pstmt.setInt(1, 1000);
			pstmt.setString(2, "YEDAM");
			pstmt.setInt(3, 100);
			pstmt.setInt(4, 2500);
			
			int result = pstmt.executeUpdate();
			System.out.println("insert 실행 : " + result);
			
			//------------------update---------------
			String update = "UPDATE departments SET department_name = ? WHERE department_id = ?";
			
			pstmt = con.prepareStatement(update);
			
			pstmt.setString(1, "JAVA");
			pstmt.setInt(2, 1000);
			
			result = pstmt.executeUpdate();
			System.out.println("update 실행 : " + result);
			//------------------select---------------
			String select = "SELECT * FROM departments ORDER BY department_id";
			pstmt = con.prepareStatement(select);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String info = "부서번호 : " + rs.getInt("department_id") + ", 부서이름 " + rs.getString("department_name");
				System.out.println(info);
			}
				
			//------------------delete---------------
			String delete = "DELETE FROM departments WHERE department_id = ?";
			pstmt = con.prepareStatement(delete);
			
			pstmt.setInt(1, 1000);
			
			result = pstmt.executeUpdate();
			
			System.out.println("delete 결과 : " + result);
	 		
			// 4. 자원 해제 
			 if(rs != null) rs.close();
			 if(pstmt != null) pstmt.close();
			 if(con != null) con.close();

		} catch (ClassNotFoundException e) {
			System.out.println("db 서버 접속 실패");
		} catch (SQLException e) {
			System.out.println("Query 실행 실패");
		} finally {
			// 4. 자원 해제
		}
	
	}

}
