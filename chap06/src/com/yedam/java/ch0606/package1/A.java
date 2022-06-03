package com.yedam.java.ch0606.package1;

public class A {
	// 필드
	// 각각의 생성자에 대한 인스턴스 생성
	// 클래스 내에서 public default private 호출 상관 없다
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	
	// 생성자
	public A(boolean b) {}
	A(int b) {}
	private A(String s) {}
	
	
	// 필드
	public int field1;
	int field2;
	private int field3;
	
	
	// 생성자
	// 필드도 public default private 같은 클래스 내에서 사용가능
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	}
	
	// 메소드
	public void method1() {}
	void method2() {}
	private void method3(){}
	
	
	
}
