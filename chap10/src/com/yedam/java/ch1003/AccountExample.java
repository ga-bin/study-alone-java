package com.yedam.java.ch1003;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(100000);
		System.out.println("예금액 :" + account.getBalance());
		
		try {
			account.withDraw(30000000);
			// 자바는 메소드 시그니처만보고 실행하는 것이기 때문에
			// 내부에서 어떤 오류가 발생할 수 있다고 알려줘야함
		} catch (BalanceInsufficientException e) {
			
			e.printStackTrace();
//			e.getMessage();
		}
		
		
		

	}

}
