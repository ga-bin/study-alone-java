package com.yedam.java.ch0606.package1;

public class B {

	A a1 = new A(true);
	A a2 = new A(1);
	// private 생성자
	// A a3 = new A("String");

	public B() {
		A a = new A();

		a.field1 = 1;
		a.field2 = 1;

		// private
		// a.field3=1;

		a.method1();
		a.method2();

		// private
		// a.method3();
	}

}
