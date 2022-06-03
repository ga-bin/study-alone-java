package com.yedam.java.ch0602;

public class Car {
	// 필드
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	// 생성자
	// 클래스 이름이랑 동일, 리턴타입 없는 메소드
	// 자바입장에서는 매캐변수의 타입, 순서의 차이가 다른 생성자를 구분하는 기준
	// 필드보다 생성자를 통해서 값을 변경한 것이 우선순위가 높다 -> 필드로 초기화 하더라도 생성자를 통해서 재할당가능 -> 왠만하면 필드아니라 생성자에서 초기화함
	// this 이용해서 중복 제거 가능 -> this로 생성자 불러온다 -> 생성자 내에서 또 다른 생성자를 호출하는 것
	Car() {}; // 기본생성자 - 인스턴스를 만드는 역할만 한다. 필드는 건드리지 않음
			  // 클래스 내에 어떤 생성자도 없어야 자바가 디폴트로 기본 생성자를 만듦
	
	Car(String color) {
//		this.color = color;  // this는 클래스 내부에서만 사용, 클래스를 기반으로 생성된 인스턴스를 가르킴,  
							// 인스턴스의 필드값을 바꾸겠다는 말이지 기존의 클래스를 건들이겠다는 말이 아님
		this("그랜저", color, 350); // 생성자
		// 생성자 내부에서는 필드, 메서드 뿐만 아니라 또 다른 생성자도 호출할 수 있다
		// 이런 경우에는 호출되는 생성자는 반드시 블록 첫줄안에 있어야 한다(this를 호출한다는 것은 새로운 인스턴스를 만든다는 것,
		// 인스턴스 만들기 전에 필드 초기화하거나 메소드 사용 불가능)
	}
	
	Car(String model, String color) {
//		this.model = model;
//		this.color = color;
		this(model, color, 350);
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	// 메소드
	// 메소드로 생성자 호출 불가능 -> 메소드를 사용한다는 것은 이미 인스턴스가 있기 때문이다
	// 메소드 하나는 기본적으로 하나의 기능
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
