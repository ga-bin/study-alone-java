package com.yedam.java.hw;

import java.util.Scanner;

public class BookSystem implements BookProgram {

	private Scanner sc = new Scanner(System.in);

	@Override
	public void menuPrint() {
		System.out.println("==============================================");
		System.out.println(" 1.책정보입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.종료");
		System.out.println("==============================================");
	}

	@Override
	public void inputInfo(BookAccess bookAccess) {
		Book info = inputAll();
		bookAccess.insert(info);
	}

	private Book inputAll() {
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("가격 > ");
		int price = Integer.parseInt(sc.nextLine());

		return new Book(name, price);
	}

	@Override
	public void printAll(BookAccess bookAccess) {
		Book[] all = bookAccess.selectAll();
		for (Book book : all) {
			book.showInfo();
		}
	}

	@Override
	public void searchBook(BookAccess bookAccess) {
		String name = inputName();
		Book book = bookAccess.selectOne(name);
		book.showInfo();
	}

	private String inputName() {
		System.out.print("검색할 책이름 > ");
		return sc.nextLine();
	}

	@Override
	public void Analysis(BookAccess bookAccess) {

		// 가장 비싼 책
		System.out.println("가장 비싼 책 > ");
		Book max = searchMax(bookAccess);
		max.showInfo();

		// 가장 싼 책
		System.out.println("가장 싼 책 > ");
		Book min = searchMin(bookAccess);
		min.showInfo();

		// 1,2 제외 책정보 출력, 평균
		System.out.println("가장 비싼책과 싼책을 제외한 책 목록");
//		printExceptMaxMin(bookAccess);
		double avg = calAvg(bookAccess);
		System.out.println("가장 비싼책과 싼책을 제외한 책 평균 가격");
		System.out.printf("%.2f\n", avg);
	}

	private Book searchMax(BookAccess bookAccess) {
		Book[] list = bookAccess.selectAll();
		Book max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (max.getPrice() < list[i].getPrice()) {
				max = list[i];
			}
		}
		return max;
	}

	private Book searchMin(BookAccess bookAccess) {
		Book[] list = bookAccess.selectAll();
		Book min = list[0];
		for (int i = 1; i < list.length; i++) {
			if (min.getPrice() > list[i].getPrice()) {
				min = list[i];
			}
		}
		return min;
	}

//	private void printExceptMaxMin(BookAccess bookAccess) {
//		Book[] list = bookAccess.selectAll();
//		Book max = searchMax(bookAccess);
//		Book min = searchMin(bookAccess);
//
//		for (int i = 0; i < list.length; i++) {
//			if (list[i] != max && list[i] != min) {
//				list[i].showInfo();
//			}
//		}
//
//	}

	private double calAvg(BookAccess bookAccess) {
		double sum = 0;
		Book[] list = bookAccess.selectAll();
		Book max = searchMax(bookAccess);
		Book min = searchMin(bookAccess);

		for (int i = 0; i < list.length; i++) {
			if (list[i] != max && list[i] != min) {
				list[i].showInfo();
				sum += list[i].getPrice();
			}
		}
		return sum / (list.length - 2);
	}

}
