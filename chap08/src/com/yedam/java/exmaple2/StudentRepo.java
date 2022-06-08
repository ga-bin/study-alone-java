package com.yedam.java.exmaple2;

public class StudentRepo implements Access {
	// 싱글톤으로 저장소 구현
	private static StudentRepo instance = new StudentRepo();
	// 자기자신의 객체 생성
	// 외부에서 접근해서 생선한 인스턴스 건드리지 않도록 private로 만들어야한다.
	
	
	private StudentRepo() {
		// 생성자 호출 막기
		init();
	}
	
	public static StudentRepo getInstance() {
		return instance;
		// 외부에서 인스턴스에 접근하기 위해서는 클래스명을 통해서 getInstance라는 메소드 호출
	}
	
	// 실제 사용 필드 및 메소드
	private Student[] dataList;
	private int listIndex;
	
	
	@Override
	public void insert(Student student) {
		dataList[++listIndex] = student;
		
	}

	@Override
	public void update(Student student) {
		for(int i = 0; i <= listIndex; i++) {
			if(dataList[i].getId() == student.getId()) {
				dataList[i] = student;
			}
		}
	}

	@Override
	public void delete(int studentId) {
		for(int i = 0; i <= listIndex; i++) {
			if(dataList[i].getId() == studentId) {
				dataList[i] = null;
			}
		}
		cleanDataList();

	}
	
	private void cleanDataList() {
		// 기존데이터 -> 임시변수
		Student[] temp = dataList;
		int tempIndex = listIndex;
		// 기존 필드 초기화
		init();
		
		// 임시변수에서 데이터만 기존 필드로 복사
		for(int i = 0; i <= tempIndex; i++) {
//			if (temp[i] == null) {
//				continue;
//			}
//			dataList[++listIndex] = temp[i];
//		}
			if (temp[i] != null) {
				dataList[++listIndex] = temp[i];
			}
		}
	}
	
	// 기존 필드 초기화
	private void init() {
		dataList = new Student[100];
		listIndex = -1;
	}
	
	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIndex+1];
		// 새로 생기는 배열의 길이는 listIndex보다 1크다
		// length는 index+1
		for(int i = 0; i < list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Student selectOne(int studentId) {
		Student selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == studentId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}

}
