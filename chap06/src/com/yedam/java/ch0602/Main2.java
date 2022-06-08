package com.yedam.java.ch0602;

public class Main2 {

	public static void main(String[] args) {
		Car myCar = new Car(); // 생성자 여러개 만들면 기본생성자가 default값으로 생기지 않는다. -> 명시적으로 만들자
		
		Car myCar1 = new Car("blue"); // 메소드로 생성자 호출 불가능
		
		Car yourCar = new Car("티볼리", "Silver");
		
		Car newCar = new Car("레이", "yello", 120);
		
		
		System.out.println(myCar1.color);
		System.out.println(yourCar.color);
		System.out.println(newCar.color);
		System.out.println(newCar.maxSpeed);


	}

}
