package com.yedam.java.hw;

public interface BookAccess {
	
	//등록
	public void insert(Book book);
	//수정
	public void update(Book book);
	//삭제
	public void delete(String name);
	//전체조회
	public Book[] selectAll();
	//단건조회
	public Book selectOne(String name);
}
