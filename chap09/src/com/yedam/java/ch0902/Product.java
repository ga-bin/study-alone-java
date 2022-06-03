package com.yedam.java.ch0902;

// 익명구현객체
public class Product {
	// 필드
	RemoteControl field = new RemoteControl() {
		// 필드
		String message = "스마트TV";

		// 메소드
		void print() {
			System.out.println("제품 종류 : " + message);
		}

		@Override
		public void turnOn() {
			print();
			System.out.println("전원을 켭니다.");
		}

		@Override
		public void turnOff() {
			print();
			System.out.println("전원을 끕니다.");
		}

	};
	// 생성자

	// 메소드
	RemoteControl method1() {
		// 필드
		int volume;
		RemoteControl var = new RemoteControl() {
			String message = "Audio";

			void print() {
				System.out.println("제품 종류 : " + message);
			}

			@Override
			public void turnOn() {
				// 부모 인터페이스인 remotecontrol이 public이어서 public만됨
				print();
				System.out.println("전원을 켭니다.");
				System.out.println("현재 볼륨 : " + volume);
			}

			@Override
			public void turnOff() {
				print();
				System.out.println("전원을 끕니다.");

			}
			

		};

		var.turnOn();
		var.turnOff();
		return var;
		// 경우에 따라서 메서드 종료 후에 값 return받는 경우 있음
		// 그래서 변수가 메서드 내에서 선언될때 final성격을 지니게 된다.
		// 중첩클래스와 동일 
	}

	void method2(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
