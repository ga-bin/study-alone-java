package com.yedam.java.ch0606;

public class Car {
	// 필드
	// private라서 필드명으로 접근 불가능
	private int speed;
	private boolean stop;
	
	// 생성자
	// 메소드
	// speed 게터
	public int getSpeed() {
		return speed;
	} 
	
	// speed 세터
	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
			return;
		} else {
		this.speed = speed;
		}
	}
	
	// stop 게터
	public boolean isStop() {
		return stop;
	}
	
	// stop 세터
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
