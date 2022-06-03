package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) throws FileNotFoundException {

//		while1();
//		for1();
//		for2();
//		gugudan5();
//		findMax(); // 최댓값
//		findMin(); // 최솟값
		findMinMax(); // 최대최소 둘다 구하기
	}

	// 1부터 10까지 반복 while문
	public static void while1() {
		int count = 1;
		do {
			System.out.println(count);
			count++;
		} while (count <= 10);

	}

	// 1부터 10까지 반복 for문
	public static void for1() {
		for (int i = 0; i <= 10; i = i + 2) {
			System.out.println("반복");
		}
	}

	// 10 ~ 1 출력 for뮨
	public static void for2() {
		for (int i = 10; i >= 1; i--) {
			System.out.println(i);
		}
	}

//	public static void gugudan5() {
//		for (int i = 1; i<=5; i++) {
//			for (int j = 1; j<=9; j++) {
////				System.out.println(i + "x" + j + "=" + i*j);
//				System.out.printf("%d * %d = %d \n", i, j, i*j);
//			}
//		}
//	}

	public static void gugudan5() {
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%s x %d = %d", dan, i, dan * i);
		}
	}

	// 최댓값 구하기
	public static void findMax() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int num = 0;
		int max = 0;
		for (int i = 0; i < 10; i++) { // 10번 반복
			num = scan.nextInt(); // 숫자를 입력
			// 큰수보다 크면 출력
			if (num > max) {
				max = num;
			}
		}
		System.out.println(num);
	}

	// 최솟값 구하기
	public static void findMin() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int num = 0;
		int min = 100; // 최솟값 저장
		// 검사하는 반복문 돌리기
		for (int i = 0; i < 10; i++) {
			num = scan.nextInt();
			if (num < min) {
				min = num;
			}
		}
		System.out.println(min);
	}

	public static void findMinMax() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));

		int num1 = 0;
		int min = 100;
		int num2 = 0;
		int max = 0;
		// min for 문
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		for (int i = 0; i < 9; i++) {
			if (num1 < min) {
				min = num1;
			}
			if (num2 > max) {
				max = num2;
			}
		}
		System.out.println(min);
		System.out.println(max);
	}
}
