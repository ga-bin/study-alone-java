package com.yedam.java.ch0604_01;

public class Calculator {
	// 필드
	int[] numList; // 숫자를 입력받을 배열
	int index; //
	int sum;
	double divideNum;
	int minusNum;
	int multiNum;
	

	// 1. 숫자 갯수 입력받음
	// 2. 갯수만큼 숫자 입력받음
	// 3. 더하기
	// 4. 빼기
	// 5. 곱하기
	// 6. 나누기

	// 생성자
	Calculator() {
		index = -1;
	}

	// 메소드
	// 1. 숫자 개수 입력받음
	void setArraySize(int size) {
		numList = new int[size];
	}

	// 2. 숫자 입력 받음
	void setNum(int num) {
		if (index < numList.length-1) {
			numList[++index] = num;
		} else {
			System.out.println("숫자를 더이상 입력할 수 없습니다");
		}
	}

	// 3. 더하기
	void plus() {
		if (isExecuted()) {
			sum = 0;
			for (int i = 0; i <= index; i++) { // 배열의 길이 전체가 아니라 값이 몇개 들어왔는지를 기준으로 더하기를 하기 때문에
				// numList.length가 아니라 index를 사용하는 것
				sum += numList[i];
			}
			System.out.println("모두 더한 결과 : " + sum);
		}
	}

	// 4. 빼기
	void minus() {
		if (isExecuted()) {
			minusNum = numList[0];
			for (int i = 1; i <= index; i++) {
				minusNum -= numList[i];
			}
			System.out.println("모두 뺀 결과 : " + minusNum);
		}
	}

	// 5. 곱하기
	void multi() {
		if (isExecuted()) {
			multiNum = numList[0];
			for (int i = 1; i <= index; i++) {
				multiNum *= numList[i];
			}
			System.out.println("곱한 결과 : " + multiNum);
		}
	}

	// 6. 나누기
	void divide() {
		if (isExecuted()) {
				divideNum = numList[0];
				for (int i = 1; i <= index; i++) {
					divideNum = divideNum / numList[i];
					if (numList[i] == 0) {
					System.out.println("0 이외의 숫자를 입력하세요");
					
					return;
				}
				System.out.println("나눈 결과 : " + divideNum);
			}
		}
		
	}
	
	// 8. 배열에 들어와 있는 요소 확인
	void arrayNum() {
	for (int i = 0; i < numList.length; i++) {
		System.out.println(numList[i]);
	}
	}
	
	
	// 0. 조건체크
	// 곱하기와 나누기는 입력받은 값이 0이면 안됨
	boolean isExecuted() {
		if ((index + 1) >= 2) { // 입력받은 값이 2개 이상인지만 체크했기 때문임
			return true; // 인덱스 설정이 -1이라서 
		} else {
			System.out.println("숫자를 더 입력해 주세요");
			return false;
		}
	}

}
