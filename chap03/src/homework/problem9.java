package homework;

import java.util.Scanner;

public class problem9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Double num1;
		System.out.print("첫번째수 : ");
		num1 = Double.parseDouble(scan.nextLine());
		Double num2; 
		System.out.print("두번째수 : ");
		num2 = Double.parseDouble(scan.nextLine());
		Double result = num1 / num2;
		
		if (num2 == 0 || num2 == 0.0)  {
			System.out.println("결과 : 무한대");
		} else {
			System.out.println("결과 : " + result);
		}
	}

}
