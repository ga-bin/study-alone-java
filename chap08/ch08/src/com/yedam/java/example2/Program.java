package com.yedam.java.example2;

public interface Program {

	// 메뉴 출력
	public void menuPrint();

	// 정보입력
	public void inputInfo(Access access);

	// 전체정보 출력
	public void printAllInfo(Access access);

	// 특정조건 정보출력
	public void printInfo(Access access);

	// 분석
	public void printRepot(Access access);

}
