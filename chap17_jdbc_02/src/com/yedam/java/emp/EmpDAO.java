package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDAO {

	private static EmpDAO empDAO = null;

	// DAO는 가능한 싱글톤으로
	private EmpDAO() {

	}

	public static EmpDAO getInstance() {
		// 기존의 싱글톤은 인스턴스를 필드에 생성
		// 그러면 내가 싱글톤 인스턴스를 사용하든지 말든지 메모리에 공간을 차지하고 있다
		// dao의 경우 내가 접근하려는 테이블에 대해서만 인스턴스를 가지고 있으면 되는데
		// 모든 인스턴스에 대해서 메모리를 가지고 있는 것은 비효율적인 방법
		// new연산자를 통해서 인스턴스를 생성하는 순간을 조정하는것
		// 클래스에 있는 모든 인스턴스는 사용될것이라는 전제하에 만들어지는경우가 대부분
		// but하나만 동작하고 끝나는 경우도 있음
		// 필드에 직접 new연산자를 넣으면 프로젝트가 돌때 무조건 인스턴스가 생성됨
		// 사용하는 시점에 인스턴스를 생성하겠다는 것을 좀 더 명확하게 코드로 보여준 것일 뿐
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}

	// Oracle 연결 정보
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;

	// 각 메소드에서 공통적으로 사용하는 필드
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

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
		// config 패키지만들기 -> db.properties만들기
		// driver=oracle.jdbc.driver.OracleDriver
//		url=jdbc:oracle:thin:@localhost:1521:xe
//				id=hr
//				password=hr
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

	// 3. CRUD 실행
	// 전체조회
	public List<Employee> selectAll() {
		// db에서 몇개의 정보가 들어올지 몰라서 배열 못쓴다.
		List<Employee> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees");
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));

				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	public Employee selectOne(int employeeId) {
		Employee emp = null;
		// 단건조회는 null로 초기화, 대응되는 값이 있는지 없는지 확인하면 됨
		try {
			connect();
			String sql = "SELECT * FROM employees WHERE employee_id =" + employeeId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 한건만 데이터를 반환할 거라서 while문 사용안함
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartment_id(rs.getInt("department_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}

	// 등록
	public void insert(Employee emp) {
		// db에 들어갈 내용 프로그램이 입력받고 그걸 dao에 넘겨주는것
		try {
			connect();
			String sql = "INSERT INTO employees VALUE (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9, emp.getCommissionPct());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartment_id());

			int result = pstmt.executeUpdate();

			if (result > 0) {
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
	public void update(Employee emp) {
		// 연봉수정
		try {
			connect();
			String sql = "UPDATE employees SET salary = ? WHERE employee_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, emp.getEmployeeId());
			pstmt.setDouble(1, emp.getSalary());

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
	// 삭제
	public void delete(int employeeId) {
		try {
			connect();
			String sql = "DELETE FROM employees WHERE employee_id = " + employeeId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
