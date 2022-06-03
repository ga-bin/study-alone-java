package com.yedam.java.ch0606;

class A {}

// 같은 패키기 내면 default는 필드로 선언, 메소드의 매개변수로 사용, 메소드안의 지역변수로 선언하든 상관 없다
class B {
 A a;
 
 B(A a) {
	 this.a = a;
 }
 
 void method() {
	 A a;
 }
}
