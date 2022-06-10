package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String data1 = "Java";
		String data2 = new String("Java");
		
		if (data1 == data2) {
			// ==는 물리적인 주소를 비교한다
			// 내부적으로 값이 같더라도 new연산자 사용하면 다른 객체로 인식한다.
			// (주소가 다름)
			System.out.println("서로 같은 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
		
		Set<String> set = new HashSet<>();
		set.add(data1);
		set.add(data2);
		
		System.out.println("총 객체 수 " + set.size());
		// set 컬렉션의 경우 string class와 wrapper클래스 모두 동일한 값을 집어넣었을 때
		// 같은 객체로 인식하도록 오버라이딩되어있다.
		// 값을 기준으로 객체를 가져오는 메소드를 호출했을 때 같은 값이 여러개이면
		// 어떤 값을 가지고 와야하는지 모르기 때문.
	}

}
