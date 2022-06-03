package com.yedam.java.ch0606.package2;

import com.yedam.java.ch0606.package1.A;

public class C {
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	// default와 private는 다른 패키지에서 사용 불가능하다(보이지 않는다)


//생성자
	public C() {
		A c = new A(); // 필드랑 메소드 A클래스에 있음 A로 인스턴스 생성하자
		c.field1 = 1;
		c.field2 = 1;
		c.field3 = 1;
		
		c.method1();
		c.method2();
		c.method3();
		// default와 private는 다른 패키지에서 사용 불가능하다(보이지 않는다)
	}
}