package com.yedam.java.question;

public abstract class Member {
	// 필드
	static final int GRADE_STANDARD = 1000000; // 등급 기준 : 전원 실적이 100만원 미만
	int record;
	String grade;
	
	// 생성자
	Member(int record) {
		this.record= record;	
		}
	
	void showMemberInfo() {
		// 
		System.out.println("현재 실적은" + this.record + "이며, 회원등급은" + grade + "입니다.");
	}
	
	
	
	// 멤버쉽(골드, 실버)의 인스턴스를 생성하는 메소드
	static Member getMemberShip(int record) {
		Member member = null;
		if (record < GRADE_STANDARD) {
			// 백만원 이하이면 멤버쉽등급 silver
			member = new Silver(record);
		} else if (record >= GRADE_STANDARD) {
			member = new Gold(record);
		}
		return member;
	}
	
	
}
