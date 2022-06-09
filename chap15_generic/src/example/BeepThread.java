package example;

import java.awt.Toolkit;

public class BeepThread extends Thread {
	// thread에도 run메소드가 있는데 왜 runnable을 통해서 sleep을 걸어야하는가?
	// Thread를 상속받아서 실행하기
	// thread를 상속받을때와 runnable으로 구현할때의 차이점은
	// thread를 부모클래스로 상속받는 경우 thread만 상속받을 수 있지만,
	// runnable은 인터페이스 형태로 implements를 통해서 다중 인터페이스를 구현할 수 있기 때문에
	// 클래스에서 구현하고자 하는 것이 여러개일 경우에는 runnable을 사용해야한다
	
	// 그리고 runnable로 thread를 만드는 경우 재사용이 가능하지만
	// Thread를 상속받아서 만드는 경우에는 재사용이 불가능하다
	// Thread는 runnable을 이미 구현한 클래스로 runnable을 포함한 상태로 객체를 만들기때문에
	// runnable의 참조값을 가질 수 없다.
	// Thread d = Runnable runnable(); 이런식으로 선언 가능할듯
	
	// thread의 재사용 불가능 http://ojc.asia/bbs/board.php?bo_table=LecJava&wr_id=241
	// Thread thread1 = new MyThread();
    // thread1.start();
    // thread1.join();  //thread가 종료될때까지 main이 기다린다.
   
    //아래 부분의 주석을 풀면 오류남...
    //Thread를 상속받아 구현한 쓰레드는 재사용 불가
    //thread1.start();
    //thread1.join();     
	
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
