package com.yedam.app.product;

public class Product {
	int productId;
	String productName;
	int productPrice;
	int productStock;
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
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	@Override
	public String toString() {
		return "제품번호 : " + productId + "제품이름 : " + productName +  "제품 가격" + productPrice + "제품 재고" + productStock + ", 현 재고기반 가치" + productStock * productPrice;
	}
	
	
}
