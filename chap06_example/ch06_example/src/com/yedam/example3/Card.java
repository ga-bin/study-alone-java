package com.yedam.example3;

public class Card {

	private static int serialNum = 1100;
	private int cardNum;

	public Card() {
		this.cardNum = ++serialNum;
	}

	public static int getSerialNum() {
		return serialNum;
	}

	public int getCardNum() {
		return cardNum;
	}
}
