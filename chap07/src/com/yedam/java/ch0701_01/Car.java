package com.yedam.java.ch0701_01;

public class Car {
	// 필드
	Tire frontLeftTire = new Tire("앞왼쪽", 6); // 1
	Tire frontRightTire = new Tire("앞오른쪽", 2); // 2
	Tire backLeftTire = new Tire("뒤왼쪽", 3); // 3
	Tire backRightTire = new Tire("뒤오른쪽", 4); // 4
	
	// 생성자
	
	
	// 메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		// 자동차 바퀴는 한번에 달려야 하기 때문에 else if아니라 if
		if(frontLeftTire.roll() == false) {
			stop();
			return 1; // 펑크난 위치 리턴
		}
		if(frontRightTire.roll() == false) {
			stop();
			return 2;
		}
		if(backLeftTire.roll() == false) {
			stop();
			return 3; // 펑크난 위치 리턴
		}
		if(backRightTire.roll() == false) {
			stop();
			return 4;
		}
		return 0; // 어디에서도 펑크안남
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다");
	}
}
