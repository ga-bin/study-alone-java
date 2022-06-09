package com.yedam.java.ch1201;

public class ThreadB extends Thread {
	
	// run메소드는 thread가 가지고 있는 것 -> 상속받아서 오버라이딩한다.
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("현재 순서 : " + i);	
			try {
				Thread.sleep(500); // 일시 정지, 0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
