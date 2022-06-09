package com.yedam.java.ch1201;

public class MultiThreadTest {

	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		// thread.currentthread -> 현재 메소드가 동작하는 시점의 스레드 정보를 가지고 올 때
		//
		System.out.println("메인 스레드 : " + main.getName());
//		Runnable a = new ThreadA();
//		Thread thread = new Thread(a);
//		Thread thread = new ThreadB();
		ThreadB thread = new ThreadB();
		thread.setName("threadA"); // 필요시 setName으로 스레드명 바꾸기 가능
		System.out.println("작업 스레드 : " + thread.getName());
		// 어느 스레드에서 문제 생겼는지 확인하기위해 스레드에 이름주기
		thread.start();
		
		
		
		for(int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 출력");
			try {
				Thread.sleep(500); // 일시 정지, 0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
