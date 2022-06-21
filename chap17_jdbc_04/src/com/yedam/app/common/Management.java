package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.deal.ReceivingGoodsDAO;
import com.yedam.app.product.ProductDAO;
import com.yedam.app.product.ProductInfoManagement;

public class Management {
	// 필드
	protected Scanner sc = new Scanner(System.in);
	protected ProductDAO pDAO = ProductDAO.getInstance();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getInstance();
	protected TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();
	
	// 상속관계일때는 생성자 사용하는 경우 무한루프돌 수 있다
	// new productInfoManagement를 생성하는 과정에서 부모클래스의 인스턴스도 함께
	// 생성되는데 부모클래스의 생성자에서 while문이 돌고 있는 경우 무한루프에 빠지기 때문
	public void run() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 제품정보 관리
				new ProductInfoManagement();
			} else if (menuNo == 2) {
				// 제품 관리
				new ProductStockMangement();
			} else if (menuNo == 9) {
				exit();
				break;
				// 프로그램 종료
			} else {
				// 입력오류
				showInputError();
				break;
			}
		}
	}
	
	// 메소드
	protected void menuPrint() {
		System.out.println("=======================================");
		System.out.println("1. 제품정보관리   2. 제품재고관리   9. 프로그램종료");
		System.out.println("=======================================");

	}
	
	protected void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	protected void showInputError() {
		System.out.println("메뉴에 있는 숫자를 입력하세요");
	}
	
	protected int menuSelect() {
		System.out.println("메뉴를 입력하세요");
		return inputNum();
	}
	
	protected int inputNum() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자 형태를 입력해주세요");
		}
		return num;
	}
	
}
