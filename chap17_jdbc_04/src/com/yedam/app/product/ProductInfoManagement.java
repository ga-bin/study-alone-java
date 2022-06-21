package com.yedam.app.product;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.yedam.app.common.Management;

public class ProductInfoManagement extends Management {
	// 제품에 대한 정보를 등록, 수정, 삭제
	
	public ProductInfoManagement() {
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				// 제품정보 등록
				insertProductInfo();
			} else if (menuNo == 2) {
				// 제품 정보 수정 - 가격
				updateProductInfo();
			} else if (menuNo == 3) {
				// 제품 정보 삭제
				deleteProductInfo();
			} else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				// 입력오류
				showInputError();
			}
		}
	}
	
	@Override
	protected void menuPrint() {
		System.out.println("=======================================================");
		System.out.println("1. 제품정보 등록   2. 제품정보 수정   3. 제품정보 삭제    9. 뒤로가기");
		System.out.println("========================================================");
	}
	
	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}
	private void insertProductInfo() {
		Product product = inputAll();
		pDAO.insert(product);
	}
	
	private Product inputAll() {
		Product product = null;
		System.out.println("제품이름");
		product.setProductName(sc.nextLine());
		System.out.println("제품 가격");
		product.setProductPrice(inputNum());
		return product;
	}
	
	private void deleteProductInfo() {
		// 제품 이름 입력
		String productName = inputName();
		// 제품 정보 검색
		// -1 products 테이블에서 정보 
		Product product = pDAO.selectOne(productName);
		
		if(product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// -2 입고내역에서 검색
		// 삭제하려면 입고 테이블에서 검색 결과가 없어야한다.
		boolean isSelected = rDAO.selectInfo(product.getProductId());
		
		// 검색 결과가 없는 경우 db에서 삭제
		if (!isSelected) {
			pDAO.delete(product.getProductId());
		} else {
			System.out.println("거래 내역이 존재합니다.");
		}
	}
	
	private void updateProductInfo() {
		// 제품이름 입력
		String productName = inputName();
		// 제품정보 검색
		Product product = pDAO.selectOne(productName);
		if (product == null) {
			System.out.println("등록된 제품 정보가 없습니다.");
			return;
		} 
		
		// 수정할 정보 입력
		product = inputUpdateInfo(product);
		// db수정
		pDAO.updateInfo(product);
	}
	
	private String inputName() {
		System.out.println("제품 이름을 입력하세요");
		return sc.nextLine();
	}
	
	private Product inputUpdateInfo(Product product) {
		// 기존에 product에서 가지고 있던 정보 그대로 가지고오고
		// 수정할 것만 수정
		System.out.println("기존 제품이름" + product.getProductName());
		System.out.println("수정할 이름을 입력하세요(수정하지 않을 경우0)>");
		String name = inputName();
		if (!name.equals("0")) {
			product.setProductName(name);
		}
		
		System.out.println("기존 가격 " + product.getProductPrice());
		System.out.println("수정할 가격을 입력하세요");
		int price = inputNum();
		if (price > -1) {
			product.setProductPrice(price);
		} 
		
		return product;
	}
	
	
}
