package com.yedam.java.ch1102;

public class WrapTest {

	public static void main(String[] args) {
		Integer obj1 = new Integer(100); // 쓰지마라
		
		// wrapper class
		Integer obj2 = Integer.valueOf("100");
		Integer obj3 = 100; // 같은 타입의 상수는 자동박싱 가능

		// 언박싱
		int val2 = obj2.intValue(); 
		int val3 = obj3; // 자동언박싱
		int val4 = obj2 + 100; // 연산시 자동언박싱
		int result = obj2 + val3; 
		// int - Integer, double - Double 등 같은 성질의 기본 타입과 클래스만 가능하다.
		// arraylist는 무조건 class타입을 데이터타입으로 가진다.
		// but 자동으로 박싱과 언박싱이 가능하기 때문에 arraylist쓸 때 그냥 int로 사용한다.
		
		// 값을 비교
		Integer object1 = 300;
		Integer object2 = 300;
		
		System.out.println("== 결과 : " + (object1 == object2));
		// false - String은 하나의 인스턴스를 공유하는 형태지만, wrapper클래스의 경우 각각의 개별 인스턴스를 만들어낸다.
		String str = "300";
		String str1 = str; // 하나의 인스턴스 공유
		String str2 = "300";
		// string에서는 같은 문자열이 들어가는 경우 같은 인스턴스를 참조하도록 되어잇음
		// but
		String str3 = new String("300");
		// 이런식으로 새로운 객체를 만드는 경우 서로 다른 주소를 가지기 때문에 ==으로 비교하면 false가 나온다
		System.out.println(str = str3);
		System.out.println(str == str2);
		
		// == 객체끼리비교
		// 언박싱해서 값들을 비교하거나 equals사용하기
		System.out.println("언박싱한 후 == 결과 " + ((int)object1 == (int)object2));
		System.out.println("equals 사용 " + object1.equals(object2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
