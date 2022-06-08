package com.yedam.java.example1;

public class Gold extends Customer {
	// 필드
	double disCountRatio;
	
	// 생성자
	
	public Gold() {
		
	}
	public Gold(int customerId, String customerName) {
		super(customerId, customerName);
		this.customerGrade = "GOLD";
		this.bonusRatio = 0.02;
		this.disCountRatio = 0.1;
	}
	

	// 메소드
	@Override
	public int calcPrice(int price) {
		
		price = (int)(super.calcPrice(price)*(1 - this.disCountRatio));
		return price;
	
	}

	public double getDisCountRatio() {
		return disCountRatio;
	}

	public void setDisCountRatio(double disCountRatio) {
		this.disCountRatio = disCountRatio;
	}
	
	
}
