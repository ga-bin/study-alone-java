package example;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	// 계산기 메모리에 값을 저장하는 코드
	// 매개값을 memory필드에 저장
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000); // 스레드를 2초간 정지시킴
		} catch(InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		// user1이나 user2의 객체가 들어와 그 이름을 가지고 옴 + this.memory
	}
}
