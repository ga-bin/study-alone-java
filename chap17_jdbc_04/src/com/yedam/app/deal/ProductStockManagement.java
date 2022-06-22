package com.yedam.app.deal;

import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.Management;
import com.yedam.app.product.Product;

public class ProductStockManagement extends Management {
	// 제품입고, 출고, 재고를 관리하는 프로그램

	public ProductStockManagement() {
		boolean role = selectRole();
		while (true) {
			menuPrint(role);

			int menuNo = menuSelect();

			if (menuNo == 1 && role) {
				// 제품입고
				productIn();
			} else if (menuNo == 2 && role) {
				// 제품출고
				productOut();
			} else if (menuNo == 3) {
				// 제품재고
				productStock();
			} else if (menuNo == 4 && role) {
				// 제품거래내역
				productDeal();
			} else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				showInputError();
			}
		}
	}
	
	
	protected void menuPrint(boolean role) {
		String menu = "";
		if (role) {
			menu += "1. 제품 입고   2. 제품 출고";
		} 
		menu += "3. 제품 재고";
		if (role) {
			menu += "    4. 제품 거래내역 ";
		}
		menu += "     9. 뒤로가기";
		System.out.println("==============================================================");
		System.out.println(menu);
	}
	
	
	private void back() {
		System.out.println("이전으로 돌아갑니다.");
	}
	
	private void productIn() {
		// 제품과 입고 수량을 입력
		DealInfo info = inputAmount();
		
		// 해당 제품의 등록 여부
		Product product = pDAO.selectOne(info.getProductName());
		
		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		
		
		// 등록되었을 경우에 입고처리
		info.setProductId(product.getProductId());
		rDAO.insert(info);
		// 입고처리가 완료되었을 때 products의 재고량 수정
		updateProductStock(info.getProductId());
	}
	
	private void productOut() {
		// 제품과 출고 수량을 입력
		DealInfo info = inputAmount();
		
		// 제품의 등록 여부 
		Product product = pDAO.selectOne(info.getProductName());
		
		
		if(product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		 
		// 해당 제품의 재고와 출고 수량을 비교
		if (product.getProductStock() >= info.getProductAmount()) {
			info.setProductId(product.getProductId());
			tDAO.insert(info);
		} else {
			System.out.println("재고가 부족합니다.");
		}
		// 재고보다 출고수량이 적을 경우에 한해서만 출고 처리
		
		// 출고처리가 완료되었을 때 products의 재고량 수정
		updateProductStock(info.getProductId());
	}
	
	
	private DealInfo inputAmount() {
		DealInfo info = new DealInfo();
		// 제품이름
		System.out.println("제품이름");
		info.setProductName(sc.nextLine());
		System.out.println("제품수량");
		info.setProductAmount(inputNum());
		
		return info;
	}
	
	private void updateProductStock(int productId) {
		// 해당 제품의 재고량 확인 및 수정
		// 해당 제품의 입고량
		int inputAmount = rDAO.selectAmount(productId);
		
		// 해당 제품의 출고량
		int outputAmount = tDAO.selectAmount(productId); 
		
		// 재고(입고량 - 출고량)을 수정
		int stock = inputAmount - outputAmount;
		
		// products에 업데이트
		Product product = new Product();
		product.setProductId(productId);
		product.setProductStock(stock);
		pDAO.updateStock(product);
	}
	
	// 제품 재고 조회
	private void productStock() {
		// 재고를 조회하고자 하는 제품 이름 입력
		String productName = inputName();
		
		Product product = pDAO.selectOne(productName);
		
		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		
		// 해당 제품의 정보 출력
		System.out.println(product); // 객체를 담을때 자동으로 toString 돌아간다.
	}
	
	//
	
	private String inputName() {
		System.out.println("제품 이름을 입력하세요");
		return sc.nextLine();
	}
	
	// 제품 거래 내역 조회
	// 입고, 출고, 재고 전체 조회
	private void productDeal() {
		// 입고, 출고 선택
		int choice = inputSelect();
		
		List<DealInfo> list = new ArrayList<>();
		if (choice == 1) {
			list = rDAO.selectAll();
		} else if (choice == 2) {
			list = tDAO.selectAll();
		} 
		
		for(DealInfo info : list) {
			System.out.println(info);
		}
		
		
	}
	
	private int inputSelect() {
		System.out.println("===============");
		System.out.println("1. 입고   2. 재고");
		int selectNum = inputNum();
		if (selectNum == 1) {
			System.out.println("=========== 입고내역");
		} else {
			System.out.println("========== 출고내역");
		}
		return selectNum;
	}
}