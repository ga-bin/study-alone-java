package com.yedam.java.homework1;

public class Human {
	// 필드
	String name;
	int height;
	int weight;
	
	// 생성자
	
	Human() {
		
	}
	
	Human(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	// 메소드
	
	
	public void getInformation() {
		System.out.println(name + "의 키는" + this.height + "이고, 몸무게는 " +  this.weight + "입니다.");

	}
	
}
