package com.yedam.example3;

public class CardFactory {

	private static CardFactory instance = new CardFactory();

	private CardFactory() {
	}

	public static CardFactory getInstance() {
		return instance;
	}

	public Card createCard() {
		return new Card();
	}

}
