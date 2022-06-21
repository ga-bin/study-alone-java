package com.yedam.app.product;

public class Product {
	private int productId;
	private String productName;
	private int productPrice;
	private int productAmount;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	@Override
	public String toString() {
		return "제품이름" + productName + "제품번호" + productId +  "제품 가격" + productPrice;
	}
	
	
}
