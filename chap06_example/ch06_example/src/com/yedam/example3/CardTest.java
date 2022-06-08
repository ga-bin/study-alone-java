package com.yedam.example3;

public class CardTest {

	public static void main(String[] args) {
		
		CardFactory cf = CardFactory.getInstance();

		Card sinhan = cf.createCard();
		Card kakao = cf.createCard();

		System.out.println(sinhan.getCardNum());
		System.out.println(kakao.getCardNum());
		System.out.println(Card.getSerialNum());
		
	}

}
