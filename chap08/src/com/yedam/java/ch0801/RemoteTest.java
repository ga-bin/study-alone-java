package com.yedam.java.ch0801;

public class RemoteTest {

	public static void main(String[] args) {
		RemoteControl rc = new TV();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		
		SmartControl sc = new TV();
		sc.searchInternet("네이버");
		sc.executeApp("구글");
		
		TV tv = new TV();
		tv.turnOn();
		
		Control con = new TV();
		con.turnOn();
		con.executeApp("게임");
	}

}
