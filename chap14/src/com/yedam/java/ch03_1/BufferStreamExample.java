package com.yedam.java.ch03_1;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class BufferStreamExample {

	public static void main(String[] args) throws Exception {
		String originalFilePath1 = BufferStreamExample.class.getResource("KakaoTalk_20220615_101337275.jpg").getPath();
		
		String targetFilePath1 = "D:targetFile1.jpg";
		
		// 입력스트림, 출력스트림 만들기
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(targetFilePath1);
		
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼를 사용하지 않았을 때 : " + nonBufferTime + "ns");
		
		fis1.close();
		fos1.close();
		
		String originalFilePath2 = BufferStreamExample.class.getResource("KakaoTalk_20220615_101337275.jpg").getPath();
		
		String targetFilePath2 = "D:targetFile2.jpg";
		
		InputStream fis2 = new FileInputStream(originalFilePath2);
		OutputStream fos2 = new FileOutputStream(targetFilePath2);
		
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long BufferTime = copy(bis, bos);
		System.out.println("버퍼를 사용했을 때 : " + BufferTime + "ns");
		
		fis2.close();
		fos2.close();
	}
	
	static int data = -1;
	public static long copy(InputStream is, OutputStream os) throws Exception {
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
