package com.yedam.java.ch0901;

public class Outter {
	String field = "바깥클래스 - 필드";
	void method() {
		System.out.println("바깥클래스 - 메소드");

	}
	void methodA() {
		System.out.println("바깥클래스 - 메소드 A");
	}
	// 인스턴스 멤버 클래스
	class Nested {
		String field = "중첩클래스 - 필드";
		void method() {
			System.out.println("중첩클래스 - 메소드");
		}
		
		void print() {
			System.out.println(field);
			method();
			// 우선순위는 클래스 본인이 가지고 있는 필드, 메소드다, 같은 이름이 있는 경우 본인의 필드, 메소드가 호출됨
			methodA();
			// 바깥 클래스의 메소드를 자신이 가진것처럼 호출은 가능
			System.out.println(Outter.this.field);
			Outter.this.method(); 
			// 바깥클래스의 인스턴스에 접근하고 싶을때는 바깥 클래스명을 붙혀준다.
			// 인스턴스는 실행클래스에서 생성
			// 동명의 메소드, 필드가 외부에도 있는경우 반드시 바깥클래스명 붙혀주다
		}
	}
	// 인스턴스 인터페이스
	// 인스턴스 인터페이스는 인스턴스를 전제로 하고 있어야해서 정적 인터페이스를 더 많이 사용함
	interface I {
		int FIELD = 100;
		void method();
	}
	
	// 정적 인터페이스
	static interface N {
		int FIELD = 100;
		void method();
	}
}
