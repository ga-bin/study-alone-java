package com.yedam.java.lifofifo;

import java.util.Stack;

public class LifoTest {

	public static void main(String[] args) {
		Stack<Integer> box = new Stack<>();

		box.push(100);
		box.push(50);
		box.push(500);
		box.push(10);
		
		while(!box.isEmpty()) {
			int value = box.pop(); // pop을 쓰면 꺼내온 즉시 값이 사라진다. 재사용불가능
			System.out.println("box 값 : " + box.size());
			System.out.println("꺼내온 값 : " + value);
			// 제일 마지막에 들어간 값부터 나온다. lifo
			
		}
		
		System.out.println(box.isEmpty());
	}

}
