package com.yedam.java.example2;

import java.util.Scanner;

public class StudentProgram implements Program {

	private Scanner sc = new Scanner(System.in);

	@Override
	public void menuPrint() {
		System.out.println("=============================================");
		System.out.println(" 1.정보입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.종료");
		System.out.println("=============================================");
	}

	@Override
	public void inputInfo(Access access) {

		// 사용자가 정보 입력
		Student info = inputAll();

		// 저장소에 등록
		access.insert(info);
	}

	private Student inputAll() {
		System.out.print("학번 > ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("점수 > ");
		int score = Integer.parseInt(sc.nextLine());

		return new Student(id, name, score);
	}

	@Override
	public void printAllInfo(Access access) {
		Student[] list = access.selectAll();
		// 데이터 전체출력
		for (Student student : list) {
			student.showInfo();
		}
	}

	@Override
	public void printInfo(Access access) {

		// 검색 조건 입력
		int id = inputId();
		// 저장소에서 검색
		Student info = access.selectOne(id);
		// 출력
		info.showInfo();
	}

	private int inputId() {
		System.out.print("검색 학번 > ");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void printRepot(Access access) {

		// 최고점수
		System.out.println("최고점수 > ");
		Student maxInfo = selectMaxScore(access);
		maxInfo.showInfo();

		// 최저점수
		System.out.println("최저점수 > ");
		Student minInfo = selectMinScore(access);
		minInfo.showInfo();

		// 평균
		System.out.println("총합의 평균 > ");
		double avgResult = calAvg(access);
		System.out.println(avgResult);
	}

	private Student selectMaxScore(Access access) {
		Student[] list = access.selectAll();
		Student maxInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if (maxInfo.getScore() < list[i].getScore()) {
				maxInfo = list[i];
			}
		}
		return maxInfo;
	}

	private Student selectMinScore(Access access) {
		Student[] list = access.selectAll();
		Student minInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if (minInfo.getScore() > list[i].getScore()) {
				minInfo = list[i];
			}
		}
		return minInfo;
	}

	private double calAvg(Access access) {
		double sum = 0;
		Student[] list = access.selectAll();
		for (Student info : list) {
			sum += info.getScore();
		}

		return sum / list.length;
	}

}
