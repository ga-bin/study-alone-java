package com.yedam.java.ch1003;

public class Account {
	private long balance;
	
	public long getBalance() { // 잔액조회
		return balance;
	}
	
	public void deposit(int money) { // 입금
		balance += money;
	}
	
	public long withDraw(int money) throws BalanceInsufficientException { // 출금
		if (balance < money) {
			throw new BalanceInsufficientException("잔고 부족 : " + (money - balance) + "모자랍니다.");
			// 내가 받아서 처리할 필요가 없으면 BalanceInsufficientException e = new BalanceInsufficientException으로 받아야한다.
			// throw붙이면 예외라고 처리함
			// 자바에 정의된 예외가 아니라 새로운 예외를 만들고 싶을 떄 throw쓰면 자바가 알아서 예외 발생시키고 싶은거라고 인식함
			// 뒤에 실행시키지 않고 메소드를 호출시킨쪽으로 예외를 넘긴다.
			// 자바는 메소드 시그니처만보고 실행시키기 때문에 throws를 안붙이면 예외를 발생시키려고하는 건지 모른다.
			// 일부러 예외를 발생시킨경우에는 try catch구문 사용할 수 있지만, 사용하지 않는다.
			// 내부에서 처리가 가능함에도 애초에 메소드를 호출하는 외부에 예외를 던지기 위해 예외를 일부러 발생시키는 것이기 때문이다.
		}
		balance -= money;
		return balance;
		// 예외 발생하면 뒤에는 아예 실행이 안되기 때문에, else if문 사용하지 않고 if문만 사용한다.
	}
	
}
