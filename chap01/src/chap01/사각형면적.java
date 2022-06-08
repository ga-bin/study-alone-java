package chap01;

import java.util.Scanner;

public class 사각형면적 {

	public static void main(String[] args) {
		
		int w, h, area;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("가로입력: ");
		w = Integer.parseInt(scan.nextLine()); //가로입력
		
		System.out.print("세로입력: ");
		h = Integer.parseInt(scan.nextLine()); //세로입력
		
		area = w * h; //면적계산
		System.out.println("면적=" + area); //면적출력;
		}
	
}
