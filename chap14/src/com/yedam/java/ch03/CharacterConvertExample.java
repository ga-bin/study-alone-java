package com.yedam.java.ch03;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class CharacterConvertExample {

	public static void main(String[] args) throws Exception {
		// 입출력스트림은 기본적으로 byte로 만든다(자바가 그렇게 되어있음)
		// 그렇게 byte로 받는 것을 내가 읽거나 쓸 때는 문자로 바꾸는 경우가 많다.
		// 그때 보조스트림 사용하는것
		// outputstreamwriter는 프로그램을 입력받은 문자(byte)를 str로
		// inputstreamwriter는 외부 파일의 str를 -> byte로
		
		// 문자기반의 입출력스트림 reader와 writer는 보조스트림이 있다면 필요없어짐.(byte를 str로 바꿀 수 있으니까) 근데 왜 있냐
		// byte기반의 stream은 타입 상관없이 데이터를 읽어들이기 위해서 먼저 있었다
		// but 자바는 2byte를 한글자로 처리한다. -> byte기반의 스트림은 1byte씩 읽어들인다.
		// 그래서 문자기반의 스트림을 새로 만들었다.
		
		// 파일 전체가 문자면 문자기반 입출력스트림을 사용하면된다.
		// byte기반의 입출력스트림에 보조스트림을 붙혀서 쓰는 것과 문자기반 입출력스트림을 사용하는데 차이는 없지만
		// 문자기반 입출력스트림은 문자 이외의 데이터타입을 읽어내기 힘들어한다.
		
		
		System.out.println("입력 문장>");
		String data = new Scanner(System.in).nextLine();
		write(data); // 파일에 입력한 문장 쓰기
		read();
		
	}
	
	public static void write(String str) throws Exception {
		// 파일에 데이터를 집어넣는 byte 기반의 출력스트림
		OutputStream os = new FileOutputStream("D:/dev/temp/text1.txt");
		// 내보내고 싶을때는 문자로 내보내기
		// 보조스트림 연결

		//		os.write(str);
		// outputstream은 byte기반이어서 값을 string으로 그대로 못넘긴다.
		// 별도의 조작없이 이를 넘기기 위해서 outputstreamwriter 사용하는 것
		
		Writer writer = new OutputStreamWriter(os);
		// outputstreamwriter는 문자기반 스트림인 writer의 하위 클래스 
		// outputstream과 연결된다.
		// 보조스트림은 최종적으로 도달할 곳이 자신을 연결한 스트림이므로 매개변수로 스트림을 넣어준다.
		writer.write(str);
		writer.flush();
		writer.close();
		
		
	}
	
	public static void read() throws Exception {
		InputStream is = new FileInputStream("D:/dev/temp/text1.txt");
		Reader reader = new InputStreamReader(is);
		// 보조스트림은 직접적으로 데이터 주고받을 수 없으므로 stream으로 넘겨주어야 한다.
		
		char[] buffer = new char[100]; // 읽어들이는 것은 char배열으로
		int readCharNum = reader.read(buffer); // 보조스트림 reader를 통해 읽어들이기, readCharNum에는 읽어들인 개수 저장됨
		// 원래 긴문장이나 한문단 사용하는 경우 read가 -1인지 확인하여 break거는 while문 사용해야한다.
		reader.close();
		String data = new String(buffer, 0, readCharNum);
		System.out.println(data);
		
		
	}
}


















