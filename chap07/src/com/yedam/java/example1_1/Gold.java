package com.yedam.java.example1_1;

public class Gold extends Customer{
	
	// 필드
	double discountRatio;
	
	// 생성자
	Gold(int customerId, String customerName) {
		super(customerId, customerName);
		this.customerGrade = "Gold";
		this.bonusRatio = 0.02;
		this.discountRatio = 0.1;
	}
	

	// 메소드
	@Override
	public int calcPrice(int price) {
		return (int)((super.calcPrice(price))*(1-this.discountRatio));
	}
	
	// 게터 세터
	
	public double getDiscountRatio() {
		return discountRatio;
	}
	
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	
}
