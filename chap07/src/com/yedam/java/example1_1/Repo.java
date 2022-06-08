package com.yedam.java.example1_1;

public class Repo {
	// 필드
	private Customer[] dataList;
	private int listIndex;
	
	
	// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}
	
	// 메소드
	
	// 등록
	// 외부에서 customer객체를 생성해서 매개변수로 가져올 것이다
	public void insert(Customer customer) {
		 dataList[++listIndex] = customer;
	}
	
	// 수정
	public void update(Customer customer) {
		for(int i = 0; i < listIndex+1; i++) {
			if(dataList[i].getCustomerId() == customer.getCustomerId()) {
				dataList[i] = customer;
			}
		}
	}
	
	// 삭제
	public void delete(int customerId) {
		for (int i = 0; i < listIndex+1; i++) {
			if(dataList[i].getCustomerId() == customerId) {
				dataList[i] = null;
			}
		}
		cleanDateList();
	}
	
	
	// 데이터 정리
	private void cleanDateList() {
		// 리스트, 인덱스 그대로 복사
		Customer[] temp = dataList;
		int tempIndex = listIndex;
		
		// 기존데이터 초기화
		dataList = new Customer[100];
		listIndex = -1;
		
		// 초기화한 데이터배열에 temp에 복사해 놓은 데이터 넣기
		for (int i = 0; i < tempIndex+1; i++) {
			if (temp[i] == null) {
				continue;
			} else {
				dataList[++listIndex] = temp[i];
			}
		}
	}
	
	
	// 조회
	// 전체조회
	public Customer[] SelectAll() {
		return dataList;
	}
	
	
	// 특정 유저정보만 조회
	public Customer selectOne(int customerId) {
		// selected된 유저의 정보 전달
		Customer selected = null;
		for (int i = 0; i < listIndex+1; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}

}
