package com.yedam.java.example1;

public class Vip extends Customer {

	// 필드
	double disCountRatio;
	String counselor;

	public double getDisCountRatio() {
		return disCountRatio;
	}

	public void setDisCountRatio(double disCountRatio) {
		this.disCountRatio = disCountRatio;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	// 생성자
	Vip(int customerId, String customerName, String counselor) {
		super(customerId, customerName);
		this.customerGrade = "VIP";
		this.disCountRatio = 0.15;
		this.bonusRatio = 0.05;
		this.counselor = counselor;
	}

	@Override
	// 메소드
	public int calcPrice(int price) {
		price = (int) (super.calcPrice(price) * (1 - disCountRatio));
		return price;
	}

	// counselor알려주는 메소드
	public String counselor(String counselor) {
		return super.customerName + "님의 상담원은 " + this.counselor + "입니다";
	}

	// @Override
	public String showCustomerInfo() {
			return super.showCustomerInfo() +  "\n" + "담당 상담원은" + this.counselor + "입니다";
		}
}
