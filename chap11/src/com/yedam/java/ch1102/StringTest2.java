package com.yedam.java.ch1102;

public class StringTest2 {

	public static void main(String[] args) {
		// toLowerCase & toUpperCase
		String str1 = "Java Programming";
		String str2 = "JAVA PROGRAMMING";
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		
		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		if(val1.equals(val2)) {
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		
		if(str1.equalsIgnoreCase(str2)) { // 대소문자무시
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		
		// trim : 앞, 뒤 공백제거, 중간 공백제거는 불가능핟
		String subject = "      자바    프로그래밍       ";
		String newData = subject.trim();
		System.out.println(newData);
		
		String value1 = newData.substring(0, 2);
		String value2 = newData.substring(newData.indexOf("프로그래밍"));
		System.out.println(value1 + " " + value2);
		
		String value3 = newData.replace("자바    프로그래밍", "자바 프로그래밍");
		System.out.println(value3);
		
		// valueOf -> 기본타입의 값을 문자열로 바꿀 수 있다.
		String value4 = String.valueOf(10);
		String value5 = String.valueOf(10.5);
		String value6 = String.valueOf(true);
		
		String value7 = "" + 100; // 이런식으로도 문자열을 만들 수 있다.
	}

	

}
