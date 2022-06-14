package com.yedam.java.map;

import java.util.Objects;
import java.util.function.ObjLongConsumer;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		// 물리적으로 메모리상에 위치하는 곳이 같은지
		// string은 이미 내부 필드값에 의해서 해쉬코드가 생성되기 때문에 
		// string값이 같으면 같은 hash코드를 return 한다.
		// 거기에 학번을 더해 hashcode를 고정한다.
		
		// 해쉬코드는 내부의 값을 각각 숫자로 만들어서 더하면 된다.
		return name.hashCode() + sno;
	}

	@Override
	public boolean equals(Object obj) {
		// 내부에 필드값이 같은지
		if (obj instanceof Student) {
			Student s = (Student)obj;
			return name.equals(s.name) && (sno == s.sno);
		}
		return false;
//		
	}
	
	
}
