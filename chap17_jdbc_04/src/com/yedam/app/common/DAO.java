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

public class DAO {
	// Oracle DB정보
	private String jdbc_driver;
	private String oracle_url;
	private String connectedId;
	private String connectedPwd;
	
	// 공통적으로 사용할 필드
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DAO() {
		dbConfig();
	}
	
	// db에 접속하는 메소드
	public void connection() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
			
		} catch(ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch(SQLException e) {
			System.out.println("DB 연결실패");
			
		}
	}
	
	
	// db 정보를 가져오는 메소드
	public void dbConfig() {
		// properties 를 사용하면 key, value형태만 유지되면 알아서 값을 가진다.
		// properties는 map 형태로 되어있음
		// config 패키지만들기 -> db.properties만들기
		// driver=oracle.jdbc.driver.OracleDriver
//		url=jdbc:oracle:thin:@localhost:1521:xe
//				id=hr
//				password=hr
		String resource = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath)); // properties.load를 이용해야 key와 value형태를 유지한 상태로 파일 가지고오기가능

		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");

	}
	
	// db 접속을 해제하는 메소드
	public void disconnection() {
		try {
			if (rs != null) rs.close(); // nullpointerexception을 막으려고
			if (stmt != null) rs.close();
			if (pstmt != null) rs.close();
			if (conn != null) rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
