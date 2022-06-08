package com.yedam.java.homework2;

public interface Keypad {
	// final 필드의 경우 수정 불가능
	// 상수 선언
	public static final int NORMAL_MODE = 0;
	public static final int HARD_MODE = 1;
	
	// final int closeTime = 21;
	//  final int openTime;
	// closeTime의 경우에는 상수가 될 수 있지만, openTime의 경우에는 객체마다 다를 수 있으므로
	// 상수를 선언하려면 final static으로 선언해야한다.
	
	// 인터페이스는 객체가 될 수 없기 때문에, 런타임에 필드 데이터를 저장할 수 없습니다. 
	// 그래서 인스턴스 필드/ 정적 필드는 선언이 불가능합니다. 
	// 상수 필드는 Compile Time에 선언되고 Run Time에 변경되지 않으므로 인터페이스에 선언이 가능합니다.
	// 참고로 인터페이스에서는 따로 public static final 선언안해도 상수로 선언된다.(어차피 인터페이스는 설계도 of 설계도라서 구현목적으로 만든다)
	// 그래서 인터페이스는 객체 생성도 불가능하다. 모두 추상메소드기 때문에 실행할 수 있는 실행코드가 없기 때문
	// 마찬가지로 추상클래스도 추상메소드가 실행코드가 없기 때문에 인스턴스 생성이 금지된다.
	
	// 추상 메서드 정의
	// 왼쪽 위 버튼 눌렀을 때 동작하는 기능
	public abstract void leftUpButton();
  	
	public abstract void leftDownButton();
	
	public abstract void rightUpButton();
	
	public abstract void rightDownButton();
	
	// 모드를 바꾸고 현재 모두를 출력하는기능
	// nomal mode -> hard mode / hardmode -> normal mode
	public abstract void changeMode(); 
	
	// 인터페이스에 생성된 메소드는 모두 추상메소드니까 마찬가지로 public abstract생략해도 된다.
	// 대신 구현클래스에서의 오버라이딩하는 메소드들은 모두 public을 붙혀주어야한다.
	// 인터페이스의 모든 메소드는 public 접근 제한을 갖기 때문에 구현클래스들은 public 보다 더 낮은 접근 제한으로 작성할 수 없다. 
}

