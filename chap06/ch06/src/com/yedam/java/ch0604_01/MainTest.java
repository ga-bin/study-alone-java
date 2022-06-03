package com.yedam.java.ch0604_01;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Calculator c = new Calculator();
		boolean run = true;

		while (run) {

			System.out.println("\n1. 갯수입력 | 2. 숫자입력 | 3. 더하기 | 4. 빼기 | 5. 곱하기 | 6. 나누기 | 7. 종료");
			System.out.print("선택> ");
			int selec = sc.nextInt();
			switch (selec) {
			case 1:
				System.out.print("갯수> ");
				int size = sc.nextInt();
				c.setArraySize(size);
				break;
			case 2:
				System.out.print("숫자> ");
				int num = sc.nextInt();
				c.setNum(num);
				break;
			case 3:
				c.plus();
				break;
			case 4:
				c.minus();
				break;
			case 5:
				c.multi();
				break;
			case 6:
				c.divide();
				break;
			case 7:
				System.out.println("종료");
				run =false;
				break;
			default:
				System.out.println("1~7입력");

			}

		}

//		c.setArraySize(5);
//		c.setNum(10);
//		c.setNum(0);
//		c.divide();

	}

}
