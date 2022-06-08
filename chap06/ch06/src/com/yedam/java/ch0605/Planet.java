package com.yedam.java.ch0605;

public class Planet {
	// 필드
	final int radius;
	static final double pi = 3.14159;

	// 생성자
	Planet(int radius) {
		this.radius = radius;
	}

	// 메소드
	void getArea() {
		double result = 4 * Planet.pi * this.radius * this.radius;
		System.out.println("행성의 표면적 : " + result);
	}

}
