package com.yedam.java.ch1502;

public class Util {
	public static <T extends Number> int compare(T t1, T t2) {
		// <T extends Number>이런식으로 쓸경우 이 메소드 안의 제네릭은
		// 숫자타입의 어떤 데이터라도 위치할 수 있다.
		// 숫자타입외의 다른 타입의 데이터는 넣을 수 없다.
		// 제네릭 타입이라고 해도 넣을 수 있는 데이터를 한정하고 싶을 때 사용한다.
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
		
		// 제네릭 와일드카드
		// 와일드카드란, 제네릭 클래스의 객체를 메소드의 매개변수로 받을 때, 그 객체의 타입 변수를 제한하는 것을 말한다
		
		// <? extends T>
		// <? super T> // t가 자식 클래스로 제일 하위인 경우
		// <?> 제한 없음
		// ex) (Course<? super Worker> course)식으로 static뒤에 선언한다.
	}
}
	