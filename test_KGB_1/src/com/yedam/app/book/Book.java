package com.yedam.app.book;

public class Book {
	String bookName;
	String bookWriter;
	String bookContent;
	// 0대여가능 1대여불가능(대여중)
	int canBorrow;
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public int getCanBorrow() {
		return canBorrow;
	}
	public void setCanBorrow(int canBorrow) {
		this.canBorrow = canBorrow;
	}
	
	@Override
	public String toString() {
		String content = "";
		content += ("책 제목 :" + bookName + ", 저자명 : " + bookWriter + ", 내용 :" + bookContent + ", 대여 여부 : ");
		if (canBorrow == 0) {
			content += "대여가능";
		} else {
			content += "대여중";
		}
		return content;
	}
}
