package com.yedam.app.deal;

import java.sql.Date;

public class DealInfo {
	// reciviginggoods와 takeoutgoods의 컬럼명이 동일해서
	// 하나의 vo클래스를 공유하는 형태로 만듬
	private Date dealDate;
	private int productId;
	private String productName;
	private int productAmount;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	@Override
	public String toString() {
		String result = "거래일자 "  + dealDate + ", 제품번호 : " + productId;
		if (productName != null ) {
			result += ",제품이름 : " + productName;
				
		}
		result += ", 수랑 : " + productAmount;
		return result; 
	}
}
