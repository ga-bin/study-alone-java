package com.yedam.java.ch0605;

public class Car {
	// 필드
	public String model;
	public int speed;
	// 정적 필드 - 생산 수량
	public static int count;
	
	
	// 생성자
	// 생성자 만들었기 때문에 자바는 기본 생성자 만들지 않음
	public Car(String model) {
		this.model = model;
		// car라는 생성자를 호출한다는 것은 이미 인스턴스를 만들겠다고 자바한테 예고한것 => 자바는 this를 생성할 객체로 인식한다
		Car.count++; // static이 쓰인 필드도 this가능한데 쓰지말자 매개변수 이름과 정적필드 이름 동일하면
			     // 클래스명.정적필드명으로 쓰자
	}
	
	// 메소드
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void run() {
		for(int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속:" + this.speed + "km/h)");
		}
	}
}
