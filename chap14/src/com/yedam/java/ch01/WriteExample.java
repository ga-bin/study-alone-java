package com.yedam.java.ch01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {

	
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("d:/dev/temp/test1.db"); // 스트림 생성 
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		// outstream에 값을 넘겨준다.
		// write의 매개변수는 int타입 but 출력 스트림으로 넘어갈때는 byte로 전달된다.(p.594)
		// 항상 byte로 보낸다고 생각하자
		
		os.write(a);
		os.write(b);
		os.write(c);
		
		os.flush(); // 남아있는 출력 데이터 밀어내기
		os.close(); // 스트림 연결 종료 - 닫으면 새로 만들어야한다.
		
		os = new FileOutputStream("d:/dev/temp/test2.db");
		
		// 이런식으로 길게 배열을 전달하는 것도 가능함
		byte[] array1 = { 10, 20, 30 };
		os.write(array1);
		
		os.flush();
		os.close();
		
		os = new FileOutputStream("d:/dev/temp/test3.db");
		
		byte[] array2 = { 10, 20, 30, 40, 50 };
//		os.write(array2, 3, 2); // 내가 원하는 값 지정해서넘기기 인덱스 3부터 2개
		os.write(array2);
		
		os.flush();
		os.close();
	}

}
