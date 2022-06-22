package com.yedam.app.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
	Scanner sc = new Scanner(System.in);
	BookDAO bDAO = BookDAO.getInstance();

	public BookManagement() {
		while (true) {
			menuPrint();
			int menuNum = selectMenu();
			if (menuNum == 1) {
				// 전체조회
				showAllInfo();
			} else if (menuNum == 2) {
				// 단건조회
				showInfo();
			} else if (menuNum == 3) {
				// 제목에 따라 책 검색
				findBook();
			} else if (menuNum == 4) {
				// 대여 가능
				showCanBorrowBooks();
			} else if (menuNum == 5) {
				borrowBook();
			} else if (menuNum == 6) {
				returnBook();
			} else if (menuNum == 7) {
				insertBook();
			} else if (menuNum == 9) {
				exit();
				break;
			} else {
				showInputError();
			}
			

		}
	}
	
	private void menuPrint() {
		System.out.println("========================================================================================");
		System.out.println("1. 전체 조회 | 2. 단건 조회 | 3. 내용 검색 | 4. 대여 가능 | 5. 책 대여 | 6. 책 반납 | 7. 책 등록 | 9. 종료");
		System.out.println("========================================================================================");
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void showInputError() {
		System.out.println("메뉴에 있는 숫자를 입력해 주세요");
	}
	
	private int inputNum() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해 주세요");
		}
		return num;
	}
	
	private int selectMenu() {
		System.out.println("메뉴를 입력하세요");
		return inputNum();
	}
	
	private void showAllInfo() {
		List<Book> bookList = new ArrayList<>();
		bookList = bDAO.selectAll();
		for (Book book : bookList) {
			System.out.println(book);
		}
	}
	
	private void showInfo() {
		System.out.println("자료를 조회할 책 이름을 입력하세요");
		String bookName = sc.nextLine();
		Book book = bDAO.selectOne(bookName);
		
		if (book != null) {
		System.out.println(book);
		} else {
			System.out.println("등록된 책정보가 없습니다.");
		}
		
	}
	
	private void findBook() {
		List<Book> list = new ArrayList<>();
		System.out.println("책 내용의 일부를 입력하세요");
		list = bDAO.selectContent(sc.nextLine());
		if (list.size() == 0) {
			System.out.println("조회하신 내용의 책은 없습니다.");
			return;
		} else {
		for (Book book : list) {
			System.out.println(book);
			}
		}
		
	}
	
	private void showCanBorrowBooks() {
		List<Book> list = new ArrayList<>();
		list = bDAO.canBorrow();
		
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	private void borrowBook() {
		List<Book> list =new ArrayList<>();
		
		list = bDAO.selectAll();
		
		System.out.println("대출하실 책 제목을 입력하세요");
		String bookName = sc.nextLine();
		
		for(int i = 0; i < list.size(); i++) {
			if (bookName.equals(list.get(i).getBookName())) {
				bDAO.updateBorrowBook(bookName);
			} else {
				System.out.println("등록된 책이 아닙니다.");
				return;
			}
		}
		
		
		
	}
	
	private void returnBook() {
		System.out.println("반납하실 책 제목을 입력하세요");
		String bookName = sc.nextLine();
		Book book = bDAO.selectOne(bookName);
		if (book == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		} else {
		bDAO.updateReturnBook(bookName);
		}
	}
	
	private void insertBook() {
		Book book = inputAll();
		bDAO.insertBook(book);
	}
	
	private Book inputAll() {
		Book book = new Book();
		System.out.println("책 제목>");
		book.setBookName(sc.nextLine());
		System.out.println("책 저자");
		book.setBookWriter(sc.nextLine());
		System.out.println("책 내용");
		book.setBookContent(sc.nextLine());
		return book;
	}
}
