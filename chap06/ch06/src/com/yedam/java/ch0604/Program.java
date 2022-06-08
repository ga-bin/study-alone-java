package com.yedam.java.ch0604;

// 1. 학생수 입력
// 2. 점수 입력
// 3. 점수리스트 출력
// 4. 분석 - 최고점수, 평균점수

public class Program {
	// 필드
	int[] scores;
	int index;

	// 생성자
	Program() {
		index = -1;
	}
	// 메소드

	// 1. 학생수 입력
	void setStudentNum(int student) {
		scores = new int[student];
	}

	// 2. 점수 입력
	void setStudentScore(int score) {
		scores[++index] = score;
	}

	// 3. 점수리스트 출력
	void printScores() {
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "]> " + scores[i]);
		}
	}

	void printMaxAvg() {
		int max = scores[0];
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
			sum += scores[i];
		}
		System.out.println("최고 점수: " + max);
		System.out.println("평균 점수: " + (double) sum / scores.length);
	}

	// 4-1. 최고점수
	int getMaxScore() {
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {
			int temp = scores[i];
			if (max < temp) {
				max = temp;
			}
		}
		return max;
	}

	// 4-2. 평균점수
	double getAvgScore() {
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		return (double) sum / scores.length;
	}

	// 4. 분석
	void printResult() {
		System.out.println("최고 점수: " + getMaxScore());
		System.out.println("평균 점수: " + getAvgScore());
	}
	
}
