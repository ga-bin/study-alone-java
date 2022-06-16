package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepartmentDAO {
	// DAO는 가능한 싱글톤으로
	private static DepartmentDAO departmentDAO = null;
	
	private DepartmentDAO() {
		
	};
	
	public static DepartmentDAO getInstance() {
		if (departmentDAO == null) {
			departmentDAO = new DepartmentDAO();  
		}
		return departmentDAO;
	}
	
	// Oracle 연결정보
	String jbdc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;
	
	
	// 각 메소드에서 공통적으로 사용하는 필드
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void connect() {
		dbConfig();
		try {
			// 1. jdbc driver 로딩
			Class.forName(jbdc_driver);
			// 2. db서버 접속
			con = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("db 접속 실패");
		}
		
		
	}
	
	public void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		
		try {
			String filePath = ClassLoader.getSystemResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		jbdc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}
	
	public void disconnect() {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	// crud실행
	// 전체조회
	public List<DepartmentVO> selectAll() {
		List<DepartmentVO> list = new ArrayList<>();
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM departments");
			while(rs.next()) {
				DepartmentVO department = new DepartmentVO();
				department.setDepartmentId(rs.getInt("department_id"));
				department.setDepartmentName(rs.getString("department_name"));
				department.setLocationId(rs.getInt("location_id"));
				department.setManagerId(rs.getInt("manager_id"));
				
				list.add(department);
			}
			
			
		} catch (SQLException e){
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 단건조회
	public DepartmentVO selectOne(int departmentId) {
		DepartmentVO department = null;
		try {
			connect();
			String sql = "SELECT * FROM departments WHERE department_id = " + departmentId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				department = new DepartmentVO();
				department.setDepartmentId(rs.getInt("department_id"));
				department.setDepartmentName(rs.getString("department_name"));
				department.setLocationId(rs.getInt("location_id"));
				department.setManagerId(rs.getInt("manager_id"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return department;
	}
	
	
	// 등록 
	public void insert(DepartmentVO department) {
		try {
			connect();
			String sql = "INSERT INTO departments VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, department.getDepartmentId());
			pstmt.setString(2, department.getDepartmentName());
			pstmt.setInt(3, department.getManagerId());
			pstmt.setInt(4,department.getLocationId());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0 ) {
				System.out.println("등록이 완료되었습니다.");
			} else {
				System.out.println("등록이 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 수정
	public void Update(DepartmentVO department) {
	try {	
		connect();
		String sql = "UPDATE departments SET department_name = ? WHERE department_id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, department.getDepartmentName());
		pstmt.setInt(2, department.getDepartmentId());
		
		int result = pstmt.executeUpdate();
		
		if (result > 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정이 실패했습니다.");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	}
	
	
	//삭제
	public void Delete(int departmentId) {
		try {
			connect();
			String sql = "DELETE FROM departments WHERE department_id = " + departmentId;
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
