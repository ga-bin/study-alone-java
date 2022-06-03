package com.yedam.java.ch0701;

public class MainTest {

	public static void main(String[] args) {
		DmbPhone dmbPhone = new DmbPhone("슬라이드폰", "파랑");
		
		System.out.println("모델 : " + dmbPhone.model);
		System.out.println("색상 : " + dmbPhone.color);
		System.out.println("채널 : " + dmbPhone.ch);
		// 실행 메소드에서는 클래스가 상속받았는지 알 수 없다
		// 싱속의 목적은 사용자입장에서는 마치 하나의 클래스인것처럼 
		
		dmbPhone.powerOn();
		dmbPhone.bell();
		dmbPhone.call();
		
		dmbPhone.turnOnDmb();
	}

}
