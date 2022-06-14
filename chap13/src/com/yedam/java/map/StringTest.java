package com.yedam.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class StringTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// map.put은 새로운 키일 경우 null을 리턴하고, 기존 값이 있을 경우 새로운 값을 넣고 기존 값을 return 한다.
		// set컬렉션은 기존의 값이 튕겨나온다. 값을 넣을때 add로 넣는다 add메소드는 boolean타입을 return한다.
		map.put("신운권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		System.out.println("총 entry 수 : " + map.size());
		// entry는 key클래스, value클래스 두개가 하나에 들어가 있다.
		
		
		Integer returnVal = map.put("홍길동", 100); // 90
		
		if (returnVal != null) {
			System.out.println("기존 값 : " + returnVal);
		}
		System.out.println("\t 홍길동 : " + map.get("홍길동")); // 100
		System.out.println();
		
		// 들어간 값 확인 -> 키를 이용하기 때문에 인덱스 명확하지 않다. // 셋컬렉션을 이용해 값을 확인
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator(); // 반복자 가지고 오기
		while(keyIterator.hasNext()) { // while문으로 key값, value값 가지고오기
			String key = keyIterator.next(); // next는 반본자의 메소드로 컬렉션에서 하나의 객체를 가져온다.
			Integer value = map.get(key); // get은 key값으로 value를 가져온다.
			System.out.println("\t" + key + " : " + value);
		}
		for(String key : keySet) { // or 향상된 for문으로 key값, value값 가지고오기
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.remove("홍길동"); // 키값으로 제거
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); // 엔트리는 map인터페이스 안에 있는 중첩인터페이스라서 map.entry이런식으로 사용한다.
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next(); // 엔트리 먼저 꺼내기
			 
			String key = entry.getKey(); // key값꺼내기
			Integer value = entry.getValue(); // value값 꺼내기
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		for(Map.Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey(); // key값꺼내기
			Integer value = entry.getValue(); // value값 꺼내기
			System.out.println("\t" + key + " : " + value);
		}
		
	}

}
