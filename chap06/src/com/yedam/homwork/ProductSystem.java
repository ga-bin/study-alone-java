package com.yedam.homwork;

public class ProductSystem {
	// 필드
	private Product[] list; // 상품길이 담을 배열 만들기
	private int index; // 상품 수 입력할 메소드
	
	// 생성자
	public ProductSystem() {
		index = -1;
	}
	
	// 메소드
	// 전체 컨트롤 할 클래스 만들기
			// 1. 상품 수 입력해서 배열 만들고 길이 설정할 메소드
			// 2. 상품 및 가격 입력할 메소드
			// 만들어놓은 게터, 세터 사용하기
			// 3. 제품별 가격 출력할 메소드
			// for문 이용
			// 상품명 : 가격 형태로 출력
			// 4. 분석
			// 최고가 가지는 제품 출력할 메소드 return으로 최고가 제품 빼기
			// 최고가 제외한 제품들의 총합 구할 메소드
	
	// 1. 상품 수 입력해서 배열 만들고 길이 설정할 메소드
	public void setArraySize(int size) { // size값은 실행 메소드 1번에서 scan으로 받아오자
		list = new Product[size];
	}
	
	// 2. 상품 및 가격 입력할 메소드
	// 생성되어 있는 배열에다가 값 넣기
	
	public void putProduct(String name, int price) {
		list[++index].setName(name);
		produ.setPrice(price);
		product
		 = new Product();
	}
//	private Product[] list; // 상품명을 입력받아야 되기 때문에 배열의 데이터타입이 달라진다
//	private int index; // 실제로 몇개의 값 입력받는지 알고싶어서
//	
//	public ProductSystem() {
//		index = -1;
//	}
//	
//	
//	// 1. 상품 수 입력
//	public void setListSize(int size) {
//		list = new Product[size];
//	}
//	
//	
//	// 2. 상품 및 가격 입력
//	public void putProduct(String name, int price) {
//		Product product = new Product();
//		product.setName(name);
//		product.setPrice(price);
//		
//		list[++index] = product;
//	}
//	// 3. 제품별 가격 출력
//	// 4. 분석
}
