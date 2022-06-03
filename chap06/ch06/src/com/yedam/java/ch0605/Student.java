package com.yedam.java.ch0605;

public class Student {
	int[] student;
	int index;

	Student() {
		index = 0;
	}

	// 1. 학생수 입력
	void setArraySize(int size) {
		student = new int[size];
		index = 0;
	}

	// 2. 점수 입력
	void setScore(int score) {
		if (index < student.length) {
			student[index++] = score;
		} else {
			System.out.println("점수를 더이상 입력할 수 없습니다.");
		}
	}

	// 3. 전체조회
	void printAll() {
		for (int i = 0; i < index; i++) {
			System.out.println((i+1) + ")점수 : " + student[i]+"점");
		}
	}

	// 4. 분석
	void printResult() {
		System.out.println("최고점 : " + highScore());
		System.out.println("최저점 : " + lowScore());
		System.out.printf("평균 : %.2f\n", avg());
	}

	// 4-1. 최고점
	int highScore() {
		int high = student[0];
		for (int i = 0; i < index; i++) {
			if (student[i] > high) {
				high = student[i];
			}
		}
		return high;
	}

	// 4-2. 최저점
	int lowScore() {
		int low = student[0];
		for (int i = 0; i < index; i++) {
			if (student[i] < low) {
				low = student[i];
			}
		}
		return low;
	}

	// 4-3. 평균
	double avg() {
		double sum = 0;
		for (int i = 0; i < index; i++) {
			sum += student[i];
		}
		sum -= highScore();
		sum -= lowScore();
		return sum / (index - 1);
	}
}
