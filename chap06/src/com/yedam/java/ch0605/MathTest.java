package com.yedam.java.ch0605;

public class MathTest {
	// math의 정적필드와 정적메소드는 인스턴스 안가지고 와서 사용가능0
	public static void main(String[] args) {
		double result1 = 10 * 10 * Math.pi;
		int result2 = Math.plus(10, 5);
		int result3 = Math.minus(10, 5);
		
		System.out.println("result1 " + result1);
		System.out.println("result2 " + result2);
		System.out.println("result3 " + result3);
	}

}
