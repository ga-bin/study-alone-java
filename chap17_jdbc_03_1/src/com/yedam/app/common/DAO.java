package com.yedam.app.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DAO {
	// db연결
	private String jdbc_driver;
	private String oracle_url;
	private String connectedId;
	private String connectedPwd;

	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	public void connect() {
		dbconfig();
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(oracle_url);
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver로딩 실패");
		} catch (SQLException e) {
			System.out.println("db 접속실패");
		}
	}

	public void dbconfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
	
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}

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
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
