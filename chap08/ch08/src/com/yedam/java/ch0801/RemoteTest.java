package com.yedam.java.ch0801;

public class RemoteTest {

	public static void main(String[] args) {
		RemoteControl rc = new Tv();

		// rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();

		SmartControl sc = new Tv();
		sc.searchInternet("naver");
		sc.executeApp("google");
		
		TvControl c = new Tv();
		Control ct = new Tv();
		
		ct.turnOn();
		ct.executeApp("123");
		c.turnOn();
		c.searchInternet("네이버");
	}

}
