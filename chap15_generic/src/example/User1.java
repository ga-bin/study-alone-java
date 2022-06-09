package example;

public class User1 extends Thread {
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		// 스레드 이름 user1로 설정
		this.setName("User1");
		// 공유객체인 calculator를 필드에 저장
		this.calculator = calculator;
	}
	
	public void run() {
		// 공유객체인 calculator의 메모리에 100을 저장
		calculator.setMemory(100);
	}
}
