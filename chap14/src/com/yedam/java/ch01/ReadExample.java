package com.yedam.java.ch01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("d:/dev/temp/test1.db");

		// outputstream에서는 byte타입
		// inputstream은 int타입으로 읽어들인다.

		// while문쓰는 이유는 파일 크기 모르기 때문
		while (true) { // 파일에 있는 모든 글자를 읽어들이기 위해서
			int data = is.read(); // 읽어들인 값
			if (data == -1)
				break;
			// read를통해서 읽다가 마지막에 도달하면 -1을 리턴함, 읽을게 없음
			System.out.println(data);
		}

		is.close();
		System.out.println("============================");
		System.out.println("test2.db");
		is = new FileInputStream("d:/dev/temp/test2.db");
		// 배열의 값을 읽어오는 경우
		byte[] buffer = new byte[100];
		
		System.out.println("test3.db");
		is = new FileInputStream("d:/dev/temp/test3.db");
		while (true) {
			int readByteNum = is.read(buffer);
			// read의 매개변수가 없는 경우에는 return값이 내가 읽어들인 값
			// read의 매개변수가 있는 경우에는 몇 개의 값을 읽어들였는지 return
			if (readByteNum == -1)
				break;
			for (int i = 0; i < readByteNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		is.close();

		// 기존의 배열에 이어서 쓰고자 하는 경우
		System.out.println("============================");

		is = new FileInputStream("d:/dev/temp/test3.db"); // 10, 20, 30, 40, 50
		// 배열의 값을 읽어오는 경우
		int readByteNum = is.read(buffer, 3, 2); // test3에서 2개의 값을 가져와서 인덱스 3의 자리부터 채운다
		// 10, 20, 30, 10, 20으로 바뀐다
		
		for(int i = 0; i < (3+readByteNum); i++) {
			System.out.println(buffer[i]);
		}
		
		is.close();

	}
}
