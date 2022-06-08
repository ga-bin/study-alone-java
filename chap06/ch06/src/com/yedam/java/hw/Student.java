package com.yedam.java.hw;

public class Student {
	// 필드
		int[] scores;
		int index;

		// 생성자
		Student() {
			index = -1;
		}
		// 메소드

		// 1. 학생수 입력
		void setStudentNum(int student) {
			scores = new int[student];
		}

		// 2. 점수 입력
		void setStudentScore(int score) {
			if (index < scores.length-1) {
				scores[++index] = score;
			} else {
				System.out.println("숫자를 더이상 입력할 수 없습니다.");
			}
		}

		// 3. 점수리스트 출력
		void printScores() {
			for (int i = 0; i <= index; i++) {
				System.out.println((i+1)+") 점수 : " + scores[i]+"점");
			}
		}


		// 4-1. 최고점수
		int getMaxScore() {
			int max = scores[0];
			for (int i = 0; i <= index; i++) {
				int temp = scores[i];
				if (max < temp) {
					max = temp;
				}
			}
			return max;
		}
		
		int getMinScore() {
			int min = scores[0];
			for (int i = 0; i <= index; i++) {
				int temp = scores[i];
				if (min > temp) {
					min = temp;
				}
			}
			return min;
		}

		// 4-2. 평균점수
		double getAvgScore() {
			double sum = 0;
			for (int i = 0; i <= index; i++) {
				sum += scores[i];
			}
			sum-=getMaxScore();
			sum-=getMinScore();
			return  sum /(index-1);
		}

		// 4. 분석
		void printResult() {
			System.out.println("최고 점수: " + getMaxScore());
			System.out.println("최저 점수: " + getMinScore());
			System.out.printf("평균 점수: %.2f\n", getAvgScore());
		}
}
