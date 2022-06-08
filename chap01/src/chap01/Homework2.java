package chap01;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 가로입력
		System.out.println("가로 : ");
		double w = Double.parseDouble(scanner.nextLine());
		// 세로입력
		System.out.println("세로 : ");
		double h = Double.parseDouble(scanner.nextLine());
		// 삼각형면적
		double area = (w*h)/2;
		System.out.printf("면적 : %.2f", area);
	}

}
