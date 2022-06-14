package com.yedam.java.ch02_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("d:test7");
		
		while(true) {
			int data = reader.read();
			if(data == -1) break;
			System.out.println((char)data);
		}
		
		reader.close();
		System.out.println();
		
		reader = new FileReader("d:test1");
		
		while(true) {
			int data = reader.read();
			if(data == -1) break;
			System.out.println((char)data);
		}
		
		reader = new FileReader("d:test8");
		
		char[] buffer = new char[100];
		
		while(true) {
			int readCharNum = reader.read(buffer);
			if (readCharNum == -1) break;
			for(int i = 0; i < readCharNum; i++) {
				System.out.println(buffer[i]);
			}
			
			System.out.println();
		}
		reader.close();
		
		reader = new FileReader("d:test10");
		int readCharNum = reader.read(buffer, 5, 10);
		
		for(int i = 0; i < (5+readCharNum); i++) {
			System.out.print(buffer[i]);
		}
		reader.close();
	}

}
