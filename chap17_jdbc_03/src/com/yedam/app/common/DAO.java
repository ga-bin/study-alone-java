package com.yedam.app.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// DB에 연결하고 끊는 역할
public class DAO {
		// Oracle 연결 정보
		private String jdbc_driver; // 상속받아서쓰지도 않음 private
		private String oracle_url;
		private String connectedId;
		private String connectedPwd;

		// 각 메소드에서 공통적으로 사용하는 필드
		protected Connection conn; // 상속이 일어나기 때문에 필드를 protected로 바꿔줘야함
		protected Statement stmt;
		protected PreparedStatement pstmt;
		protected ResultSet rs;
		
		public void connect() {
			dbConfig();
			try {
				// 1. JDBC DRIVER 로딩
				Class.forName(jdbc_driver);
				// 2. DB서버 접속
				conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver 로딩 실패");
			} catch (SQLException e) {
				System.out.println("DB 접속 실패");
			}
		}

		public void dbConfig() {
			// properties 를 사용하면 key, value형태만 유지되면 알아서 값을 가진다.
			// properties는 map 형태로 되어있음
			// config 패키지만들기 -> db.properties만들기
			// driver=oracle.jdbc.driver.OracleDriver
//			url=jdbc:oracle:thin:@localhost:1521:xe
//					id=hr
//					password=hr
			String resource = "config/db.properties";
			Properties properties = new Properties();

			try {
				String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
				properties.load(new FileInputStream(filePath));

			} catch (IOException e) {
				e.printStackTrace();
			}
			jdbc_driver = properties.getProperty("driver");
			oracle_url = properties.getProperty("url");
			connectedId = properties.getProperty("id");
			connectedPwd = properties.getProperty("password");

		}

		// 4. 자원 해제
		public void disconnect() {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
