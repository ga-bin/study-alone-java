package array;

import java.util.Scanner;

public class MainApp {

	static int[] scores;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		init();
		int menu = 0;
		// boolean flag = true;

		while (menu != 5) {

			System.out.println("1. 전체출력   2. 최솟값   3. 최댓값   4. 평균   5. 종료  ");
			System.out.print("입력>> ");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				printAll();
				break;
			case 2:
				findMin();
				break;
			case 3:
				findMax();
				break;
			case 4:
				findAvg();
				break;
			case 5:
				//flag = false;
				break;
			default:
				System.out.print("1~5사이 숫자 입력");
			}

			System.out.println();
		}
		System.out.println("종료");
	}

	public static void printAll() {
		// 배열값 조회
		for (int i = 0; i < 10; i++) {
			System.out.println(scores[i]);

		}
	}

	public static void init() {

		// 배열생성
		scores = new int[10]; // 모든 요소가 0으로 초기화

		// 배열초기화
		for (int i = 0; i < 10; i++) {
			scores[i] = sc.nextInt();

		}
	}

	// 최솟값
	public static void findMin() {
		int min = scores[0];
		for (int i = 1; i < 10; i++) {
			if (scores[i] < min) {
				min = scores[i];
			}
		}
		System.out.printf("최솟값은 %d 입니다.\n", min);
	}

	// 최댓값
	public static void findMax() {
		int max = scores[0];
		for (int i = 1; i < 10; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.printf("최댓값은 %d 입니다.\n", max);
	}

	public static void findAvg() {
		int sum = scores[0];
		double avg;
		for (int i = 1; i < 10; i++) {
			sum += scores[i];
		}
		avg = sum / 10.0;
		// System.out.printf("합계는 %d 입니다.\n", sum);
		System.out.printf("평균은 %.2f 입니다.\n", avg);

	}

}