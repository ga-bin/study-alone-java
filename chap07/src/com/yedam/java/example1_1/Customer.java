package com.yedam.java.example1_1;

public class Customer {
	// 필드
	int customerId; // 고객 id
	String customerName; // 고객이름
	String customerGrade; // 고객 등급
	int bonusPoint; // 보너스 포인트
	double bonusRatio; // 보너스 포인트 적립율
	
	// 생성자 {
	Customer() {
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	
	Customer(int customerId, String customerName) {
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	
	// 메소드
	public int calcPrice(int price) {
		this.bonusPoint += this.bonusRatio; 
		return price;
	}
	
	
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다";
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerGrade() {
		return customerGrade;
	}


	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}


	public int getBonusPoint() {
		return bonusPoint;
	}


	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}


	public double getBonusRatio() {
		return bonusRatio;
	}


	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	 
}
