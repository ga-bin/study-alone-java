package chap01;

import java.util.Scanner;

public class scannerUtill {

	public static void main(String[] args) {
		
		String name;
		String job;
		int age;
		// 문자열입력
		Scanner scan = new Scanner(System.in);
		// 프롬프트 출력
		System.out.print("이름 입력:");
		// 문자열 입력 받아서 변수에 저장
		name = scan.nextLine(); // 엔터키 이전까지 입력
		// 입력받은 문자열 출력
		System.out.print("직업 입력:");
		job = scan.nextLine();
		
		System.out.print("나이입력:");
		age = Integer.parseInt(scan.nextLine());
		
		System.out.printf("이름 %s \n직업 %s \n나이 %s", name, job, age);
	}
	
}
