package com.yedam.java.ch0902;

public class RemoteControlTest {

	public static void main(String[] args) {
		Product product = new Product();
		
		// 필드 - 익명 구현 객체
		product.field.turnOn();
		product.field.turnOff();
		// 로컬변수 - 익명 구현 객체
		product.method1();
		// 매개변수 - 익명 구현 객체
		product.method2(new RemoteControl() {
			String message = "노트북";
			
			void print() {
				System.out.println("제품 종류 : " + message);
			}
			@Override
			public void turnOn() {
				print();
				System.out.println("노트북을 켭니다.");
				
			}

			@Override
			public void turnOff() {
				print();
				System.out.println("노트북을 끕니다.");
				
			}
			
			
		});
	}

}
