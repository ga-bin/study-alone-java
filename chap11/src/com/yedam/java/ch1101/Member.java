package com.yedam.java.ch1101;

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// 논리적으로 동등한지
		// 다른 객체라도 타입과 내부 객체가 같으면 같다고 우리가 만드는 것
		
		// 1. 동일한 타입인지 먼저 확인
		if (obj instanceof Member) {
			Member member = (Member) obj;
			// 2. 내부 필드 값이 같은지 확인
			if(id.equals(member.id)) { // id가 Stringtype이어서 equals사용해야한다ㅂㅁ
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
		// string은 object를 상속받으면서 hashcode와 equals를 overrideing해놨다. 땡겨쓰는것.
	}

	@Override
	public String toString() {
		return "id : " + id;
	}
	
	
}
