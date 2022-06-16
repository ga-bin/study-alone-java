package com.yedam.java.emp;

import java.util.List;
import java.util.Scanner;

public class DepartmentSystem {
	private DepartmentDAO dao = DepartmentDAO.getInstance();
	Scanner sc = new Scanner(System.in);
	
	public DepartmentSystem() {
		while(true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			
			// 각 기능별 실행
			if (menuNo == 1) {
				// 등록
				insertDepartment();
			} else if (menuNo == 2) {
				// 수정
				updateDepartment();
			}else if (menuNo == 3) {
				// 삭제
				deleteDepartment();
			}else if (menuNo == 4) {
				// 단건조회
				selectDepartment();
			}else if (menuNo == 5) {
				// 전체조회
				selectAllDepartment();
			}else if (menuNo == 9) {
				// 종료
				exit();
				break;
			}else {
				// 수정
				inputError();
				break;
			}
					
		}
		
	}
	
	private void menuPrint() {
		System.out.println("================================================");
		System.out.println("1.등록  2.수정  3.삭제   4.단건조회   5. 전체저회   9.종료");
		System.out.println("=================================================");
	}
	
	private void exit() {
		System.out.println("프로그램 종료");
	}
	
	private void inputError() {
		System.out.println("메뉴에 있는 숫자를 입력하세요");
	}
	private int selectMenu() {
		return inputNumber();
	}
	
	private int inputNumber() {
		int num = 0;
		System.out.println("숫자를 입력하세요");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	private void insertDepartment() {
		DepartmentVO department = inputAll();
		dao.insert(department);
		
	}
	
	private DepartmentVO inputAll() {
		DepartmentVO department = new DepartmentVO();
		System.out.println("부서번호>");
		department.setDepartmentId(inputNumber());
		System.out.println("부서이름>");
		department.setDepartmentName(sc.nextLine());
		System.out.println("상사>");
		department.setManagerId(inputNumber());
		System.out.println("지역");
		department.setLocationId(inputNumber());
		return department;
	}
	
	private void updateDepartment() {
		// 수정하는 정보 입력
		DepartmentVO department = inputUpdateInfo();
		dao.Update(department);
	}
	
	private DepartmentVO inputUpdateInfo() {
		DepartmentVO department = new DepartmentVO();
		System.out.println("부서번호>"); 
		department.setDepartmentId(inputNumber());
		System.out.println("지역"); 
		department.setLocationId(inputNumber());
		return department;
	}
	
	private void deleteDepartment() {
		System.out.println("부서번호를 입력하세요");
		int departmentId = inputNumber();
		dao.Delete(departmentId);
	}
	
	private void selectDepartment() {
		System.out.println("부서번호 입력하세요");
		int departmentId = inputNumber();
		DepartmentVO department = dao.selectOne(departmentId);
		if (department != null) {
			System.out.println(department);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}
	
	private void selectAllDepartment() {
		List<DepartmentVO> list = dao.selectAll();
		for (DepartmentVO department : list) {
			System.out.println(department);
		}
	}
	
}
