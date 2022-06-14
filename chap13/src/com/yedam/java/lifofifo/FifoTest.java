package com.yedam.java.lifofifo;

import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();
		// linkedlist는 다양한 인터페이스를 구현하고 있고 그 중 하나가 queue이다
		// queue인터페이스만 사용하도록 제한하기 위해서 queue타입으로 선언한다.
		
		que.offer(100);
		que.offer(50);
		que.offer(500);
		que.offer(10);
		
		while(!que.isEmpty()) {
			int value = que.poll(); // 쓰는 순간 값이 사라진다.
			System.out.println("\t queue 수 : " + que.size());
			System.out.println("꺼내온 값" + value); // 넣은 순서대로 나온다
		}
		
		System.out.println(que.isEmpty());
	}

}
