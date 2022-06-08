package com.yedam.example2;

public class Student {

	// field

	private static int serialNum = 1000;
	private int studentId;
	private String name;

	public Student(String name) {
		this.name = name;
		this.studentId = Student.serialNum++;
	}
	
	
	
	public static int getSerialNum() {
		return serialNum;
	}
	
	
	public int getStudentId() {
		return this.studentId;
	}
	
	public String getName() {
		return this.name;
	}
	

}
