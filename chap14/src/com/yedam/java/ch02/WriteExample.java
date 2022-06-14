package com.yedam.java.ch02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("d:/dev/temp/test7.db");
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		writer.write(a);
		writer.write(b);
		writer.write(c);
		
		writer.flush();
		writer.close();
		
		writer = new FileWriter("d:/dev/temp/test8.db");
		
		// 캐릭터 타입 배열로 보내기
		char[] array1 = {'A', 'B', 'C'};
		
		writer.write(array1);
		
		writer.flush();
		writer.close();
		
		writer = new FileWriter("d:/dev/temp/test9.db");
		
		// 캐릭터타입 배열 인덱스로 보내기
		char[] array2 = {'A', 'B', 'C', 'D', 'E'};
		writer.write(array2, 3 ,2);
		
		writer.flush();
		writer.close();
		
		// string 타입으로 보내기
		// 보낼때는 string으로 보낼 수 있지만 읽을때는 불가능
		// 무엇을 기준으로 잘라서 string을 읽어야하는지 모른다.
		// char는 2byte로 고정되어있음
		
		writer = new FileWriter("d:/dev/temp/test10.txt");
		
		String str1 = "ABCDE\n";
		String str2 = "abcde";
		
		writer.write(str1);
		writer.write(str2, 3, 2);
		
		writer.flush();
		writer.close();
	}

}
