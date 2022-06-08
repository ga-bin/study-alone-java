package com.yedam.example1;

public class TakeTrans {

	public static void main(String[] args) {
		Student hong = new Student("Hong", 5000, 30);
		Student lee = new Student("Lee", 2000, 15);
		Subway green = new Subway("2호선", 1500);
		Bus bus = new Bus("937", 1200);

		hong.take(green);
		hong.showInfo();
		green.showInfo();
		hong.take(bus);
		lee.take(bus);
		hong.showInfo();
		bus.showInfo();
		lee.showInfo();

	}

}
