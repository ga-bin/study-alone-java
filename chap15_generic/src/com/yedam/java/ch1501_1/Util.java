package com.yedam.java.ch1501_1;

public class Util {
	public static <T> BoxA<T> boxing(T t) {
		BoxA<T> box = new BoxA<>();
		// boxA타입 객체 box 생성
		
		box.setT(t); // box에 매개변수 t 셋팅
		return box;  // box객체 리턴
		
	}
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
	boolean keyCompare = p1.getKey().equals(p2.getKey());
	boolean valueCompare = p1.getValue().equals(p2.getValue());
	return keyCompare && valueCompare;
		
	}
	
	public static <K, V> V printInfo(K key) {
		V v = null;
		return v;
	}
}
