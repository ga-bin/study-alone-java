package com.yedam.app.product;

import com.yedam.app.common.Management;

public class ProductInfoManagement extends Management {
	
	
	ProductInfoManagement() {
		while(true) {
			menuPrint();
			int menuNum = selectMenu();
			if (menuNum == 1) {
				inputProductInfo();
			} else if (menuNum == 2) {
				deleteProductInfo();
			} else if (menuNum == 3) {
				updateProductInfo();
			} else if (menuNum == 9) {
				back();
				break;
			} else {
				showInputError();
			}
		}
	}
	
	@Override
	protected void menuPrint() {
		System.out.println("=============================================");
		System.out.println("1. 제품정보 입력    2. 제품정보 삭제    3, 제품 정보 수정");
		System.out.println("=============================================");
	}
	
	private void back() {
		System.out.println("뒤로 돌아갑니다.");
	}
	
	private void inputProductInfo() {
		Product product = inputAll();
		pDAO.insert(product);
		
	}
	
	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품 이름");
		product.setProductName(sc.nextLine());
		System.out.println("제품 가격");
		product.setProductPrice(inputNum());
		// 재고는 receivinggoodsdao와 takeoutdao와 연동해서 적는다.
		return product;
	}
	
	private void deleteProductInfo() {
		String productName = inputName();
		
		Product product = pDAO.selectOne(productName);
		
		if (product == null) {
			System.out.println("등록된 제품 정보가 없습니다.");
			return;
		}
		
		boolean isSelected = rDAO.selectInfo(product.getProductId());
		if (!isSelected) {
			pDAO.delete(product.getProductId());
		} else {
			System.out.println("거래 내역이 존재합니다.");
		}
	}
	
	private String inputName() {
		System.out.println("제품 이름을 입력하세요");
		return sc.nextLine();
	}
	
	private void updateProductInfo() {
		String productName = inputName();
		
		Product product = pDAO.selectOne(productName);
		
		if (product == null) {
			System.out.println("등록된 제품 정보가 없습니다.");
			return;
		} else {
			product = inputUpdateInfo(product);
			pDAO.insert(product);
		}
	}
	
	private Product inputUpdateInfo(Product product) {
		System.out.println("기존 제품 이름" + product.getProductId());
		System.out.println("수정할 이름을 입력하세요(수정 안할경우 0)");
		String name = inputName();
		if (!name.equals("0")) {
			product.setProductName(name);
		}
		
		System.out.println("기존 제품 가격 " + product.getProductPrice());
		System.out.println("수정할 가격을 입력하세요");
		int price = inputNum();
		if (price > -1) {
			product.setProductPrice(price);
		}

		return product;
	}
}
