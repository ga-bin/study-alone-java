package com.yedam.java.pack;

public interface Access {

	// 입력
	public void insert(Player player);

	// 전체조회
	public Player[] selectAll();

	// 1건조회
	public Player selectOne(String name);

	// 수정
	public void update(Player player);

	// 삭제
	public void delete(String name);
}
