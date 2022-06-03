package control;

import java.util.Scanner;

/*
 * 메뉴가 1이면 사각형, 메뉴가 2이면 사각형, 0이면 종료
 */
public class MenuArea {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu;
		int num = 0;
		do {
			menu = Integer.parseInt(scan.nextLine()); // menu입력
			if (menu == 0) {
				break;// 반복 do - while(true)
			} else if (menu ==1) { // 1이면 사각형 출력
				System.out.println("사각형");
			} else if (menu == 2) {
				System.out.println("삼각형"); // 2이면 삼각형 출력
			} else {
				System.out.println("다시입력하세요"); // 0,1,2아니면 다시 입력
			} num++;
		} while (num<5);
		System.out.println("프로그램종료");
	}

}
