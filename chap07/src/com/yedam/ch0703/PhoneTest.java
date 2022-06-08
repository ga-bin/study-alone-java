package com.yedam.ch0703;

public class PhoneTest {

	public static void main(String[] args) {
//		Phone phone = new Phone("z플립", "블랙");
//		// 추상클래스 : 단독으로 자신의 인스턴스 생성 불가능
//		phone.powerOn();
//		
		
		DmbPhone dmbPhone = new DmbPhone("Z플립", "블랙");
		dmbPhone.powerOn();
		// 추상클래스는 단순히 사용을 위해서도 실체클래스가 있어야한다
		dmbPhone.showDmb();

	}

}
