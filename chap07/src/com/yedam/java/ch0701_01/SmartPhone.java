package com.yedam.java.ch0701_01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {
	// public접근자면 상속은 가능
	// but 메소드나 필드가 default면 다른 패키지에서 사용 불가능
	SmartPhone(String model, String color) {
		super(model, color);
	}
	// phone에 디폴트 생성자가 없으니까 무조건 string 2개들어간 smartphone생성자 있어야함

	@Override
	void powerOff() {
		System.out.println("휴대폰이 종료됩니다");
		super.powerOff();
		// 오버라이딩은 할 수 없지만 부모 메소드를 super.powerOff()로 호출하는 것은 상관 없음
//		super.print();
		// private는 오버라이딩은 물론 아예 보이지도 쓰지도 못함
	}
	
	@Override
	protected void bell() {
		super.bell();
		System.out.println("벨 소리 : 싸이 - that that");
		// 상속한 bell 메소드가 protected이기 때문에
		// 오버라이딩하려면 
		// protected이상이어야한다 즉 protected거나 public
	}

	@Override
	void call() {
		super.call();
		System.out.println("안내 문구 : 전화는 용건만 간단히");
	}
	
	
	
}
