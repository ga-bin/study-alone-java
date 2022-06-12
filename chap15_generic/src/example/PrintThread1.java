package example;

public class PrintThread1 extends Thread {
	private boolean stop;
	// 스탑 플래그 이용해서 스레드 중지하기
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public void run() {
		while(!stop) {
			System.out.println("실행 중");
		}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
