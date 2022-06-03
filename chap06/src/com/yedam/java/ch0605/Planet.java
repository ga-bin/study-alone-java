package com.yedam.java.ch0605;

public class Planet {
	// 필드
	final int radius;
	static final double pi = 3.14159;
	// static final은 상수, 클래스에서 초기화
	// 인스턴스 변수의 경우 final이라도 각 인스턴스마다 값이 다를 수 있으므로 상수라고 할 수 없다
	
	// 생성자
	Planet(int radius) {
		this.radius = radius;
		// 인스턴스 생성기 radius값 초기화
	}
	
	// 메소드
	void getArea() {
		double result = 4 * Planet.pi * this.radius * this.radius;
		System.out.println("행성의 표면적 : " + result);
	}
}
