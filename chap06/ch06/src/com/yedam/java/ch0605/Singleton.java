package com.yedam.java.ch0605;

public class Singleton {

	// 필드
	// static을 붙여야 new연산자 없이 외부에서 사용 가능, static이 없으면 인스턴스 필드라서 객체생성없이 사용못함.
	// private으로 직접 접근 못하게 막음.
	private static Singleton singleton = new Singleton();

	// 생성자
	private Singleton() {

	}

	// 메소드
	static Singleton getInstance() {
		return singleton;
	}

}
