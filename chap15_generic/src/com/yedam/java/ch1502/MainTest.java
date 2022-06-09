package com.yedam.java.ch1502;

public class MainTest {

	public static void main(String[] args) {
//		int result1 = Util.<String>compare("홍", "김");
		// number를 compare이 상속받아서 제네릭 타입으로 사용하기로 했으므로 아예 사용 불가능하다.
		
		int result2 = Util.compare(1, 10);
		
		int result3 = Util.compare(0.5, 5.9);
		
		System.out.println(result2);
		System.out.println(result3);
		
	}

}
