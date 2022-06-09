package com.yedam.java.ch1501;

public class Util {
	public static <T> BoxA<T> boxing(T t) {
	// 제네릭 타입의 리턴, 보통 매개변수에 제네릭 타입을 쓴다.
		BoxA<T> box = new BoxA<>(); 
		// T제네릭타입(데이터 타입)으로 선언된 박스
		// 이 박스안에는 어떤 타입도 들어올 수 있다.
		box.setT(t); // 매개변수로 가지고온 T를 셋팅
		return box;
		
	}
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		// 제네릭타입이 무엇일지 몰라서 equals를 사용함
		// equals를 사용하기 위해서 기본타입은 안된다. 무조건 클래스타입이거나 인터페이스타입이어야한다.
		// 제네릭은 보통 클래스 타입으로 선언하고 논리적으로 동등한지를 물어보려면 equals를 사용한다
		// 사용자 정의 클래스를 만들 때 object가 가지고 있는 hashcode등에 대해서 정의를 해주는게 좋다.
		// 우리가 만든 클래스로 제네릭 타입을 대체할 수 있다.
		// 무조건 static 다음의 < >에서 정의한 제네릭타입만 사용할 수 있기 때문에 대문자 맞춰주자
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	public static <K, V> V printInfo(K key) {
		V v = null;
		return v;
	}
}
