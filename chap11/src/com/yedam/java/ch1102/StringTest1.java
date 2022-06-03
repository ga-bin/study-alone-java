package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;

public class StringTest1 {

	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		// 생략할 경우 아스키코드를 이클립스에 설정한 utf-8로 자바에서 자동으로 디코딩한다.

		// String -> byte -> String
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes(); // string -> byte
		System.out.println(bytes1);
		String strs1 = new String(bytes1); // 생성자를 통해 byte -> string
		System.out.println(strs1);

		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println(bytes2);
			String strs2 = new String(bytes2, "EUC-KR");
			System.out.println(strs2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // getBytes할때 무엇을 기준으로 바꿀지 설정할 수 있다.

		// charAt
		// 단어나 문장으로 된 글자 중에서 하나만 가지고 오는 경우
		String ssn = "010624-1230123";

		char gender = ssn.charAt(7);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}
		for(int i = 0; i < ssn.length(); i++) {
			System.out.println(ssn.charAt(i)); // chatAt을 사용하면 char타입의 배열처럼 사용할 수 있다.
		}
		
		System.out.println();
		
		// equals
		// string은 문자열 비교시 등호연산자말고 equals!
		String val1 = "신민철"; // "신민철"이라는 값을 가진 인스턴스가 없으므로 새로운 인스턴스 생성
		String val2 = "신민철"; // 새로운 인스턴스 생성 x, "신민철"이라는 값을 가진 인스턴스가 있으므로 자바가 같은 인스턴스를 공유한다.
		// 인스턴스가 데이터가 변경되면 서로 영향을 받기 때문에 고려해야한다. 
		String val3 = new String("신민철"); // 새로운 인스턴스가 반드시 필요하다면 new연산자 사용하기
		
		if(val1.equals(val2)) {
			System.out.println("val1과 val2는 값이 같습니다.");
		} else {
			System.out.println("val1과 val2는 값이 다릅니다.");
		}
		
		if(val1.equals(val3)) {
			System.out.println("val1과 val3는 값이 같습니다.");
		} else {
			System.out.println("val1과 val3는 값이 다릅니다.");
		}
		
		if(val1 == val2) {
			System.out.println("val1과 val2는 같은 객체를 참조합니다.");
		} else {
			System.out.println("val1과 val2는 다른 객체를 참조합니다.");
		}
		if(val1 == val3) {
			System.out.println("val1과 val3는 같은 객체를 참조합니다.");
		} else {
			System.out.println("val1과 val3는 다른 객체를 참조합니다.");
		}
		
		// string은 equals 오버라이딩 불가능하다 -> new연산자를 사용하면 무조건 새로운 객체를 만든다.
		// indexOf
		String subject = "자바 프로그래밍 & 스프링 정석";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련없는 책");
		}
		
		// substring과 indexOf를 같이 사용하는 경우가 있다.
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);
		
		String ssn1 = "880815-123456";
		System.out.println("생년월일 : " + ssn1.substring(0, 6)); // 첫번째 매개변수는 인덱스, 두번째 매개변수는 길이
		// charAt은 한글자 substring은 여러글자
		System.out.println("개별정보 : " + ssn1.substring(7));
		
		// length
		String[] temp = {"1", "2"};
		
		System.out.println(temp.length);
		
		System.out.println(ssn1.length());
		
		//replace
		String oldStr = "Java 프로그래밍";
		String newStr = oldStr.replace("Java", "자바");
		System.out.println(oldStr + "->" + newStr);
		// 원본수정 X, 새로운 인스턴스를 만든다.
		// 원본을 또 사용할수있다는 장점 있지만 더미데이터 쌓인다는 단점
		// 한문장에 있는 모든 단어를 바꾸고자 할때는 replace를 사용해야하고, indexof는 첫번째 위치의 단어만 찾는다.
	}

}
