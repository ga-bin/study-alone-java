package com.yedam.java.emp;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		EmpDAO instance = EmpDAO.getInstance();
		
//		List<Employee> list = EmpDAO.getInstance().selectAll();
//		for(Employee emp : list) {
//			System.out.println(emp);
//		}

		Employee info = EmpDAO.getInstance().selectOne(100);
		System.out.println(info);
	}

}
