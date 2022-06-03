package com.yedam.java.ch0901;

public class A {
	A() {
		System.out.println("A 인스턴스가 생성됨.");
	}
	// 인스턴스 멤버 클래스
	class B {
		// 필드
		int feild1;
//		static int feild2;
		// 인스턴스 멤버 내부에서는 정적으로 필드, 메소드 선언할 수 없다
		
		// 생성자
		// 인스턴스 멤버클래스도 자신의 인스턴스를 생성할 수 있음 
		B() {
			System.out.println("B 인스턴스가 생성됨.");
		}
		
		// 메소드
		void method1() {
			
		}
	
	}
	
	// 정적 멤버 클래스
	static class C {
		// 필드
		int field1;
		static int field2;
		
		
		// 생성자
		C() {
			System.out.println("C 인스턴스가 생성됨.");
		}
		
		// 메소드
		void method1() {}
		static void method2() {}
		// 참고로 정적 메소드 안에는 정적 메소드, 필드만 사용가능 
	}
	
	
	// 메소드
	void method() {
		// 로컬클래스
		// D클래스는 메소드 내에 정의되어있기 때문에 직접적으로 접근할 수 없다
		// 무조건 인스턴스 필드, 메소드만 / 정적 멤버 불가능
		class D {
			// 필드
			int field1;
			
			// 생성자
			D() {
				System.out.println("D인스턴스가 생성됨.");
			}
			
			// 메소드
			void method1() {
				
			}
		}
		// D는 메소드를 벗어나면 사용할 수없기 때문에 반드시 사용하는 코드가 바로 와야함
		D d = new D();
		d.field1 = 1;
		d.method1();
	}
}
