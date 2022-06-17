package com.yedam.app.history;

public class History {
	// history vo
	private int productId;
	// productCategory;
	// 1 : 입고, 2 : 출고
	// 라고 약속하는것
	// oracle은 boolean타입없어서, db의 productCategory에 check로 2개의 값만 입력 받을 수 있도록 제약을 걸어두었다.
	private int productCategory;
	private int productAmount;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
}
