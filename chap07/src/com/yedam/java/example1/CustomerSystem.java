package com.yedam.java.example1;

import java.util.Scanner;

public class CustomerSystem {
	// 필드
	private Repo repo = new Repo();
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public CustomerSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 선택
			int menuNo = menuSelect();
			// 메뉴1 - 회원가입
			if (menuNo == 1) {
				signUp();

			} // 메뉴2 - 회원정보조회
			else if (menuNo == 2) {
				myPage();
			} // 메뉴3 - 결제시 금액
			else if (menuNo == 3) {
				payInfo();

			} else if (menuNo == 4) {
				exit();
			}

		}
	}

	// 메소드

	void menuPrint() {
		System.out.println("======================================");
		System.out.println("1.회원가입 | 2.회원정보 | 3. 결제금액 | 4. 종료");
		System.out.println("======================================");
	}

	int menuSelect() {
		System.out.println("메뉴>");
		return Integer.parseInt(sc.nextLine());
	}

	void signUp() {
//		Customer info = inputAll();
		// 회원정보 입력
		Customer info = inputAll();
		// 가입
		repo.insert(info);
	}

	private Customer inputAll() {
		// 회원정보입력
		System.out.println("아이디>");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("이름>");
		String name = sc.nextLine();
		// 등급나누기
		int selected = selectGrade();
		Customer customer = null;
		switch (selected) {
		case 1:
			customer = new Customer(id, name);
			break;
		case 2:
			customer = new Gold(id, name);
			break;
		case 3:
			customer = new Vip(id, name, "이한나");
			break;
		}
		return customer;
	}

	int selectGrade() {
		// 등급 선택
		System.out.println("1.SILVER | 2.GOLD | 3.VIP");
		System.out.println("---------------------------");
		int selected = Integer.parseInt(sc.nextLine());
		return selected;
	}

	void myPage() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		System.out.println(info.showCustomerInfo());

	}

	void payInfo() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		// selected된 customer의 정보 전부 info안에 있음

		System.out.println("구매 금액");
		int price = Integer.parseInt(sc.nextLine());
		int pay = info.calcPrice(price);
		System.out.println("결제금액 : " + pay);
	}

	void exit() {
		System.out.println("프로그램 종료");
	}

	int inputOne() {
		System.out.println("고객 아이디>");
		return Integer.parseInt(sc.nextLine());
	}
}
