package com.yedam.java.example2;

import java.util.Scanner;

public class MainProgram {

	// field
	private Scanner sc = new Scanner(System.in);
	private Access dao = StudentRepo.getInstance();
	private Program pro = new StudentProgram();

	// constructor
	public MainProgram() {
		while (true) {
			// 메뉴출력
			pro.menuPrint();

			// 메뉴선택
			int menuNo = menuSelect();

			// 각 메뉴 실행
			if (menuNo == 1) {
				pro.inputInfo(dao);
			} else if (menuNo == 2) {
				pro.printAllInfo(dao);
			} else if (menuNo == 3) {
				pro.printInfo(dao);
			} else if (menuNo == 4) {
				pro.printRepot(dao);
			} else if (menuNo == 5) {
				exit();
				break;
			}

		}

	}

	// method

	private void exit() {
		System.out.println("프로그램 종료");
	}

	private int menuSelect() {
		System.out.println("선택 > ");
		return Integer.parseInt(sc.nextLine());
	}

}
