package com.yedam.java.ch0701;

public class DmbPhone extends Phone {
	// 필드
	int ch; //채널
	
	
	// 메소드
	void turnOnDmb() {
		System.out.println("채널" + ch + "번 방송 수신을 시작합니다");
	}
	
	// 생성자
	public DmbPhone(String model, String color) {
		super(model, color);
		// 자식클래스의 생성자 안에 부모 클래스의 생성자를 받아옴
		// 인스턴스 생성될때 부모 인스턴스먼저 그 다음에는 자식 인스턴스 생성
		// new가 아니라 super가 아닌 이유는 자식클래스와 부모클래스가 연결되어 있기 때문에
		// 새로운 생성자를 가져오는 것이 아니다
		// 그래서 생성자 오버로딩에서 코드 줄일때처럼 this()랑 같은 의미인데 대신 부모클래스여서 super로지정
		// super생성자는 자동으로 자바가 만들어줌
		// 부모클래스에 기본생성자 없을 경우(직접 명시적으로 인자받은 생성자 만들어준 경우 super()라고 부모
		// 클래스의 생성자 자바가 임의로 만들지 않는다.
		// 결과적으로 super()난다
		
//		this.model = model;
//		this.color = color;
		// 실제로 dmb에는 ch밖에 없는데 model,이랑 color를 부모인 Phone으로부터 상속받음
		// 모든 클래스는 기본적으로 object를 상속받는다
		// dmbphone의 부모인 phone이 object를 상속받기 때문에 dmbphone도 object와 phone의 메소드 모두 사용가능
//		super.model = model;
//		super.color = color;
		// 가능하다
		
		this.ch = 10;
		// this는 생성된 인스턴스를 의미함
		// this로 부모에 접근할 수 있는 이유는, dmb를 상속받으면서 부모인스턴스와 자식 인스턴스를 같이 만들고 연결되어
		// 있기 때문에 마치 하나인 것 처럼 사용가능
	}
	
	
	
	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}
	
	void changeChannel(int ch) {
		this.ch = ch;
		System.out.println("채널" + ch + "번으로 바꿉니다.");
	}

	@Override
	protected void bell() {
		// TODO Auto-generated method stub
		super.bell();
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		super.call();
	}
	// 상속을해서 오버라이딩하는 경우 부모의 접근제한자를 상속받는다
	// 상속이 일어날 수 있는 메소드에 대해서는 protected이상으로 사용해야한다
	// default금지
	
	
}
