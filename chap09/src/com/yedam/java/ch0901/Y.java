package com.yedam.java.ch0901;

public class Y {
	// 중첩클래스 내부에서 외부의 필드, 메소드 쓸 때 제약
	// 필드
	int field1;
	static int field2;
	
	
	// 메소드
	void method1() {
	}
	
	static void method2() {
		
	}
	
	// 인스턴스 멤버 클래스 -> Y클래스의 인스턴스가 반드시 존재
	// 			      -> 인스턴스가 접근할 수 있는 모든 내부 멤버를 호출할 수 있다.
	// 인스턴스 멤버 클래스 안에서 외부의 정적멤버, 인스턴스 멤버 사용하는 것 제약 없다
	class B{
		void method() {
			field1 = 1;
			field2 = 2;
			
			method1();
			method2();
		}
 }
	
	// 정적 멤버 클래스 -> Y클래스의 인스턴스가 없다(만들수는 있음)
	//             -> Y클래스의 정적 내부 멤버들만 호출할 수 있음
	// 정적 멤버 클래스 안에서 외부의 인스턴스 멤버 사용하는데 제약
	// 외부의 정적멤버들은 인스턴스 필요없지만 인스턴스 멤버들은 인스턴스 필요하기 때문
	// class C는 class Y의 인스턴스가 생성될 것이라고 확신하지 못한다
	static class C{
		void method() {
			field1 = 1;
			field2 = 2;
			
			method1();
			method2();
		}
	}
	int method(final int arg) {
		final int var = 1;
//		arg = 100;
//		var = 90;
		class D {
			void method() {
				int result = arg + var;
			}
		}
		// 경우에따라 로컬클래스의 인스턴스가 메소드의 종료와 상관없이 존재하는 경우가 있다
		// 메소드가 사라졌을 경우에 d인스턴스를 이용해 로컬변수나 매개변수를 호출하는 경우
		// 값을 받아올 수가 없음 -> 이럴 경우를 대비해서 메소드 안의 변수나 매개변수를 복사해오고, 값을변경할 수 없도록 final로 만듬
		// final int, final arg로 원래 선언해야하는데 java에서 자동으로 final로 만들어줌
		// 로컬클래스 내부에서는 내가 원하는 대로 연산을 할 수 없기 때문에 주의해야한다
		D d = new D();
		d.method();
		var = 2;
		// 끝에 값을 저장해버리면 return을 몇번할지 확신할 수 없고, 초반에 메소드 호출했을때와
		// 끝에 호출했을 때 값이 다를 수 있어서 java는 초반에 값을 복사함
		return var;
	}
}

