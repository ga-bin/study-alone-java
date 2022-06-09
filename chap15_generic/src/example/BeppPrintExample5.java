package example;

import java.awt.Toolkit;

public class BeppPrintExample5 {

	public static void main(String[] args) {
		// 익명객체로 스레드 만들기
		Thread thread = new Thread() {
			// Runnable beepTask = new BeepTask();
			// Thread thread = new Thread(beepTask);
			// 와 비교하기
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					System.out.println("비프음이 발생합니다.");
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
			}
		};
		thread.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				
			}
		}
	}

}
