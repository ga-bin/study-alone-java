package com.yedam.java.ch0701;

public class Computer extends Calculator {
	// 메소드
	
	// 사용자입장에서는 메소드 재정의한것인지 아닌지 알 수 없으니까 붙혀준다
	// @은 간단히말하면 이라는 의미
	@Override
	double areaCircle(double r) {
		System.out.println("computer 객체");
		return Math.PI * r * r;
	}
	// 주석처리하면 부모 클래스의 메서드 들고온다
	// 메소드 재정의(오버라이딩)시 부모클래스의 메소드와 자식클래스의 메소드가 같이있다
	// 우선순위는 자식클래스가 높다
	
	void print() {
		super.areaCircle(5);
		areaCircle(5);
	}
}
