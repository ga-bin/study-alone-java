package array;

public class Array2 {

	public static void main(String[] args) {
		int[] intArray = new int[2];
		int[][] intArray2 = new int[3][2];
		// int[2] 이 총 3개 존재하는 2차원 배열임

		for (int i = 0; i < intArray.length; i++) {
			System.out.println("intArray[" + i + "] : " + intArray[i]);
		}
		for (int i = 0; i < intArray2.length; i++) {
			for (int j = 0; j < intArray2[i].length; j++) {
				System.out.println("intArray2[ " + i + j + "]" + intArray2[i][j]);
			}
		}

		System.out.println();
		int[][] intArray3 = new int[2][];
		intArray3[0] = new int[3];
		intArray3[1] = new int[5];

		// for문 쓸 떄 length 쓰기
		for (int i = 0; i < intArray3.length; i++) {
			for (int j = 0; j < intArray3[i].length; j++) {
				System.out.println("intArray3[" + i + j + "]" + intArray3[i][j]);
			}
		}

		int[][] javaScores = { { 95, 80 }, { 92, 96, 80 } };

		for (int i = 0; i < javaScores.length; i++) {
			for (int j = 0; j < javaScores[i].length; j++) {
				System.out.println("javaScores[" + i + j + "]" + javaScores[i][j]);
			}
		}

		// 향상된 for문
		// tempAry는 javaScores에서 하나하나 꺼내서 만든 배열
		for (int[] tempAry : javaScores) {
			for (int temp : tempAry) {
				System.out.println(temp);
			}
		}

	}

}
