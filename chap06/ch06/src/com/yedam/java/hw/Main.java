package com.yedam.java.hw;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Student s=new Student();
		
		while(run) {
			
			System.out.println("1. 학생 수입력 | 2. 학생점수 입력 | 3. 학생점수 전체조회 | 4. 학생정보 분석 | 5. 종료");
			System.out.print("선택> ");
			int selecNo = Integer.parseInt(sc.nextLine());
			if(selecNo==1) {
				System.out.print("학생수> ");
				int student = Integer.parseInt(sc.nextLine());
				s.setStudentNum(student);
			}else if(selecNo==2) {
				System.out.print("점수> ");
				int score = Integer.parseInt(sc.nextLine());
				s.setStudentScore(score);				
			}else if(selecNo==3) {
				s.printScores();
			}else if(selecNo==4) {
				s.printResult();
			}else if(selecNo==5) {
				run=false;
				System.out.println("프로그램 종료");
			}
			
			
			
		}

	}

}
