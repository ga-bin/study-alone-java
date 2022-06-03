package array;

public class Array2 {

	public static void main(String[] args) {

		int[] intAry = new int[2];

		for (int i = 0; i < intAry.length; i++) {
			System.out.println("intAry[" + i + "] : " + intAry[i]);
		}
		System.out.println();
		
		int[][] intAry2 = new int[3][2];
		// int[2] 배열이 총 3개 존재하는 2차원배열

		for (int i = 0; i < intAry2.length; i++) {
			int[] tempAry = intAry2[i];
			for (int j = 0; j < tempAry.length; j++) {
				System.out.println("tempAry[" + j + "] : " + tempAry[j]);
			}
		}
		System.out.println();
		
		for (int i = 0; i < intAry2.length; i++) {
			for (int j = 0; j < intAry2[i].length; j++) {
				System.out.print("intAry2[" + i + "][" + j + "] : " + intAry2[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();

		int[][] intAry3 = new int[2][];
		intAry3[0] = new int[3];
		intAry3[1] = new int[5];

		for (int i = 0; i < intAry3.length; i++) {
			for (int j = 0; j < intAry3[i].length; j++) {
				System.out.print("intAry3[" + i + "][" + j + "]:" + intAry3[i][j] + "   ");
			}
			System.out.println();
		}

		System.out.println();
		int[][] javaScores = { { 95, 80 }, { 92, 96, 80 } };

		for (int i = 0; i < javaScores.length; i++) {
			for (int j = 0; j < javaScores[i].length; j++) {
				System.out.print("javaScores[" + i + "][" + j + "]:" + javaScores[i][j] + "   ");
			}
			System.out.println();
		}
		
		for(int[] tempAry : javaScores) {
			for(int temp : tempAry) {
				System.out.println(temp);
			}
		}

	}

}
