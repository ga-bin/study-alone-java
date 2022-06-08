package com.yedam.java.homework2;

import java.util.Scanner;

public class GameTest {

	// 필드
	Keypad game;
	boolean run = true;
	Scanner sc = new Scanner(System.in);

	GameTest() {
		randomGame();
		while (run) {
			menuPrint();
			int selectNum = userSelect();
			if (selectNum == 1) {
				game.leftUpButton();;
			} else if (selectNum == 2) {
				game.leftDownButton();
			} else if (selectNum == 3) {
				game.rightUpButton();
			} else if (selectNum == 4) {
				game.rightDownButton();
			} else if (selectNum == 5) {
				game.changeMode();
			} else if (selectNum == 0) {
				changeGame();
			} else if (selectNum == 9) {
				exit();
			} else {
				printInputError();
			}
		}
	}

//		
//	
//		
//	- 조건
//		랜덤게임으로 출력결과는 실행 시 설정되는 게임에 따라 달라질 수 있다.

	// 게임 랜덤으로 셋팅하는 클래스
	private void randomGame() {
		int randomNum = (int) (Math.random() + 1);
		if (randomNum == 1) {
			game = new RPGGame();
			System.out.println("rpg게임을 시작합니다.");
		} else if (randomNum == 2) {
			game = new ArcadeGame();
			System.out.println("arcade게임을 시작합니다.");
		}
	}

	private void menuPrint() {
		System.out.println(
				"============================================================================================");
		System.out.println(
				"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
		System.out.println(
				"============================================================================================");
	}

	private int userSelect() {
		System.out.println("choice>");
		int selectNum = Integer.parseInt(sc.nextLine());
		return selectNum;
	}

	private void changeGame() {
		if (game instanceof RPGGame) {
			game = new ArcadeGame();
			System.out.println("arcade 게임을 시작합니다.");
			
		} else if (game instanceof ArcadeGame) {
			game = new RPGGame();
			System.out.println("rpg 게임을 시작합니다.");
		}
	}

	private void exit() {
		System.out.println("프로그램 종료");
		run = false;
		// break;
	}
	
	private void printInputError() {
		System.out.println("0~5, 9의 숫자를 입력하세요");
	}
}
