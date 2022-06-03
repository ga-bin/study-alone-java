package com.yedam.java.ch0901;

public class Z {
	// 외부에서 인스턴스멤버클래스, 정적멤버클래스 사용할 때의 제약
	
	// 정적 멤버 -> Z클래스의 인스턴스가 없을 수 있다.
	B field1 = new B(); // 인스턴스클래스인 B클래스는 반드시 z클래스의 인스턴스가 존재
	C field2 = new C();	// z클래스의 정보만 있으면 됨, 인스턴스가 있을수도 있고 없을수도 있음
	// 정적멤버클래스는 인스턴스, 클래스명 둘다 접근 가능

	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	
	static B field3 = new B();
	// static이라는 말은 z클래스의 인스턴스가 필요없다는 말
	// but B클래스는 인스턴스멤버클래스여서 z클래스의 인스턴스 필요함
	// B클래스는 static으로 사용할 수 없다.

	static C field4 = new C();

	static void method2() {
		B var1 = new B();
		C var2 = new C();
	}
	// 인스턴스 멤버 클래스
	class B {

	}
	
	// 정적 멤버 클래스
	static class C {
		
	}
}
