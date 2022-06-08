package array;

public class ArrayTest {

	public static void main(String[] args) {
		int[] month = new int[] {31, 28, 31, 30, 31, 31,};
		System.out.println(month[1]);
		
		int[] week = {'월', '화', '수'}; // 배열 객체를 생성할 때만 {} 사용가능, 배열 크기는 요소의 개수로 결정
		int[] score = new int[10]; // 이런경우 하나씩 담아야함
		
		// 배열을 먼저 선언하고 값을 담아햐 하는 경우에는 new int[]사용
		int[] hello = new int[2];
		hello = new int[] {1, 2};
	}

}
