package com.yedam.java.ch0604_01;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator calc = new Calculator();
		boolean run = true;
		
		while(run) {
			System.out.println("1. 숫자 개수 | 2. 숫자 입력 | 3. 더하기 | 4. 빼기 | 5. 곱하기 | 6. 나누기 | 7. 프로그램 종료");
			System.out.println("선택>");
			int selectNum = Integer.parseInt(scan.nextLine());
			if (selectNum == 1) {
				System.out.println("숫자 개수>");
				int size = Integer.parseInt(scan.nextLine());
				calc.setArraySize(size);
			} else if (selectNum == 2) {
				int num = Integer.parseInt(scan.nextLine());
				calc.setNum(num);
			} else if (selectNum == 3) {
				calc.plus();
			} else if (selectNum == 4) {
				calc.minus();
			} else if (selectNum == 5) {
				calc.multi();
			} else if (selectNum == 6) {
				calc.divide();
			} else if (selectNum == 7) {
				System.out.println("프로그램 종료");
				run = false;
			}	else if (selectNum == 8) {
				calc.arrayNum();
			}
				}
			

	}

}
