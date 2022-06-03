package com.yedam.java.ch0605;

public class CarTest {
	// 메인메소드는 static이라서 정적메소드만 호출가능
	// but 우리는 인스턴스 필드와 메소드를 사용한다
	// 그 이유는 메인 메소드에서 new로 새로운 인스턴스를 생성하기 때문
	// 정적 메소드에서 인스턴스 멤버를 사용하지 못하는 이유는 단지 인스턴스를 생성하지 않기 때문이다
	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		System.out.println(yourCar.speed);
		yourCar.run();

	}

}
