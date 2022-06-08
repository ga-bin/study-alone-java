package com.yedam.example1;

public class Bus {
	private String busNumber;
	private int money;
	private int passengerCount;
	private int pay;

	public Bus(String busNumber, int pay) {
		this.busNumber = busNumber;
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
		System.out.println(busNumber + "의 승객 " + passengerCount + "명, 수입 " + money);
	}
}
