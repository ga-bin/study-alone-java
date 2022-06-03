package backjoon.p10871;

import java.util.Scanner;

public class Main2 {
	Scanner scan = new Scanner(System.in);
	int n;
	int x; 
	int num; // 입력 
	int count = 1;// 반복횟수
	
	do {
		n = scan.nextInt();
		x = scan.nextInt();
		num = scan.nextInt();
		if (num <= x) {
			System.out.println(num + " ");
		}
		count++;
	} while(cound<=10);
}
}


