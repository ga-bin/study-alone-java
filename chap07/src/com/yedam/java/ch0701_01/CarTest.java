package com.yedam.java.ch0701_01;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i = 1; i <=5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽", 15);
				// 타입이 다른데 넣었다?
				// car안에 frontLeftTire의 타입은 Tire이기 때문
				break;
			case 2:
				System.out.println("앞오른쪽 Tire 교체");
				car.frontRightTire = new Tire("앞오른쪽", 15);
				break;
			case 3:
				System.out.println("뒤왼쪽 KumhoTire 교체");
				car.backLeftTire = new KumhoTire("뒤왼쪽	`", 15);
				break;
			case 4:
				System.out.println("뒤오른쪽 Tire 교체");
				car.backRightTire = new Tire("뒤오른쪽", 15);
				break;
			}
			System.out.println("---------------------------");
		}

	}

}
