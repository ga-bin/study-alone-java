package com.yedam.java.ch1501;

public class MethodTest {

	public static void main(String[] args) {
		// 제네릭 메소드를 사용하는 경우 
		BoxA<Integer> intBox = Util.<Integer>boxing(100);
		// 원래 이런식으로 해야한다.
		
		
		// t제네릭타입에 어떤 타입이 들어가야 하는지 직접 지정해 줘야 한다)
		Util.boxing(100); // 이런식으로 해도 문제가 없는 것은, 
		// util의 boxing메소드의 매개변수가 하나밖에 없고, 매개변수값이 100이라서 t가 integer라는 것을 자바가 유추하는 것 
		
		Pair<Integer, String> p1 = new Pair<>(1, "사과");
		Pair<Integer, String> p2 = new Pair<>(1, "사과");
		
		boolean result1 = Util.compare(p1, p2);
		// 매개변수로 넘어가는 p1과 p2의 <integer, string>을 통해서 자바가 유추하고 있어서 돌아간다
		// 경우에 따라서
		boolean result2 = Util.<Integer, String>compare(p1, p2);
		//로 적어주어야 한다.
		
		if (result1) { 
			System.out.println("논리적으로 동등한 객체입니다");
			// equals는 객체의 내용끼리 비교한다.
		} else {
			System.out.println("논리적으로 동등하지 않습니다.");
		}
		
		Util.<String, Integer>printInfo("홍길동");
		// 매개변수로 유추할 수 없는 경우 앞쪽에 제네릭 타입 써야한다.
	}

}
