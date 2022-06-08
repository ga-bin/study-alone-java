package com.yedam.java.ch0606.package1;

public class B {
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	// private는 다른 클래스에서 사용 불가능(외부에서 보이지 않는다)
	
	
	// 생성자
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		a.field3 = 1;
		
		a.method1();
		a.method2();
		a.method3();
		// private는 다른 클래스에서 사용 불가능(외부에서 보이지 않는다)
	}
}
