package com.yedam.java.example1;

// 고객 정보를 저장하는 저장소
public class Repo {
	
	// repo가 싱글톤일때는 객체는 하나만 생성하고 데이터 공유하게됨
	// 필드
	private Customer[] dataList;
	private int listIndex;

	// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}

	// 메소드
	// 게터 세터

	
	// 등록
	public void insert(Customer customer) { 
		// 매개변수를 이렇게 받겠다는것 실제로 넣어준것아니라서 객체 생성안해도 오류없다
		dataList[++listIndex] = customer;
	}

	// 수정
	public void update(Customer customer) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customer.getCustomerId()) {
				dataList[i] = customer;
				// 값 한번에 업데이트, set으로 하나하나씩 설정할 필요 없다
			}
		}
	}

	// 삭제
	public void delete(int customerId) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				// 같은 ID인지 확인
				// 매개변수로 Customer customer를 받은게 아니라서 customer.getCustomerID()못쓴다
				dataList[i] = null;
				// null은 객체를 지우는게 아니라 참조끊는것
				// 배열안에 있는 객체 전부 지우기
			}
		}
		// 데이터 삭제
		cleanDateList();
	}

	// 밖에서 호출 안할꺼라서 private
	private void cleanDateList() {
		// 데이터 정리(중간중간 null값이 있는거 삭제하기 위해서)
		// 리스트, 인덱스 그대로 복사
		Customer[] temp = dataList;
		int tempIndex = listIndex;

		// 기존데이터 초기화
		this.dataList = new Customer[100];
		this.listIndex = -1;

		// 초기화한 데이터배열에 temp에 복사해놓은 데이터 넣기
		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] == null) {
				continue;
			} else {
				dataList[++listIndex] = temp[i];
			}
		}
	}

	// 조회
	public Customer[] selectAll() {
		return dataList;
	}
	// 배열 자체를 넘겨주기

	public Customer selectOne(int customerId) {
		// selected된 유저의 정보 전달
		Customer selected = null;
		for(int i = 0; i <= listIndex; i++) {
			if(dataList[i].getCustomerId() == customerId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
		// selected된 customer의 정보 모두를 보고싶어서 selected로 선언함
		
	}
}