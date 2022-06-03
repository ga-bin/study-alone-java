package com.yedam.java.ch1001;

public class MainTest {

	public static void main(String[] args) {
		// 실행예외

		// NullPointerException
		// 내가 접근한 변수가 null값을 가지고 있다는 말
		// null은 변수가 참조하는 인스턴스가 없다는말 -> 실행주체가 없다
		String data = null;
		if (data != null) {
			System.out.println(data.toString());
		}
		// dead code 어떤 경우에도 실행되지 않는 코드
		// null값을 가지는 것 자체가 문제가 아니라
		// null이어서 실행하는 인스턴스가 없는데 무엇인가를 요구하는 것 자체가 문제라는 말
		// 실행예외 : 문법적으로는 문제가 없다, 실제 실행 시 발생하는 오류
		// 참조타입은 null을 가질 수 잇고, String타입이기때문에 toString메소드를 사용할 수 있음

		// ArrayIndexOutOfBoundsException
		if (args.length >= 2) {
			String data1 = args[0];
			String data2 = args[1];

			// 실행예외는 정상적인 값이 들어오면 실행된다.
			// 일반예외는 문법적오류 -> 무조건 실행안됨

			System.out.println("args[0] : " + data1);
			System.out.println("args[1] : " + data2);
		}
		
		// NumberFormatException
		// 문자를 숫자로 바꾸는 과정 parse할때 제일 많이 일어남
		// 왜일어나는지 알려준다 처리간단
//		String data1 = "100";
//		String data2 = "a100";
//		
//		int value1 = Integer.parseInt(data1);
//		int value2 = Integer.parseInt(data2); 
//		
		// ClassCastException
		// Cast는 타입변환 -> 상속관계, 구현관계 안에서 타입변환 일으켰을때 자주 발생한다
		changeDog(new Dog());
		changeDog(new Cat());
		// 코드상으로 Cat도 Animal을 상속하기때문에 문법상으로는 오류가 없다.
	}

	public static void changeDog(Animal animal) {
		if(animal instanceof Dog) {
		Dog dog = (Dog) animal;
		// Dog로 타입변환시켰다.
		}
	}
}

class Animal{}

class Dog extends Animal {}

class Cat extends Animal {}


