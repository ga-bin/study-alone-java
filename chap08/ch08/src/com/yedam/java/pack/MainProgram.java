package com.yedam.java.pack;

import java.util.Scanner;

public class MainProgram {

	private Scanner sc = new Scanner(System.in);
	private Program pro = new PlayerProgram();
	private Access dao = PlayerRepo.getInstance();

	public MainProgram() {
		while (true) {
			pro.menuPrint();
			int selec = selectMenu();
			if (selec == 1) {
				pro.inputInfo(dao);
			} else if (selec == 2) {
				pro.printAll(dao);
			} else if (selec == 3) {
				pro.search(dao);
			} else if (selec == 4) {
				pro.analyze(dao);
			} else if (selec == 5) {
				exit();
				break;
			}
		}
	}

	private int selectMenu() {
		System.out.print("입력 > ");
		return Integer.parseInt(sc.nextLine());
	}

	private void exit() {
		System.out.println("프로그램종료");
	}

}
