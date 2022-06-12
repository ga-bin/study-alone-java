package com.yedam.java.ch1601;

public class RamdaTest {

	public static void main(String[] args) {
		// 메소드 시그니처 따라서 람다로 표현하는 방법 다름
		// 매개변수, 리턴타입 없는 람다식
		MyFunInterfaceA fa = () -> {
			// 변수를 final로하거나 인터페이스를 static으로 해야한다.
			// 그래서 굳이 추상클래스가 아니라 인터페이스로 선언한다
			// 인터페이스는 원리 static final로 상수를 선언하니까
			// 람다식은 호출할때마다 새로운 스레드가 생기고, 그 스레드의 객체 참조값을
			// 복사해와서 변수에 저장하기 때문에
			// 변수의 값을 변경하는 경우에는 스레드의 원래 객체에 있던 변수의 값은
			// 변경되지 않기 때문이다.
			
			// 인터페이스를 계속 만들어야 함에도 람다식을 사용하는 이유는
			// 자바에서 제공해주는 인터페이스 자체가 람다식으로 구현하면 편하도록 만든 것이 있기
			// 때문이다
			// 예를들어서 compare같은 것.
			
			String str = "method call1";
			System.out.println(str);
			// 자동으로 인터페이스의 메소드와 매칭, 매칭된 메소드 호출해서 사용한다.
		};
		
		
		fa.method();
		
		fa = () -> { System.out.println("method call2"); };
		// 실행블록이 한줄밖에 없을 때는 이른식으로 표현도 가능하다
		fa.method();
		fa = () -> System.out.println("method call3");
		fa.method();
		
		
		// 매개변수가 있고 리턴타입이 없는 람다식
		MyFunInerfaceB fb = (int x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		
		fb.method(10);
		
		
		// ()안에 타입 무시하고 변수만 쓰고 바로 사용도 가능
		// 이미 인터페이스 안에 어떤 타입의 매개변수를 사용할 것인지 정의해 놨기 때문에 
		// x라고 넣으면 자동으로 int타입으로 들어오고 int타입에 맞춰서 연산하면 됨
		
		fb = (x) -> { System.out.println(x*5); };
		fb = x -> System.out.println(x*5); // 가능
		
		
		// 매개변수가 있고 리턴타입이 있는 람다식
		MyFunInterfaceC fc = (int x, int y) -> {
			int result = x + y;
			return result;
		};
	
		fc = (x, y) -> { return x + y; }; 
		fc  = (x, y) -> x + y; // 가능
		
		System.out.println(fc.method(10, 20));
		
		fc = (x, y) -> Math.max(x, y);
		System.out.println(fc.method(10, 12));
		
	
		int val1 = 10;
		int val2 = 20;
		// 익명 구현객체를 정의할 때 구현 객체 외부에 있는 변수를 사용할 수는 있는데
		// 이때 외부 변수는 final속성을 가진다.
		
		fa = () -> {
			int result = val1 + val2;
			System.out.println(result);
			// 이럴 경우 val1, val2의 메모리를 가지고 오는 것이 아니라
			// 값만 가지고 와서 계산한다.
			// 선언할 때 참조하는 변수에 대해서 항상 호출될 때 마다 같은 값이 유지되어야한다.
			// 메소드 내에서 외부의 값을 가지고 올 때는 항상 final특성일 수 밖에 없다.
		};
		
//		val1 = 100; // 실행오류 생긴다 불가능
		fa.method();
		
	}

}





















