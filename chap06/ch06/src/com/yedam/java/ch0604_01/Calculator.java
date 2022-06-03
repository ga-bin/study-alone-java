package com.yedam.java.ch0604_01;

public class Calculator {

	int[] numList;
	int index;

	Calculator() {
		index = -1;
	}

	// 1. 갯수 입력
	void setArraySize(int size) {
		numList = new int[size];
		index = -1;
	}

	// 2. 숫자 입력
	void setNum(int num) {
		if (index < numList.length-1) {
			numList[++index] = num;
		} else {
			System.out.println("숫자를 더이상 입력할 수 없습니다.");
		}
	}

	// 3. 더하기
	void plus() {
		if (isExecuted()) {
			int sum = 0;
			// 배열의 크기만큼 입력이 다 들어오지 않아도 2개 이상의 입력이 있으면 실행
			for (int i = 0; i <= index; i++) {      
				sum += numList[i];
			}
			System.out.println("모두 더한 결과 : " + sum);
		}
	}

	// 4. 빼기
	void minus() {
		if (isExecuted()) {
			int num = numList[0];
			// 배열의 크기만큼 입력이 다 들어오지 않아도 2개 이상의 입력이 있으면 실행
			for (int i = 1; i <= index; i++) {      
				num -= numList[i];
			}
			System.out.println("모두 뺀 결과 : " + num);
		}
	}

	// 5. 곱하기
	void multi() {
		if (isExecuted()) {
			int num = numList[0];
			// 배열의 크기만큼 입력이 다 들어오지 않아도 2개 이상의 입력이 있으면 실행
			for (int i = 1; i <= index; i++) {      
				num *= numList[i];
			}
			System.out.println("모두 곱한 결과 : " + num);
		}
	}

	// 6. 나누기
	void divide() {
		if (isExecuted()) {
			double num = numList[0];
			// 배열의 크기만큼 입력이 다 들어오지 않아도 2개 이상의 입력이 있으면 실행
			for (int i = 1; i <= index; i++) {  
				if(numList[i]==0) {
					System.out.println("0으로 나눌수 없습니다.");
					return;
				}
				num /= numList[i];
			}
			System.out.println("모두 나눈 결과 : " + num);
		}
	}

	// 0. 조건체크
	boolean isExecuted() {
		if ((index + 1) >= 2) {
			return true;
		} else {
			System.out.println("숫자를 더 입력해주세요.");
			return false;
		}
	}

}
