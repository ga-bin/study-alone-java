package chap01;

import java.util.Scanner;

public class Homework1 {


	public static void main(String[] args) {
		
		 hw2();
		 hw3();
	}
	
	public static void hw2 () {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫번째 수:");
		String strNum1 = scanner.nextLine();
		
		System.out.println("두번째 수:");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈결과:" + result);
		scanner.close();
	}
	
	
	public static void hw3 () {
		Scanner scanner = new Scanner(System.in);
		
		String name;
		int privateNum;
		String telNum;
		
		System.out.println("이름 : " );
		name = scanner.nextLine();
		
		System.out.println("주민번호 앞 6자리 : ");
		privateNum = Integer.parseInt(scanner.nextLine());
		
		System.out.println("전화번호 : ");
		telNum = scanner.nextLine();	
		
		System.out.println(name);
		System.out.println(privateNum);
		System.out.println(telNum);
		scanner.close();
		
	}
}
