package com.yedam.java.ch1601;

@FunctionalInterface
// 이 인터페이스가 람다식 문법으로도 사용할 수 있음
// 이 인터페이스 내부에 한개를 초과하는 메소드를 선언할 수 없게 한다.
// 하지만 그렇다고 해서 반드시 람다식으로만 사용해야하는 것은 아니다
// 기존의 방식으로 인퍼테이스를 구현하는 별도의 클래스를 만들거나, 새로운 객체를 생성하는 것도
// 가능하다.
public interface MyFunctionalInterface {
	public void method();
	// 인터페이스의 메소드 시그니처에 따라서 ()의 값이 달라진다.
	// public void method(int a)
	// 이런식이면 람다식에 (int a) -> { }
}
