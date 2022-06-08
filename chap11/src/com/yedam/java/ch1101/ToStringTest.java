package com.yedam.java.ch1101;

import java.util.Date; // import할때 util쓸지 sql쓸지 생각하자
// sql은 db용

public class ToStringTest {

	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1.toString());
		
		Date date = new Date();
		System.out.println(date.toString());
		
		Member member = new Member("홍길동");
		System.out.println(member);
		// toString overrideing한 것 안써도 id : 홍길동 으로 뜨는 이유
		// sysout을 사용하는 경우 자동으로 해당클래스가 가지고 있는 toString호출하기 때문
		System.out.println(member.toString());
		// 상관 x
		// showinfo를 만들기보다 개발자들은 tostring을 보통 override해서 만든다.
	}
	
}
