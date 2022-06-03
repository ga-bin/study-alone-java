package com.yedam.java.ch1102;

public class StringTest1 {

	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		// 생략할 경우 아스키코드를 이클립스에 설정한 utf-8로 자바에서 자동으로 디코딩한다.
	}

}
