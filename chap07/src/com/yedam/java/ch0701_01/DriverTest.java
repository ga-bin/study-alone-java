package com.yedam.java.ch0701_01;

public class DriverTest {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
//		 Bus bus = new Bus();
//		 driver.drive(bus);
//		 bus.run();
		driver.drive(new Bus());
		driver.drive(new Taxi());
		driver.drive(new Vehicle());
		
		// 변수를 사용하면 인스턴스가 가지고 있는 메소드를 사용할 수 있지만
		// 메소드나, 필드 재사용할 것 아니면 메소드의 매개변수로 넘겨줄 수 있음
		
		// public class Driver {
//		void drive(Vehicle vehicle) {
//			vehicle.run();
//		}
//	}


	}

}
