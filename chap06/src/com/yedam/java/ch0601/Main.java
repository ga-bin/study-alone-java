package com.yedam.java.ch0601;

public class Main {

	public static void main(String[] args) {
		// new 연산자를 쓰면 새로운 인스턴스를 생성함
		// 동일한 인스턴스를 참조하고 싶으면 복사해야함(얉은복사)
		Car myCar = new Car();
		System.out.println(myCar);
		Car yourCar = new Car();
		System.out.println(yourCar);
		
		
	}

}
