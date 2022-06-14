package com.yedam.java.list;

import java.util.HashMap;
import java.util.Map;

import com.yedam.java.map.Student;

public class StudentTest {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		// 변수로 선언하는 경우는 굳이 재정의 안해도 된다.
		Student s = new Student(1, "홍길동");
		// map.put(s, 95);
		// map.put(s, 100);
		
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 100);
		
		System.out.println("총 entry 수 : " + map.size());
		System.out.println("학번 : 1, 이름 : 홍길동, 성적 : " + map.get(new Student(1, "홍길동")));
		// System.out.println("학번 : 1, 이름 : 홍길동, 성적 : " + s);
		// 성적은 null -> new연산자를 이용해서 새로운 객체를 만들었기 때문
		// 동일한 객체로 인식하도록 하기 위해 equals와 hashCode를 오버라이딩 해야함.
		// 총 세개의 인스턴스가 생성되는 것은 같다
		// 하지만 hashcode와 equals로 기준을 바꿔서 결과를 변경시킨 것.
	}

}
