package com.yedam.example1;

public class Subway {

	private String lineNumber;
	private int money;
	private int passengerCount;
	private int pay;

	public Subway(String lineNumber, int pay) {
		this.lineNumber = lineNumber;
		this.pay = pay;
	}

	public int getPay(int age) {
		if (age < 20) {
			return pay - 200;
		} else {
			return pay;
		}
	}

	public void take(int pay) {
		this.money += pay;
		this.passengerCount++;
	}

	public void showInfo() {
		System.out.println(lineNumber + "의 승객 " + passengerCount + "명, 수입 " + money);
	}

}
