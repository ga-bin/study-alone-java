package com.yedam.java.example2;

public class StudentRepo implements Access {

	// 싱글톤
	private static StudentRepo instance = new StudentRepo();

	private StudentRepo() {
		init();
	}

	public static StudentRepo getInstance() {
		return instance;
	}

	// 실제사용
	private Student[] dataList;
	private int listIndex;

	private void init() {
		// 기존 필드 초기화
		dataList = new Student[100];
		listIndex = -1;
	}

	@Override
	public void insert(Student student) {
		dataList[++listIndex] = student;
	}

	@Override
	public void update(Student student) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == student.getId()) {
				dataList[i] = student;
			}
		}
	}

	@Override
	public void delete(int studentId) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == studentId) {
				dataList[i] = null;
			}
		}
		cleanDataList();
	}

	private void cleanDataList() {
		// 기존 데이터 -> 임시변수
		Student[] temp = dataList;
		int tempIndex = listIndex;

		init();

		// 임시변수에서 데이터만 기존필드로 복사
		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] == null) {
				continue;
			} else {
				dataList[++listIndex] = temp[i];
			}
		}

	}

	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIndex + 1];
		for (int i = 0; i < list.length; i++) {
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
