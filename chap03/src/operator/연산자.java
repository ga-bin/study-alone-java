package operator;

import java.io.IOException;
import java.util.Scanner;

public class 연산자 {

	public static void main(String[] args) {
//		산술연산();
//		짝수검사();
//		부호연산();
//		incDecOp(); 	  //증감연산
//		denyLogicOp();    //논리부정
//		toLower();        //문자연산
//		compareOp(); 	  //비교연산 - 윤년계산
//		isDigit();        //입력값이 숫자인지 판단
//		isChar();	      //대소문자인지 판단
		conditionOp();	  //삼항연산자
	}
	
	// 삼항연산자
	public static void conditionOp() {
		int score = 70;
		String grade = (score>=90) ? "A등급" : ((score>=80) ? "B등급" : "C등급");
		System.out.printf("%d 점은 %s입니다.", score, grade);
	}
	
	// 입력값이 문자(대소문자)인지 판단
	public static void isChar() {
		try {
			int key = System.in.read();
			boolean result = (key >= 65 && key <=90) || (key >=97 && key <=122);
			System.out.println(result ? "문자" : "문자아님");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 입력값이 숫자인지 판단
	public static void isDigit() {
		try {
			int key = System.in.read();
			boolean result = key >= 48 && key <= 57;// 아스키코드 기준 숫자면 48 ~ 57 사이
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 비교연산 = 윤년계산
	public static void compareOp() {
		int year = 2020;
		boolean result = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		System.out.println(result);
	}

	// 문자연산
	public static void toLower() {
		char c = 'A';
		char p = (char)(c+32);
		System.out.println(c + ":" + p);
	}
	// 논리부정
	public static void denyLogicOp() {
		boolean play = true;
		play = !play;
		System.out.println(play);
	}
	
	
	// 증감 연산자
	public static void incDecOp() {
		int x = 10;
		int y = 10;
		x++;
//		x = x - 1;
		++y;
		System.out.println(x);
		System.out.println(y);
		
		int a = 10;
		int b = 10;
		int c = a++ + b++;
//		a = a + 1;
//		b = b + 1;
		System.out.println(c);
	}
	
	
	// 부호연산
	public static void 부호연산() {
		int i1 = +100;
		int i2 = -100;

		byte x = 100;
		int result = -x; // 부호연산의 결과는 int형이다!
	}

	// 짝수인지 검사
	public static void 짝수검사() {
		int n1 = 6;
		boolean result = (n1 % 2 == 0);
		System.out.println(result);

	}

	// 산술연산자
	public static void 산술연산() {
		int n1 = 10;
		int n2 = 3;

		int n3 = n1 / n2; // 몫
		int n4 = n1 % n2;// 나머지

		System.out.println(n3 + ":" + n4);
	}
}
