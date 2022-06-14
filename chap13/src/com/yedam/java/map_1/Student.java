package com.yedam.java.map_1;

import java.util.Objects;

public class Student {
	public int sno;
	public String name;
	
	Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + sno;
	}

	@Override
	public boolean equals(Object obj) {
		// 같은 타입인지 확인
		if (obj instanceof Student) {
			Student st = (Student) obj;
			return name.equals(st.name) && sno == st.sno;
		}
		return false;
	}
	
	
}
