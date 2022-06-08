package com.yedam.java.hw;

// VO, DTO 클래스
public class Book {

	// field
	private static int serialNum = 1000;
	private int isbn;
	private String name;
	private int price;

	// constructor
	public Book() {
	}

	public Book(String name, int price) {
		this.name = name;
		this.price = price;
		serialNum += 1;
		this.isbn = serialNum;
	}

	// getter setter

	public static long getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Book.serialNum = serialNum;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void showInfo() {
		System.out.println(name + "의 가격은 " + price + "원이고, ISBN은 " + isbn + "입니다.");
	}

}