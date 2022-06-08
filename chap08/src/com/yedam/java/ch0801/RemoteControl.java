package com.yedam.java.ch0801;

public interface RemoteControl {
	// 상수필드
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	// 인터페이스에서는 static final없어도 상수만 선언된다. 인터페이스에서는 상수에 값을 주지않으면 오류남
	
	// 추상메소드
	// 인터페이스 안에서는 abstract빼도 상관 없음, 추상메소드만 가능하기 떄문
	public abstract void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	// 자바가 기능추가되면서 인터페이스임에도 불구하고 일반메소드를 인터페이스에 추가할 수 있게됨
	// 인터페이스로 구현하는 구현클래스에서 그 기능이 필요하지 않을 수도 있기 때문
	// 구현클래스 건드리지 않고 인터페이스에 기능을 추가하고 싶어서 들어간 기능이다
	// 추상클래스는 abstract가 기본이기 때문에 default를 일반메소드에 적어줘야함
	// default는 접근제한자 아님
	// 일반 메소드
	public default void show() {
		System.out.println("추가한 메소드");
	}
	// 정적 메소드
}
