package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class MemberTest {

	public static void main(String[] args) {
		// 해쉬코드와 equals를 정의하지 않은 상태로 set을 사용하는 경우
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		
		System.out.println("총 객체 수 : " + set.size());
		// 동일한 값을 넣어도 2개 나온다.
		// 그래서 equals와 해쉬코드를 overriding해야한다.
	}

}
