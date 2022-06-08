package com.yedam.java.ch0605;

public class CarTest2 {

	public static void main(String[] args) {
		Car first = new Car("레이");
		Car second = new Car("모닝");
		System.out.println("정적 필드 : " + Car.count);
		System.out.println("first : " + first.count);
		System.out.println("second : " + second.count);
		// 정적 필드이기 때문에 어떤 인스턴스가 접근하던지 간에 같은 값을 줘야 한다.
	}

}
