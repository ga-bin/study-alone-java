package com.yedam.java.map_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class StringTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("신운권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		System.out.println("총 entry수 : " + map.size());
		
		Integer returnVal = map.put("홍길동", 100); // 90
		if (returnVal != null) {
			System.out.println("기존 값 : " + returnVal);
		}
		System.out.println("\t 홍길동 : " + map.get("홍길동"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.remove("홍길동");
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		for(Map.Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
