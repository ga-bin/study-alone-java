package com.yedam.java.ch0604;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Program program = new Program();
		
		while(run) {
			
			System.out.println("1. 학생 수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.print("선택> ");
			int selecNo = Integer.parseInt(sc.nextLine());
			if(selecNo==1) {
				System.out.print("학생수> ");
				int student = Integer.parseInt(sc.nextLine());
				program.setStudentNum(student);
			}else if(selecNo==2) {
				System.out.print("점수> ");
				int score = Integer.parseInt(sc.nextLine());
				program.setStudentScore(score);				
			}else if(selecNo==3) {
				program.printScores();
			}else if(selecNo==4) {
				program.printResult();
			}else if(selecNo==5) {
				run=false;
				System.out.println("프로그램 종료");
			}
			
			
			
		}
	}

}
