package backjoon.p2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// h와 m을 유저로부터 받아온다
		int H = scan.nextInt();
		int M = scan.nextInt();
		
		// 분이랑 시랑 나눠서 생각하자
		// 시가 1줄어들 때 분은 15분씩 늘어난다
		int newH = H -1;
		int newM = M + 15;
		
		// 만약 분이 45분 이상인 경우 시는 그대로 분은 분-45
		if (M >= 45) {
			newH = H;
			newM = M-45;
		}
		// 만약 시가 00일 경우 + 분이 45분보다 작을경우 시가 23으로 분은 그대로 +15
		else if (H == 0) {
			newH = 23;
		}
		System.out.println(newH + " " + newM);
		}	
	}

