package example;

import java.awt.Toolkit;

public class BeepTask implements Runnable {

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

}
