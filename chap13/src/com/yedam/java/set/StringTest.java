package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class StringTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		System.out.println("총 객체 수 " + set.size());
		// 참고로 String에 대해서 자바를 중복저장하는 방법도 있다.
//		set.add(new String("Java")); ??
		// 이렇게 생성한다고 하더라도 같은 java라는 값이 들어오기 때문에
		// set에서 자동으로 같은 객체가 들어왔다고 판단한다
		// class test확인하기
		
		System.out.println("총 객체 수 " + set.size());
		System.out.println();
		//set컬렉션은 인덱스가 정해져 있지 않아서 내가 가지고 온 값이 이미 가지고 온 값인지 확인할 수가 없다.
		//  그래서 나온게 반복자, 반복자는 set컬렉션 내의 모든 객체에 대해서 한번씩은 접근할 수 있는 정보를 가지는 객체
		//  - 반복자도 객체이기 때문에 메소드로 제어한다. 
		

		Iterator<String> iterator = set.iterator();
		// set 클래스 안에 iterator()메소드 있고 그것은 iterator객체를 가지고 오는 메소드
		while(iterator.hasNext()) {
			// hasNext메소드는 가지고 올 객체가 있으면 true, 없으면 false
			String element = iterator.next();
			// 컬렉션에서 하나의 객체를 가지고 옴
			System.out.println("\t" + element);
			// 이스케이프문자 \t = 들여쓰기
		}
		System.out.println();
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		// 꼭 iterator를 사용할 필요도 없다. 바로 출력만 하는 것은 iterator없이도 가능
		// 향상된 for문 컬렉션에서 자주 사용하자
		for (String data : set) {
			System.out.println("\t" + data);
		}
		
		System.out.println();
		set.clear();
		// 내부의 모든 데이터를 지울 때는 clear
		if(set.isEmpty()) { 
			// isEmpty메소드는 컬렉션 내부가 비었는지 확인하는 메소드
			// 최상위인 컬렉션 클래스에 선언되어있어서 컬렉션 프레임워크에서 전부 사용 가능
			System.out.println("");
		}
	}

}
