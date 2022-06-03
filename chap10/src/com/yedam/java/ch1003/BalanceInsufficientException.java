package com.yedam.java.ch1003;

public class BalanceInsufficientException extends Exception {
	// 예외클래스가 final아니기 때문에 상속가능
	// final클래스는 상속불가능, 메소드 재정의 불가능
	
	// 예외클래스는 예외가 발생할때 처리해라라는 것만 있을 뿐 독특한 기능이나 정보를 가지는 것이 아니기때문에 생성자 2개만 만듬
	public BalanceInsufficientException() {
		
	}
	
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
