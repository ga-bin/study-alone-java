package com.yedam.java.question;

public interface Payment {
	static final double OFFLINE_PAYMENT_RATIO = 0;
	static final double ONLINE_PAYMENT_RATIO = 0;
	static final double SIMPLE_PAYMENT_RATIO = 0;
	
	public int offline(int price);
	
	public int online(int price);
	
	public int simple(int price);
	
	public void showCardInfo();
	
	
}
