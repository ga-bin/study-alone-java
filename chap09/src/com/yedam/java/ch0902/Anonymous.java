package com.yedam.java.ch0902;
// 익명자식객체를 사용하는 이유 -> 자식객체 내에서 필드와 메소드를 통해 다양한 결과를 만들어 낼 수 있기 때문
public class Anonymous {
	// 필드
	// 익명객체1
	Person field = new Person() {
		// 필드
		String job = "회사원";
		
		// 메소드
		void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	};
	
	void method1() {
		// 로컬변수
		// 익명객체2
		Person var = new Person() {
			// 필드
			String job = "취준생";
			// 메소드
			void walk() {
				System.out.println("산책합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
			
		};
		
		var.wake();
	}
	// 생성자
	
	
	// 메소드
	void method2(Person person) {
		person.wake();
	}
}
