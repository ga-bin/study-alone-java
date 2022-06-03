package com.yedam.java.example;

public interface Scheduler {
	// 고객센터에서 돌아가는 정책에 대한 정의
	// 직원이 고객을 할당받는 방식
	public void getNextCall();
	// 관리자가 직접 대기열을 관리
	public void sendCallToAgent();	
}
