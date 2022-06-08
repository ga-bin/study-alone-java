package com.yedam.java.pack;

public interface Program {

	public void menuPrint();

	// 1.입력
	public void inputInfo(Access access);

	// 2.전체조회
	public void printAll(Access access);

	// 3.검색
	public void search(Access access);

	// 4.분석
	public void analyze(Access access);

	// 5.수정
	// public void changeData();

	// 6.삭제
	// public void deleteData();
}
