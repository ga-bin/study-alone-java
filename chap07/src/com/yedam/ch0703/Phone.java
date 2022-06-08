package com.yedam.ch0703;

public abstract class Phone { // 추상클래스 : 단독으로 자신의 인스턴스 생성 불가능
	// 필드
	public String model;
	public String color;
	
	
	// 생성자
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	// 실체클래스에서 super()로 초기화
	
	// 메소드
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void powerOff() {
		System.out.println("전원을 끕니다");
	}
	
	public abstract void bell(); // 추상메소드
	// 기능은 있는데 실제 구현의 형태가 어떤지 모를 경우에 추상클래스 사용
	
	
}
