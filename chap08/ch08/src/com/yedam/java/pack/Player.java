package com.yedam.java.pack;

public class Player {

	// field
	private String name;
	private int stat;
	private int backNumber;
	private static int number = 0;

	// constructor
	public Player() {
	}

	public Player(String name, int stat) {
		this.name = name;
		this.stat = stat;
		this.backNumber = number++;
	}

	// getter, setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}

	public void showInfo() {
		System.out.println(name + "의 능력치는 " + stat + "이고, 등번호는 " + backNumber + "입니다.");
	}

}
