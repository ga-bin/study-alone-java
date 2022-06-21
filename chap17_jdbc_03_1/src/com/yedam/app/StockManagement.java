package com.yedam.app;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.yedam.app.common.Info;
import com.yedam.app.history.History;
import com.yedam.app.history.HistoryDAO;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class StockManagement {
	private Scanner sc = new Scanner(System.in);
	private ProductDAO productDAO = ProductDAO.getInstance();
	private HistoryDAO historyDAO = HistoryDAO.getInstance();

	public StockManagement() {
		while(true) {
			// 메뉴출력
			menuPrint();
			// 메뉴입력
			int menuNum = selectMenu();
			// 각 기능별 실행
			if (menuNum == 1) {
			// 제품등록
				inputProduct();
			} else if (menuNum == 2) {
				// 제품입고
				productIn();
			} else if (menuNum == 3) {
				// 제품 출고
				productOut();
			} else if (menuNum == 4) {
				// 제품 재고
				productStock();
			} else if (menuNum == 5) {
				// 전체 재고
				allProductStock();
			} else if (menuNum == 9) {
				// 종료
				exit();
				break;
			} else {
				// 입력오류
				showInputError();
				break;
			}
		}
	}

	public void menuPrint() {
		System.out.println("============================================================");
		System.out.println("1. 제품등록  2.입고   3. 출고   4. 재고    5. 전체재고   9. 프로그램종료");
	}

	public void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	public void showInputError() {
		System.out.println("메뉴에 있는 숫자를 입력하세요");
	}

	public int inputNum() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력하세요");
		}
		return num;
	}

	public int selectMenu() {
		System.out.println("메뉴를 입력하세요");
		int menuNum = inputNum();
		return menuNum;
	}

	public void inputProduct() {
		Product product = inputAll();
		
		productDAO.insert(product);
	}

	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품이름>");
		product.setProductName(sc.nextLine());
		System.out.println("제품 가격>");
		product.setProductPrice(inputNum());
		return product;
	}
	
	private void productIn() {
		Info info = inputAmount();
		Product product = productDAO.selectOne(info.getProductName());
		
		if (product != null) {
			History history = new History();
			history.setProductId(info.getProductId());
			history.setProductCategory(1);
			history.setProductAmount(info.getProductAmount());
		} else {
			System.out.println("해당 제품의 정보를 우선 등록하세요.");
		}
	}
	
	private void productOut() {
		Info info = inputAmount();
		Product product = productDAO.selectOne(info.getProductName());
		
		if (product != null) {
			History history = new History();
			history.setProductId(info.getProductId());
			history.setProductCategory(2);
			history.setProductAmount(info.getProductAmount());
			
		} else {
			System.out.println("해당 제품의 정보를 우선 등록해 주세요");
		}
	}
	
	
	private Info inputAmount() {
		Info info = new Info();
		System.out.println("제품 이름");
		info.setProductName(sc.nextLine());
		System.out.println("제품 수량");
		info.setProductAmount(inputNum());
		return info;
	}
	
	
	private void productStock() {
		String productName = inputName();
		Product product = productDAO.selectOne(productName);
		
		if (product == null) {
			System.out.println("해당 제품의 정보가 등록되어 있지 않습니다.");
			return;
		} 
		int stock = selectStock(product.getProductId());
		System.out.println("제품 번호 : " + product.getProductId() + "제품 이름 : " + product.getProductName() + "재고량 : " + stock);
	}
	
	
	private String inputName() {
		System.out.println("제품이름");
		return sc.nextLine();
	}
	
	
	private int selectStock(int productId) {
		int in = historyDAO.selectInAmount(productId);
		int out = historyDAO.selectOutAmount(productId);
		return (in - out);
		
	}
	
	private void allProductStock() {
		Map<Integer, Integer> list = historyDAO.selectAll();
		Set<Integer> productList = list.keySet();
		for (int productId : productList) {
			Product product = productDAO.selectOne(productId);
			int stock = list.get(productId);
			System.out.println("제품 번호 : " + product.getProductId() + "제품 이름 : " + product.getProductName() + "재고 " + stock);
		}
	}
	
}
