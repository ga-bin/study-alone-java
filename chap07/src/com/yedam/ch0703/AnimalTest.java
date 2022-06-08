package com.yedam.ch0703;

public class AnimalTest {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();

		dog.sound();
		cat.sound();
		
		System.out.println();
		
		Animal animal = dog;
		animal.sound();
		animal = cat;
		animal.sound();
		// 추상클래스에 대해서도 타입변환이 일어난다
		// 오버라이딩도 가능
	}

}
