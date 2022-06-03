package com.yedam.java.ch0603;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		Program program = new Program(); // 바깥에 선언안하면 while문이 돌때마다 새로운 객체 계속생성되고 프로그램 초기화된다.
		
		while(run) {
			System.out.println("1.학생 수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
			System.out.println("선택>");
			int selectNum = Integer.parseInt(scan.nextLine());
			if(selectNum == 1) {
				System.out.println("학생 수>");
				int student = Integer.parseInt(scan.nextLine());
				program.setStudentNum(student);
			}else if (selectNum == 2) {
				System.out.println("점수>");
				int score = Integer.parseInt(scan.nextLine());
				program.setStudentScores(score);
			}else if (selectNum == 3) {
				program.printScores();
			}else if (selectNum == 4) {
				program.printMaxAvg();
			}else if (selectNum == 5) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}

}
