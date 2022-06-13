package com.yedam.java.ch1601;

public class ThreadTest	implements Runnable {

	public static void main(String[] args) {
		Runnable rn = () -> {
			System.out.println("람다식으로 구현");
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};
		
		Thread thread = new Thread(rn);
		thread.start();
		
		// Runnable task = new task();
		// thread = new Thread(task); 
		// 를 람다식으로 구현 가능하다.
		thread = new Thread(() -> {
			System.out.println("매개변수 -> 람다식");
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		}
		);
		
		thread.start();
	}

	@Override
	public void run() {
		
		
	}

}
