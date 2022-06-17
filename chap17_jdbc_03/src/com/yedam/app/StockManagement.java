 package com.yedam.app;

import java.util.HashMap;
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
	private ProductDAO pDAO = ProductDAO.getInstance();
	private HistoryDAO hDAO = HistoryDAO.getInstance();
	public StockManagement() {
		while(true) {
			// 메뉴출력
			menuPrint();
			// 메뉴입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1) {
				// 제품 등록
				inputProduct();
			} else if (menuNo == 2) {
				// 제품 입고
				productIn();
			} else if (menuNo == 3) {
				// 제품 출고
				productOut();
			} else if (menuNo == 4) {
				// 제품 재고
				productStock();
			} else if (menuNo == 5) {
				// 전체 재고
				allProductStock();
			}
			  else if (menuNo == 6) {
				deleteProduct();
			} else if (menuNo == 9) {
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
	
	private void deleteProduct() {
		System.out.println("삭제할 제품의 ID를 입력하세요");
		int num = inputNum();
		hDAO.deleteOne(num);
	}
	
	private void menuPrint() {
		System.out.println("==================================================");
		System.out.println("1.제품등록  2.입고   3.출고  4.제품제고   5.전체제고   6.제품삭제   9.종료");
		System.out.println("===================================================");;
	}
	
	private int inputNum() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해 주세요");
		}
		return num;
	}
	
	private String inputString() {
		String str;
			str = sc.nextLine();
		return str;
	}
	
	private int selectMenu() {
		System.out.println("메뉴를 입력하세요");
		int menu = inputNum();
		return menu;
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void showInputError() {
		System.out.println("메뉴에 있는 숫자를 입력하세요 ");
	}
	
	private void inputProduct() {
		// 전제조건 : 기존의 상품과 이름은 다르게 들어간다.
		// 제품정보 입력
		Product product = inputAll();
		// DB에 저장
		pDAO.insert(product);
		
	}

	
	private void productIn() {
		// 입고할 제품과 수량 입력 
		Info info = inputAmount();
		// 거래내역(historydao)에는 productdao에 있는 것만 들어갈 수 있다.
		// 기존에 등록된 제품인지 확인하기
		Product product = pDAO.selectOne(info.getProductName());
		
		if (product != null) {
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(1);
			history.setProductAmount(info.getProductAmount());
			hDAO.insert(history);
		}
		else {
		System.out.println("해당 제품의 정보를 우선 등록하세요");
		// 기존에 등록된 제품일 경우 입고 처리
		
		// 기존에 등록되지 않은 경우 별도 안내
	}
	}
		
		private Product inputAll() {
			Product product = new Product();
			System.out.println("제품이름 >");
			product.setProductName(sc.nextLine());
			System.out.println("제품 가격 > ");
			product.setProductAmount(inputNum());
			return product;
		}
		
	private void productOut() {
		// 출고할 제품과 수량을 입력
		Info info = inputAmount();
		// 등록되어있는 제품인지 확인
		Product product = pDAO.selectOne(info.getProductName());
		if (product == null) {
			System.out.println("해당 제품의 정보를 확인해 주세요.");
			return;
		}
			// 재고량이 있는지 확인
			int stock = selectStock(product.getProductId());
			// 재고량과 출고량을 비교
			if (stock >= info.getProductAmount()) {
				// -1 조건을 모두 만족하는 경우 출고 처리
				History history = new History();
				history.setProductId(product.getProductId());
				history.setProductCategory(2);
				history.setProductAmount(info.getProductAmount());
				
				hDAO.insert(history);
			} else {
				// -2 각 조건이 만족되지 않는 경우 적합한 문구를 출력
				System.out.println("재고량이 출고량보다 작습니다.");
			}
			
		} 
	
		
	
	// 제품 재고 출력하는 메소드
	private void productStock() {
		// 검색하고자 하는 제품 정보 입력
		String productName = inputName();
		// 등록된 제품인지 확인
		Product product = pDAO.selectOne(productName);
		
		if (product == null) {
			System.out.println("해당 제품의 정보가 등록되어 있지 않습니다.");
			return;
		} 
		// 해당 제품의 재고 출력
		int stock = selectStock(product.getProductId());
		
		System.out.println("제품 번호 : " + product.getProductId() + ", 제품 이름 : " + product.getProductName() + ", 재고 : " + stock);
				
	}
	
	private void allProductStock() {
		Map<Integer, Integer> list = hDAO.selectAll();
		Set<Integer> productList = list.keySet();
		for (int productId : productList) {
			Product product = pDAO.selectOne(productId);
			int stock = list.get(productId);
			
			System.out.println("제품 번호 : " + product.getProductId() + ", 제품 이름 : " + product.getProductName() + ", 재고 : " + stock);
		}
		}
	
		
	private Info inputAmount() {
		Info info = new Info();
		System.out.println("제품이름");
		info.setProductName(sc.nextLine());
		System.out.println("수량");
		info.setProductAmount(inputNum());
		return info;
	}
	
	private String inputName() {
		System.out.println("제품이름>");
		return sc.nextLine();
	}
	
	private int selectStock(int productId) {
		int stock = 0;
		int in = hDAO.selectInAmount(productId);
		int out = hDAO.selectOutAmount(productId);
		return(in - out);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
