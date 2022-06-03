package com.yedam.ch0703;

public abstract class Animal {
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}
	
	public abstract void sound();
	// abstract 클래스가 아니면 추상 메소드를 만들 수 없다
	// 추상메소드의 실행블록에 아무것도 정의하지 않았기 떄문에 인스턴스 만들경우 실행 불가능하기 때문
	// 단 하나의 추상메소드만 있어도 추상클래스여야함
}
