package com.yedam.java.ch1601;

public class MainTest {

	public static void main(String[] args) {
		MyFunctionalInterface fi = () -> {
			System.out.println("람다식 실행");
		};
		
		fi.method();

		// fi는 하나의 method를 가진 인스턴스를 가지고 있다.
		// 
		
		// 정석 익명구현객체
		// 애초에 익명구현객체도 구현메소드를 만들 필요없이 한번만 사용하는 경우에 만들어서
		// 사용한다.
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			
			@Override
			public void method() {
				// 반드시 구현해야하는 것은 method하나밖에 없다.
				System.out.println("익명 구현 객체 실행");
				
			}
		};
		
		mfi.method();
	}
}

