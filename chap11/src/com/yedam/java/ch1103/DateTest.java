package com.yedam.java.ch1103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); // 월 MM대문자
		
		String result = sdf.format(now);
		String result1 = sdf.format(new Date());
		System.out.println(result);
		System.out.println(result1);
		
		
	}
}
