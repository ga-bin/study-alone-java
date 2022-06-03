package com.yedam.java.ch0606;

import com.yedam.java.ch0605.Car;

// 현재 패키지에 없는 클래스를 사용하고자 할 떄 import를 함

public class MainTest {

	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		// 클래스가 public이면 프로젝트 어디든 사용가능
		// default인경우 다른 패키지에서 사용불가능
		myCar.run();
		
	}

}
