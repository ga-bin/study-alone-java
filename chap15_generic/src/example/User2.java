package example;

public class User2 extends Thread {
	private Calculator calculator; // 공유 객체 calculator 타입 필드 선언
	
	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		// 공유객체인 calculator 필드에 저장
		this.calculator = calculator;
	}
	
	public void run() {
		calculator.setMemory(50);
		// 공유객체인 calculator의 메모리에 50을 저장
	}
}
