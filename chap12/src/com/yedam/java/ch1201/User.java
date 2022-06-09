package com.yedam.java.ch1201;

public class User extends Thread {
	private static int serial = 0;
	private Calculator cal;
	
	public void setCalculator(Calculator cal) {
		serial += 100;
		this.setName("user" + serial); // 클래스 user안의 thread의 이름 설정
		this.cal = cal;
	}
	
	@Override
	public void run() {
		cal.setMemory(100 + serial);
	}
}
