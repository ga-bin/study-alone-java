package com.yedam.java.hw;

public class BookRepo implements BookAccess {

	private static BookRepo instance = new BookRepo();

	public static BookRepo getInstance() {
		return instance;
	}

	// field
	private Book[] bookList;
	private int listIndex;

	// constructor
	private BookRepo() {
		init();
	}

	// method

	private void init() {
		bookList = new Book[100];
		listIndex = -1;
	}

	@Override
	public void insert(Book book) {
		bookList[++listIndex] = book;
	}

	@Override
	public void update(Book book) {
		for (int i = 0; i <= listIndex; i++) {
			if (bookList[i].getIsbn() == book.getIsbn()) {
				bookList[i] = book;
			}
		}
	}

	@Override
	public void delete(String name) {
		for (int i = 0; i <= listIndex; i++) {
			if (bookList[i].getName().equals(name)) {
				bookList[i] = null;
			}
		}
		cleanData();
	}

	private void cleanData() {
		Book[] temp = bookList;
		int tempIndex = listIndex;

		init();

		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] != null) {
				bookList[++listIndex] = temp[i];
			}
		}
	}

	@Override
	public Book[] selectAll() {
		Book[] list = new Book[listIndex + 1];
		for (int i = 0; i <= listIndex; i++) {
			list[i] = bookList[i];
		}

		return list;
	}

	@Override
	public Book selectOne(String name) {
		Book selected = null;

		for (int i = 0; i <= listIndex; i++) {
			if (bookList[i].getName().equals(name)) {
				selected = bookList[i];
				break;
			}
		}

		return selected;
	}

}
