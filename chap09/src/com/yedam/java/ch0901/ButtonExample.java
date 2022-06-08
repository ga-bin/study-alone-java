package com.yedam.java.ch0901;

public class ButtonExample {

	public static void main(String[] args) {
		Button button = new Button();
		   
		button.setOnClickListener(new CallListner());
		button.touch();
		
		button.setOnClickListener(new MessageListener());
		button.touch();
	}

}













