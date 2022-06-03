package com.yedam.java.ch0901;

public class Main {
	
	public static void main(String[] args) {
		A a = new A();
		A a1 = new A();
		
		A.B b = a.new B();
		A.B b1 = a1.new B();
		// 인스턴스 멤버 b의 인스턴스 만듬
		// A의 인스턴스인 a를 이용해서 내부에 접근 -> B클래스의 인스턴스를 만듬
		
		System.out.println();
		b.feild1 = 1;
		b.method1();
		
		// 상속의 경우 자식클래스가 인스턴스 생성될때 부모의 인스턴스까지 생성함
		// 중첩클래스의 경우 상위클래스의 인스턴스를 통해 접근해야하긴 하지만 자신의 인스턴스만
		// 생성한다는 차이점
		
		A.C c = new A.C();
		// 정적 멤버클래스는 클래스 이름인 A를 통해서 접근, A인스턴스 생성할 필요 x
		c.field1 = 1;
		A.C.field2 = 1;
		// 정적멤버클래스 안에 있는 정적필드, 메소드에는 인스턴스 생성없이 접근하는 것이 가능하다
		A.C.method2();
		c.method1();
		// 인스턴스멤버는 인스턴스 생성하고 접근해야함
		
		System.out.println();
		a.method();
		// a의 method사용하면 로컬클래스 D가 자동으로 생성된다. -> 생성자 호출됨

	}

}
