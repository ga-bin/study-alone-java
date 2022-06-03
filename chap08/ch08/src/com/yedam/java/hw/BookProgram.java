package com.yedam.java.hw;

public interface BookProgram {
	
	// 메뉴출력
	public void menuPrint();

	// 정보입력
	public void inputInfo(BookAccess bookAccess);
	
	// 전체조회
	public void printAll(BookAccess bookAccess);
	
	// 검색
	public void searchBook(BookAccess bookAccess);
	
	// 분석
	public void Analysis(BookAccess bookAccess);
	
}
