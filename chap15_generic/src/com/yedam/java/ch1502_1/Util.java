package com.yedam.java.ch1502_1;

public class Util {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
		
		// 제네릭 와일드 카드
	}
}
