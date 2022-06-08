package com.yedam.example1;

public class Student {

	private String name;
	private int money;
	private int age;

	public Student(String name, int money, int age) {
		this.name = name;
		this.money = money;
		this.age = age;
	}

	public void take(Subway subway) {
		int pay = subway.getPay(age);
		this.money -= pay;
		subway.take(pay);
	}
	
	public void take(Bus bus) {
		int pay = bus.getPay(age);
		this.money -= pay;
		bus.take(pay);
	}

	public void showInfo() {
		System.out.println(name + "의 남은 돈 " + money);
	}

}
