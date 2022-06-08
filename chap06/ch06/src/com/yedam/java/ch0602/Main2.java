package com.yedam.java.ch0602;

public class Main2 {
	public static void main(String[] args) {
		Car myCar = new Car("Blue");
		
		Car yourCar=new Car("티볼리", "Silver");
		
		Car newCar = new Car("레이", "Yello", 120);
		
		
		System.out.println(myCar.color+" "+myCar.model+" "+myCar.maxSpeed);
		System.out.println(yourCar.color+" "+yourCar.model+" "+yourCar.maxSpeed);
		System.out.println(newCar.color+" "+newCar.model+" "+newCar.maxSpeed);
		
	}
}
