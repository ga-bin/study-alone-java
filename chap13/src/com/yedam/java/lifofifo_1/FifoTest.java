package com.yedam.java.lifofifo_1;

import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(100);
		que.offer(50);
		que.offer(500);
		que.offer(10);
		
		while(!que.isEmpty()) {
			int value = que.poll();
			System.out.println("\t queue 수 : " + que.size());
			System.out.println("꺼내온 값" + value);
		}
		
		System.out.println(que.isEmpty());
		
	}

}
