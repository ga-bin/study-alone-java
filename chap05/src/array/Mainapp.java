package array;

import java.util.Scanner;

public class Mainapp {

	// 배열 선언
	static int[] scores;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 배열 생성과 초기화
		init();
		// 반복문
		// 메뉴출력 입력 1.전체출력 2.최솟값 3.최댓값 4.평균
		// 메뉴가 1이면
		System.out.println("메뉴출력 입력 1.전체출력 2.최솟값 3.최댓값 4.평균");
		// 메뉴입력
		System.out.println("선택");
		int menu;
		while (true) {
			menu = scan.nextInt(); 
//			if (menu == 1) {
//				printAll();
//			} else if (menu == 2) {
//				// 메뉴가 2이면
//				findMin();
//			} else if (menu == 3) {
//				// 메뉴가 3이면
//				findMax();
//			} else if (menu == 4) {
//				// 메뉴가 4이면;
//				findAvg();
//			} else if (menu == 5) {
//				// 메뉴가 5이면 종료
//				System.out.println("종료");
//				break;
//			}

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
				System.out.println("종료");
				break;
			default:
				System.out.println("1~5를 입력하세요");
			}
		if (menu == 5) {
			break;
		}
	}

//		// 두번째학생의 성적 출력
//		System.out.println("두번째 학생 : " + scores[1]);

	}

	public static void init() {

		// 배열 생성
		scores = new int[10]; // 모든 요소가 자동으로 0으로 초기화(힙영역에 저장되어 있기 때문)
								// 변수처럼 스택영역에 저장되어 있으면 초기화 x

		// 배열 초기화
		for (int i = 0; i < 10; i++) {
			scores[i] = scan.nextInt();
		}
//		
	}

	// 배열값전체조회
	public static void printAll() {
		for (int i = 0; i < 10; i++) {
			System.out.println(scores[i]);
		}

	}

	// 최댓값
	public static void findMax() {
		int max = scores[0]; // 최댓값에 첫번째수 넣기
		for (int i = 1; i < 10; i++) {
			int num = scores[i]; // 반복문 돌면서 비교할 변수
			if (max < num) {
				max = num;
			}
		}
		System.out.printf("최댓값은 %d입니다", max);
	}

	public static void findMin() {
		// 최솟값
		int min = scores[0];
		for (int i = 1; i < 10; i++) {
			int num = scores[i]; // 들어오는 변수들을 넣을 곳 score1 score2,,,
			if (min > num) { // 12 > 90
				min = num;
			}
		}
		System.out.printf("최솟값은 %d 입니다", min);

	}

	public static void findAvg() {
		// 배열 합계 구하기
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += scores[i];
		}
		System.out.println(sum);

		// 배열 평균 구하기
		int avg = sum / 10;
		System.out.println(avg);
	}
}
