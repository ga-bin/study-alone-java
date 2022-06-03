package com.yedam.java.example1;

public class Customer {
	// 필드
	int customerId; // 고객 아이디
	String customerName; // 고객 이름
	String customerGrade; // 고객 등급
	int bonusPoint; // 보너스 포인트
	double bonusRatio; // 보너스 포인트 적립율
	
	// 생성자
	Customer() {
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	// 메소드
	public int calcPrice(int price) {
		this.bonusPoint += price*bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + "님의 등급은" + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
	
	
	// 게터 세터
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
	public String getCustomerGrade() {
		return customerGrade;
	}
	
	public void setBounsPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	public int getBounsPoint() {
		return bonusPoint;
	}
	
	public void setBounsRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	public double getBounsRatio() {
		return bonusRatio;
	}
	
	
	
}

