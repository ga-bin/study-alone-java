package com.yedam.java.ch0603;

	// 점수분석 프로그램 만들기
	// 1. 학생 수 입력
	// 2. 점수 입력
	// 3. 점수리스트 출력
	// 4. 분석 출력 - 최고점수, 평균점수
	// 5. 종료 - 프로그램 종료 출력
public class Program {	
	// 필드
	int[] scores;
	int index;
	// 생성자
	int maxScore;
	int sum;
	double avg;
	
	Program() {
		index = -1;
	}
	
	// 메소드
	// 1. 학생수 입력
	void setStudentNum(int student) {
		scores = new int[student]; // 학생수 만큼 길이를 가지고 있는 배열 객체 생성
	}
	
	// 2. 점수 입력
	void setStudentScores(int score) {
		scores[++index] = score; // score에 값이 들어오면 ++로 인해 인덱스가 올라가는 방식
		}

	
	// 3. 점수리스트 출력
	void printScores() {
		for(int i = 0; i < scores.length; i++) {
			System.out.println("scroes[" + i + "]" + scores[i]);
		}
	}
	
//	4. 최댓값, 평균점수 출력
	void printMaxAvg() {
		// 최댓값
		for (int i = 0; i <scores.length; i++) {
			if (maxScore < scores[i]) {
				maxScore = scores[i];
			}
		}
		System.out.println("최댓값 : " + maxScore);
		// 값 다 더하기
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		// 평균
		avg = (double)sum / scores.length; // int 끼리 평균구하면 소수점이하 날라가기 때문에 강제 형변환하자!
		System.out.println("평균 : " + avg);
		
	}
	
	// 4-1. 최고점수
//		int getMaxScore() {
//			int max = scores[0];
//			for (int i = 0; i < scores.length; i++) {
//				int temp = scores[i];
//				if (max < temp) {
//					max = temp;
//				}
//			}
//			return max;
//	}
	// 4-2. 평균점수
//		double getAvgScore() {
//			int sum = 0;
//			for(int i = 0; i < scores.length; i++) {
//				sum += scores[i];
//			}
//			avg = sum / scores.length;
//			return avg; // return sum / scores.length;도 가능
//		}
		
//	// 4-3. 분석 메소드(한꺼번에 호출)
//		void printResult() {
//			System.out.println("최고 점수 : " + getMaxScore());
//			System.out.println("평균 : " + getAvgScore());
//		}
 }
