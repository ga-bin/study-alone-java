package com.yedam.java.ch0606;

public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setSpeed(-50);
		
		
		myCar.setSpeed(50);
		System.out.println("현재 속도 : " + myCar.getSpeed());
		
		// stop은 boolean이고 false로 초기화된다
		// if문은 true일 떄만 조건문을 돌리기 떄문에 강제로 실행시키기 위해서 !를 붙임
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		
		System.out.println("현재 속도 : " + myCar.getSpeed());
		
		
		myCar.setStop(false);
		System.out.println(myCar.getSpeed());
		System.out.println(myCar.isStop());
	}

}
