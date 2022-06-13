package com.yedam.java.ch1601_1;

public class MainTest {

	public static void main(String[] args) {
		MyFunctionalInterface fi = () -> {
			System.out.println("람다식 실행");
		}; 
		
		fi.method();
		
		// 정석 익명 구현객체
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			
			@Override
			public void method() {
				// 반드시 구현해야하는 것은 method하나 밖에 없다.
				System.out.println("익명 구현 객체 실행");
			}
		};
		
		mfi.method();
	}

}
