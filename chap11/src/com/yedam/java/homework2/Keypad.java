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
	
	// 추상 메서드 정의
	// 왼쪽 위 버튼 눌렀을 때 동작하는 기능
	public abstract void leftUpButton();
  	
	public abstract void leftDownButton();
	
	public abstract void rightUpButton();
	
	public abstract void rightDownButton();
	
	// 모드를 바꾸고 현재 모두를 출력하는기능
	// nomal mode -> hard mode / hardmode -> normal mode
	public abstract void changeMode(); 
	
}

