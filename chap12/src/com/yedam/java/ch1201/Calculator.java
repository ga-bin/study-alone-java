package com.yedam.java.ch1201;

public class Calculator {
	// 공유하는 클래스(여러 스레드가 동시에 접근)
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) { // 100 + serialNum으로 되어있다.
		// 필드를 건드리는 메소드는 동기화 메소드를 만드는 것이 좋다.
		// synchronized
		// 1개의 쓰레드만 이 메소드에 진입할 수 있습니다. 
		// 다른 쓰레드들은 먼저 진입한 쓰레드에서 메소드 호출이 종료될 때까지 대기하게 됩니다.
		this.memory = memory;
		try {
			Thread.sleep(2000); // calculator에 접근한 thread를 일시정지 -> memory의 값이 유지될 것
		} catch (InterruptedException e) {		
		}Thread info = Thread.currentThread();
		// interrupted가 걸린 thread가 뭔지 출력
		System.out.println("현재 스레드 : " + info.getName() + ", memory : " + memory);
	}
	
}
