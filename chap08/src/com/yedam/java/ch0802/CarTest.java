package com.yedam.java.ch0802;

public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		myCar.frontLeftTire = new HankookTire();
		myCar.frontRightTire = new HankookTire();
		// 타입을 인터페이스로 정의하고 필요에 따라서 구현클래스를 교체하는 것
		
		myCar.run();

	}

}
