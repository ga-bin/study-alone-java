package com.yedam.java.ch0605;

public class Singleton {
	// 데이터를 분산하지 않고 하나로 모으고 싶을 때 주로 싱글톤을 이용한다 
	// 객체를 여러개 생성하면 어떤 인스턴스를 기준으로 해야하는지 모르기 때문에 싱글톤 사용함
	// 필드
	// 필드에는 거의 제한이 없다 -> 자기자신도 필드로 가질 수 있음
	// 클래스 내부에서 인스터스를 만듬 -> 정적필드로 선언해 공유하도록
	// 정적필드로 만들면 외부에서 아무나 접근해 singleton = null;등으로 값을 변경할 수 있기 때문에 private로 숨긴다
	private static Singleton singleton = new Singleton();
	// 생성자
	// 싱글톤은 실행클래스에서 인스턴스를 만들지 않기 때문에 생성자를 막는다.
	private Singleton() {}
	// 메소드
	public static Singleton getInstance() {
		return singleton;
		// 하나 생성한 싱글톤 객체의 주소지를 전달 -> 외부에서 참조할 수 있도록
	}
}
