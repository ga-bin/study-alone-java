package com.yedam.java.ch0802;

public class Driver {
	void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) {
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		} 
		vehicle.run(); // driver는 run이라는 메소드를 사용한다
	}
}
