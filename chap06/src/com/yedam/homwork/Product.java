package com.yedam.homwork;

public class Product {
	// 상품에 대한 정보를 가지는 클래스(상품명, 가격)
	// 필드
	private String name;
	private int price;
	
	// 생성자
////	생성자로 상품명, 가격 초기화
////	Product(String name, int price) {
////		this.name = name;
////		this.price = price;
//	}
	
	// 메소드
	// 게터 세터로 상품명, 가격 초기화
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
