package com.yedam.java.ch1201;

public class UserTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setMemory(100);
		// calcultor인스턴스 하나에 user1과 user2스레드가 동시에 접근함
		// 
		
		User user1 = new User();
		user1.setCalculator(cal);
		user1.start();
		// 2. user2가 멈추고 있는동안 user의 setcalculaotr메소드와 user.start
		// 메소드가 실행된다. 
		
		User user2 = new User();
		user2.setCalculator(cal);
		user2.start();
		// 1. user1이 user1.setCalculator로 접근하고 있으므로 쓰레드 멈춘다.
		// 객체는 그대로이
		

	}

}
