package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> list = new Vector<>();
		// 최초로 선언할 때 크기 지정하지 않는다.
		// 제네릭타입이기 때문에 wrapper클래스만 들어간다.
		// 싱글스레드 환경에서는 arraylist와 vector사이의 차이점이 없다.
		
//		3. vector(클래스)
//		- arraylist와 동일한 형태이지만 모두 동기화메소드로 되어 있기 때문에
//		- 멀티스레드 환경에서 하나의 스레드가 vector를 건드리고 잇는 경우 다른 스레드가 접근하지 못한다.
//		- 스레드 환경에서 데이터 일관성을 유지하기 위해서 vector를 사용
//		- 구조가 아예 arraylist와 똑같고 동기화메소드인지만 차이남
		
		
		list.add("Java");
		list.add("jbdc");
		list.add("Servlet/JSP");
		list.add(2,"Database"); // 인덱스 위치 2라고 지정
		list.add("iBATIS");
		
		System.out.println("총 객체 수 " + list.size());
		System.out.println();
		
		String skill = list.get(2); // 2번째 인덱스에 잇는 객체 가지고 오기
		System.out.println("2 : " + skill); // "database"
		System.out.println();
		
		// 리스트에 어떤 객체가 저장되어있는지 전체 조회
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		/*
		 *  0 : Java
			1 : jbdc
			2 : Database
			3 : Servlet/JSP
			4 : iBATIS
		 */
		
		System.out.println();
		list.remove(2);
		// 하고나서 인덱스 1식 떙겨온다.
		// 인덱스를 이용해서 삭제하는 경우에는 한번 삭제하고 인덱스가 변경된다는 것을 예상하고 삭제해야한다.
		list.remove(2);
		list.remove("iBATIS");
		
		System.out.println();
		for(String data : list) {
			System.out.println(data);
		}
		
		
//		List<Integer> list = new ArrayList<>();
//		
//		ThreadA thA = new ThreadA();
//		thA.setList(list);
//		thA.start();
//		ThreadB thB = new ThreadB();
//		thB.setList(list);
//		thB.start();
//		
		
	}

}
