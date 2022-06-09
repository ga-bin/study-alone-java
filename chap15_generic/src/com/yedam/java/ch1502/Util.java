package com.yedam.java.ch1502;

public class Util {
	public static <T extends Number> int compare(T t1, T t2) {
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
	