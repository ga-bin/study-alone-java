package com.yedam.java.set_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");

		System.out.println("총 객체 수 " + set.size());
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		System.out.println();
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		for(String data : set) {
			System.out.println("\t" + data);
		}
		
		System.out.println();
		set.clear();
		
		if(set.isEmpty()) {
			System.out.println("비어있음");
		}
	}

}
