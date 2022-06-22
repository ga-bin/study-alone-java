package com.yedam.app.deal;

import java.sql.Date;

public class DealInfo {
	Date dealDate;
	int productId;
	int productAmount;
	String productName;
	
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
		String result = "거래일자 " + dealDate + ", 제품 번호" + productId;
		if (productName != null) {
			result += " 제품 이름" + productName;
		}
		result += "제품 수량" + productAmount;
		
		return result;
	}
	
	
}
