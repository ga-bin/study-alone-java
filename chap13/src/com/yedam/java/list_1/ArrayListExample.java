package com.yedam.java.list_1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("java");
		list.add("jbdc");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		System.out.println("총 객체 수 " + list.size());
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2" + skill);
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
		System.out.println();
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		System.out.println();
		for(String data : list) {
			System.out.println(data);
		}
	}
}
