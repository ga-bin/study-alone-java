package com.yedam.java.ch1202;

public class PrintThread extends Thread {
	@Override
	public void run() {
		// 인터럽트를 이용해 스레드를 종료시키고 싶을 때
//		try {
//			while (true) {
//				System.out.println("실행중");
//				Thread.sleep(1000);
//			}
//		} catch (InterruptedException e) {
//			System.out.println("interrupt method 실행");
//		}
//		System.out.println("자원 정리");
//		System.out.println("종료");
	
		// 작업 중지시 현재스레드에서 추가작업이 필요한 경우
		while(true) {
			try {
				System.out.println("실행중");
				Thread.sleep(1000);
			}
		 catch (InterruptedException e) {
			System.out.println("interrupt method 실행");
		}
	}
	}
}
