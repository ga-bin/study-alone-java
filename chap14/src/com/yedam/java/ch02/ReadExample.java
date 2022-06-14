package com.yedam.java.ch02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("d:/dev/temp/test7.db");
		
		// int타입으로 읽어오기
		while(true) { // 파일의 크기를 모르기 때문에 while문 사용
			int data = reader.read();
			if(data == -1) break;
			System.out.println((char)data);
		}
		
		reader.close();
		System.out.println();
		
		reader = new FileReader("d:/dev/temp/test1.db");
		
		while(true) { // 파일의 크기를 모르기 때문에 while문 사용
			// byte타입인데도 int로 읽어서 char로 출력가능
			int data = reader.read();
			if(data == -1) break;
			System.out.println((char)data);
		}
		
		reader.close();
		System.out.println();
		// 읽어들이는 것은 byte타입(0, 1)
		// 인간이 데이터를 다룰때 편의에 의해 int, char, string등으로 파일을 만들고
		// 읽어들일 때 컴퓨터는 byte타입으로 읽는다.
		
		reader = new FileReader("d:/dev/temp/test8.db");
		
		char[] buffer = new char[100]; // char타입 배열은 기본값으로 공백이 들어가 있다.
		
		while(true) {
			int readCharNum = reader.read(buffer); // 매개변수 있을 때 읽어들인
			// 값의 개수를 반환한다.
			if(readCharNum == -1) break;
			for(int i = 0; i < readCharNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println(); // buffer에 abc
		}
		reader.close();
		
		reader = new FileReader("d:/dev/temp/test10.txt");
		
		int readCharNum = reader.read(buffer, 5, 10); // buffer에 abc (공백)(공백)하고 5번 인덱스부터 10글자 넣은
		
		for(int i = 0; i < (5+readCharNum); i++) {
			System.out.print(buffer[i]);
		}
		
		reader.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
