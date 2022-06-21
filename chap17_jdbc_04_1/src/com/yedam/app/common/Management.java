package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.deal.ReceivingGoodsDAO;
import com.yedam.app.deal.TakeOutGoodsDAO;
import com.yedam.app.product.ProductDAO;

public class Management {
	
	protected ProductDAO pDAO = ProductDAO.getInstance();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getInstance();
	protected TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();
	protected Scanner sc = new Scanner(System.in);
	
	public void run() {
		while(true) {
			menuPrint();
			int menuNum = selectMenu();
			if (menuNum == 1) {
				// 제품 정보 관리
			} else if (menuNum == 2) {
				// 제품 관리
			} else if (menuNum == 2) {
				
			} else if (menuNum == 9) {
				// 프로그램 종료
				exit();
				break;
			} else {
				showInputError();
			} 
		}
	}
	
	protected void menuPrint() {
		System.out.println("===========================================");
		System.out.println("1. 제품 정보 관리     2. 제품 관리    9. 프로그램 종료");
		System.out.println("============================================");
	}
	
	protected void exit() {
		System.out.println("프로그램 종료");
	}
	
	protected void showInputError() {
		System.out.println("메뉴에 있는 숫자를 입력하세요");
	}
	
	protected int inputNum() {
		int num = 0;
		try {
		System.out.println("숫자를 입력하세요");
		} catch(NumberFormatException e) {
			System.out.println("숫자 형식이 아닙니다.");
		}
		return num;
	}
	
	protected int selectMenu() {
		System.out.println("메뉴를 입력하세요");
		return inputNum();	
		}
}
