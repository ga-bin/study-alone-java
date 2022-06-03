package com.yedam.ch0703;

public class DmbPhone extends Phone {

	public DmbPhone(String model, String color) {
		super(model, color);
		
	}
	
	@Override
	public void powerOn() {
		super.powerOn();
		System.out.println("부팅이 완료되었습니다.");
	}
	
	public void showDmb() {
		System.out.println("DMB를 실행합니다");
	}
	
	public void bell() {
		System.out.println("벨이 울립니다.");
		System.out.println("벨소리~~~");
	}
	// 추상클래스는 반드시 실체클래스에서 메소드 재정의해야함
	// 추상클래스 자체는 실체클래스에 강제성 없지만 추상 메소드 생성하면 강제성 생김

}
