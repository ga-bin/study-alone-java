package com.yedam.java.ch0606.package2;

import com.yedam.java.ch0606.package1.A;

public class C {

	// project 범위에서 유효
	A a1 = new A(true);

	// default 생성자
	// A a2 = new A(1);

	// private 생성자
	// A a3 = new A("String");

	public C() {
		A a = new A();

		a.field1 = 1;

		// default
		// a.field2 = 1;

		// private
		// a.field3=1;

		a.method1();

		// default
		// a.method2();

		// private
		// a.method3();
	}
}
