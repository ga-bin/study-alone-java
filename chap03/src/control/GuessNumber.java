package control;

import java.util.Scanner;

public class GuessNumber {
	// 배열추가해서 값들어올때마다 배열에 담고, 유저가 값 입력할 때 마다 입력한 값 보여주기
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
<<<<<<< HEAD
		int rand = (int) ((Math.random() * 10) + 1); // 나중에 난수로 바꿀것임
=======
		int rand = (int)((Math.random() * 10) + 1); // 나중에 난수로 바꿀것임
>>>>>>> branch 'master' of https://github.com/ga-bin/java.git
//		String result; // 비교결과를 저장
		int count = 0;
<<<<<<< HEAD
		boolean isPlay = true;
=======
>>>>>>> branch 'master' of https://github.com/ga-bin/java.git
		// 반복문을 돌리면서 유저들이 입력한 값이랑 실제 값을 비교
		// 배열 생성
		int[] userTry = new int[6];
<<<<<<< HEAD
		while (isPlay) {
			userTry[count] = Integer.parseInt(scan.nextLine());
			// 유저가 시도한 값을 읽어서 userTry 배열에 저장
			if (rand == userTry[count]) { // rand == num break;
				{
					System.out.println("맞다");
					break;
				}
				// 유저들이 시도한 값 보여주기
				for (int i = 0; i < count; i++) {
					System.out.print(userTry[i]);
				}
				count++;
				if (count > 5) {
					isPlay = false;
					
				}
				isPlay = true;
=======
		while(true) { 
				userTry[count] = Integer.parseInt(scan.nextLine());   
			 // 유저가 시도한 값을 읽어서 userTry 배열에 저장
			if (rand == userTry[count]) {	// rand == num break;
				System.out.println("맞췄습니다!");
				break;
			} else if (rand > userTry[count]) {

				System.out.println("크다");	// rand > num "크다" 출력
			} else if (rand < userTry[count]) {
				System.out.println("작다");	// rand < num "작다" 출력
			} else {
				System.out.println("맞다");
				break;
>>>>>>> branch 'master' of https://github.com/ga-bin/java.git
			}
<<<<<<< HEAD
		}
=======
			// 유저들이 시도한 값 보여주기
			for (int i = 0; i < count; i++) {
				System.out.print(userTry[i]);				
			}
			count++;
			if (count>5) {
				System.out.print("실패");
				break;
			}
		} 
>>>>>>> branch 'master' of https://github.com/ga-bin/java.git
	}
}
