package homework;

import java.util.Scanner;

public class Homework7 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0; // 잔고 = 예금 - 출금
		Scanner scan = new Scanner(System.in);
		int inputMoney = 0;
		int outputMoney = 0;
		do {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------");
			System.out.println("선택> ");
			int choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				inputMoney = Integer.parseInt(scan.nextLine());
				balance = balance - inputMoney;
				System.out.println("\n예금액 >" + inputMoney);
			} else if (choice == 2) {
				outputMoney = Integer.parseInt(scan.nextLine());
				System.out.println("\n출금액 >" + outputMoney);
			} else if (choice == 3) {
				System.out.println("\n잔고 >" + balance);
			} else if (choice == 4) {
				System.out.println("\n");
				run = false;
			}
		} while (false);
		System.out.println("프로그램 종료");
	}

}
