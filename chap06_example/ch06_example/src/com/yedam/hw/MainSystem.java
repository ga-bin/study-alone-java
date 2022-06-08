package com.yedam.hw;

import java.util.Scanner;

public class MainSystem {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		ProductManage pm = new ProductManage();

		while (run) {

			System.out.println("1. 상품 수입력 | 2. 상품 이름, 가격 입력 | 3. 제품별 가격조회 | 4. 제품정보 분석 | 5. 종료");
			System.out.print("선택> ");
			int selecNo = Integer.parseInt(sc.nextLine());
			if (selecNo == 1) {
				System.out.print("상품수> ");
				pm.setProductNum(Integer.parseInt(sc.nextLine()));
			} else if (selecNo == 2) {
				System.out.print("상품명> ");
				String name = sc.nextLine();
				System.out.print("상품가격> ");
				int price = Integer.parseInt(sc.nextLine());
				pm.setProduct(name, price);
			} else if (selecNo == 3) {
				pm.printProduct();
			} else if (selecNo == 4) {
				pm.showHigh();
			} else if (selecNo == 5) {
				run = false;
				System.out.println("프로그램 종료");
			}else {
				System.out.println("1~5사이 숫자 입력");
			}

		}
		sc.close();

	}

}
