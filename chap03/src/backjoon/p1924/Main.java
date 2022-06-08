package backjoon.p1924;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] Days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// x월 y일을 유저로부터 받아온다
		int x = scan.nextInt();
		int y = scan.nextInt();
		int allDays = 0;
		// 1월부터 x월까지의 일수 + y일
			if (x == 1) {
				allDays = y;
			} else {
				for (int i = 0; i < x-1; i++) {
					allDays += Days[i];
				}
				allDays = allDays + y;
			}
			// 총 일수를 7로 나눈 나머지가 월요일로부터 얼마나 떨어져있는지에 따라 요일을 나눈다.
			switch (allDays % 7) {
			case 1:
				System.out.println("MON");
				break;
			case 2:
				System.out.println("TUE");
				break;
			case 3:
				System.out.println("WED");
				break;
			case 4:
				System.out.println("THU");
				break;
			case 5:
				System.out.println("FRI");
				break;
			case 6:
				System.out.println("SAT");
				break;
			case 0:
				System.out.println("SUN");
				break;
			}

		}

	}
