package com.yedam.java.ch0605;

public class SingletonTest {

	public static void main(String[] args) {
//		Singleton obj1 = new Singleton();
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		// 처음에 singleton클래스에서 singleton필드를 선언하고 객체를 생성할 때
		// 데이터타입이 Singleton이었기 때문에 Singleton obj1이런식으로 적는다
		if (obj1 == obj2) {
			System.out.println("같은 singleton 객체입니다");
		} else {
			System.out.println("다른 singleton 객체입니다");
		}
	}

}
