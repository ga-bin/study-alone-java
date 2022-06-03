package control;

import java.util.Scanner;

public class ControlMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String grade = "";	// 등급
		int score;		// 점수 입력
		// 조건이 맞을 경우는 do안에 있는 문장들을 계속 실행
		do {
			// 점수를 키보드로부터 입력받아 score변수에 할당
			score = Integer.parseInt(scan.nextLine());
			if (score == 0) {
				break;
			}
			// 등급계산 조건문
			if (score >= 90) {
				grade = "A등급";
			} else if (score >= 80) {
				grade = "B등급";
			} else if (score >=70){
				grade = "C등급";
			} else {
				grade = "D등급";
			}
			// 등급결과 출력
			System.out.printf("%d성적은 %s입니다.", score, grade);
		// score가 0이되면 끝
		} while(true); // !=도 할당인거 기억좀하자..
		}
	}


