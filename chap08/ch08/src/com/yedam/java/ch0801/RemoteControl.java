package com.yedam.java.ch0801;

public interface RemoteControl {
	
	// final field
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	
	// abstract method
	public abstract void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	
	

}
