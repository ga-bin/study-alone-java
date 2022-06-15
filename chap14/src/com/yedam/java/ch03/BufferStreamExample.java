package com.yedam.java.ch03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreamExample {
		
		// bufferstream, bufferreader
		// bufferstream은 거의 필수적으로 사용함
		// 1초에 1개 데이터 전달할 것은 buffer에 모았다가 전달한다
		// stream이 외부에 연결되는 횟수를 줄인다.]
		// 사물인터넷 -> 외부에 있는 프로그램들 끼리 통신하는 과정에서의 속도차를 줄이기 위해서
		// 각각의 입출력 스트림안에 buffer를 만들어 외부와 통신하는 횟수를 줄이면 
		// 외부의 요청을 받고 응답하는 시간이 줄어든다.
	
	public static void main(String[] args) throws Exception {
		// buffer 스트림이 없는 경우
		// 내가 사용하고자 하는 파일의 위치 확인
		String originalFilePath1 = BufferStreamExample.class.getResource("KakaoTalk_20220615_101337275.jpg").getPath();
		// 물리적인 위치로 경로 지정하는 경우 파일위치 바뀌면 코드 어그러짐
		// 이렇게 사용하면 위치 옮겨도 정보 따라온다.
		// bufferstreamexample.class -> bufferstreamexample의 위치정보
		// 내가 찾고자하는 파일정보 요구 get resource, 그 위치요구 get path
		// 복사하기
		String targetFilePath1 = "D:/dev/temp/targetFile1.jpg";
		
		// 입력스트림, 출력스트림 만들기
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(targetFilePath1);
		
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼를 사용하지 않았을 때 : " + nonBufferTime + "ns");
		
		fis1.close();
		fos1.close();
		
		// buffer 스트림이 있는 경우
		String originalFilePath2 = BufferStreamExample.class.getResource("KakaoTalk_20220615_101337436.jpg").getPath();
		
		String targetFilePath2 = "D:/dev/temp/targetFile1.jpg";
		
		// 입력스트림, 출력스트림 만들기
		InputStream fis2 = new FileInputStream(originalFilePath2);
		OutputStream fos2 = new FileOutputStream(targetFilePath2);
		
		// 버퍼스트림 만들기
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long BufferTime = copy(bis, bos);
		System.out.println("버퍼를 사용했을 때 : " + BufferTime + "ns");
		
		fis2.close();
		fos2.close();
	}
	
	
	static int data = -1;
	public static long copy(InputStream is, OutputStream os) throws Exception {
		// 읽어들여서 바로 복사하기
		long start = System.nanoTime();
		while(true) {
			data = is.read();
			if (data == -1) break;
			os.write(data);
		}
		long end = System.nanoTime();
		return (end - start);
		
		
	}

}
