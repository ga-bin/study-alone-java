package chap01;

/* 작성자 : 김가빈
 * 작성일자 : 2022-05-18
 * 기능 : 숫자 계산기
 */
public class 계산기 {
	
	public static void main(String[] args) {
//		// 두 수의 합을 출력
//		add(); // 메서드 호출
//		// 두 수의 차를 출력
//		sub();
		// 국어, 영어, 수학의 합계, 평균 출력
		totalAvg();
	}

	// 메서드 선언
	public static void add() {
		int num1 = 1;  // 변수 num1을 선언하고 1을 저장
		int num2 = 2;  // 변수 num2를 선언하고 2를 저장
		num1 = 10; // 변수 num1에 10을 재할당(변수에는 값을 바꿔서 저장할 수 있다) 
		int result = num1 + num2; // 변수 result를 선언하고 num1과 num2를 더한값을 저장
		System.out.println(result); // 변수 result를 출력하는 메소드 호출 
	}

	public static void sub() {
		int x = 1;
		int y = 2;
		int result = x - y;
		System.out.println(result);
	}
	
	public static void totalAvg() {
		// 국어 변수 선언
		int kor;
		// 국어 변수 초기화
		kor = 90;
		// 수학 변수 선언 + 초기화
		int math = 83;
		// 영어 변수 선언 + 초기화
		int eng = 98;
		// 세 과목의 합의 계산 변수에 담고
		int sum = kor + math + eng;
		// 합을 3으로 나누어서 평균을 구해서 변수에 담고
		double avg = (double)sum / 3;  // 강제 형변환
		// 합계 출력
		System.out.println("합계=" + sum);
		// 평균 출력
		System.out.println("평균=" + avg);
	}

}
