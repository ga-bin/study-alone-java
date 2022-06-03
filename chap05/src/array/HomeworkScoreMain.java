package array;

import java.util.Scanner;

public class HomeworkScoreMain {

	public static void main(String[] args) {
		
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		HomeworkScore calcScore = new HomeworkScore();
		
		while(run) {
			System.out.println("1.학생수 입력 | 2.학생점수 등록 | 3. 학생점수 전체 조회 | 4. 학생정보 분석 | 5. 종료");
			int selectNum = Integer.parseInt(scan.nextLine());
			if (selectNum == 1) {
				System.out.println("학생수 입력>");
				int studentNum = Integer.parseInt(scan.nextLine());
				calcScore.studentNum(studentNum);
			} else if (selectNum == 2) {
				System.out.println("점수입력>");
				int score = Integer.parseInt(scan.nextLine());
				calcScore.studentScore(score);
			} else if (selectNum == 3) {
				calcScore.printScore();
			}else if (selectNum == 4) {
				calcScore.analyze();
			}else if (selectNum == 5) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
	}
}
