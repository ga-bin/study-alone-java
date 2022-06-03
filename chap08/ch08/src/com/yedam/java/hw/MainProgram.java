package com.yedam.java.hw;

import java.util.Scanner;

public class MainProgram {

	// field
	private Scanner sc = new Scanner(System.in);
	private BookAccess dao = BookRepo.getInstance();
	private BookProgram bp = new BookSystem();

	// constructor
	public MainProgram() {
		while (true) {
			bp.menuPrint();
			int menuNo = selecMenu();

			if (menuNo == 1) {
				bp.inputInfo(dao);
			} else if (menuNo == 2) {
				bp.printAll(dao);
			} else if (menuNo == 3) {
				bp.searchBook(dao);
			} else if (menuNo == 4) {
				bp.Analysis(dao);
			} else if (menuNo == 5) {
				exit();
				break;
			} else {
				err();
			}

		}
	}

	private int selecMenu() {
		System.out.print("선택 > ");
		return Integer.parseInt(sc.nextLine());
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void err() {
		System.out.println("지원하지 않는 기능입니다.");
	}

}
