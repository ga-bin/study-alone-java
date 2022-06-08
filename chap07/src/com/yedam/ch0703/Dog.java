package com.yedam.ch0703;
public class Dog extends Animal {

	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	// 추상메소드를 재정의하지 않으면 실체클래스에서 오류남
	// 실체클래스를 다시 추상클래스로 만들기 or 메소드 재정의

}
