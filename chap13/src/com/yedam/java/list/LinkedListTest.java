package com.yedam.java.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
//		2. linkedlist(클래스)
//		- 인덱스가 아니라 번지로 가지고 있는 값을 찾는다.
//		arraylist와 linkedlist는 중간에 데이터가 변경될때 속도차이 있음
//		중간에 데이터를 빈번하게 수정하는 경우에는 arraylist보다 linkedlist가 더 낫다.
// 		(앞뒤로 데이터 넣는 경우에는 상관없음)
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long start;
		long end;
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("ArrayList 걸린시간 : " + 
		(end - start) + "ns");
		
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
			// 인덱스 0번에 중간에 계속 추가하는 경우
		}
		end = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + 
		(end - start) + "ns");
	}

}
