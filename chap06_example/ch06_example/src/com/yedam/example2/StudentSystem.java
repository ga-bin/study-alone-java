package com.yedam.example2;

public class StudentSystem {

	public static void main(String[] args) {
		Student kim = new Student("kim");
		Student lee = new Student("lee");
		Student park = new Student("park");
		System.out.println(Student.getSerialNum());
		Student son = new Student("son");
		Student hwang = new Student("hwang");
		Student choi = new Student("choi");

		System.out.println(Student.getSerialNum());
		System.out.println(kim.getName() + "의 학번 " + kim.getStudentId());
		System.out.println(son.getName() + "의 학번 " + son.getStudentId());
		System.out.println(choi.getName() + "의 학번 " + choi.getStudentId());

	}

}
