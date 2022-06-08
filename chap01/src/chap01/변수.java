package chap01;

/*
 * 변수의 타입(유형)
 *  변수 -> 메모리의 저장 위치, 값을 저장하는 공간
 *  유형 -> 메모리에 값을 저장하는 형식(구조와 크기가 다름)
 *             1       2     4      8
 * 숫자  정수   byte  < short   < int   < long  <  BigDecimal
 *             127    3만 2천   21억     10^18
 *             7        15
 * 		실수   float < double   유효자릿수 정밀도   0.00000012 -> 0.12*10^-5
 * 
 * 문자  한글자 char      'a' '가'(한글자)
 *      단어   String   "홍길동"(여러글자)
 * 불린형 boolean  <- true, false
 */

public class 변수 {

	public static void main(String[] args) {
		int korScore = 100; // 상수값의 기본형은 int
		int int2 = 0b11111111;
		int int8 = 017;
		int int16 = 0x7F;
		
		
		long rich = 220000000l; // 상수값 long을 사용하려면 접미어 L또는 소문자 l
		float avg = 0.1234567f; // float형 변수 avg를 선언하고 상수값 할당
		double totalAvg = 0.1234566789;
		
		System.out.println("int2 =\n\t\t \\" + int2 + "\\");
		System.out.println("int8 = \"" + int8 + "\"");
		System.out.println("int16 = " + int16);
		int k=60, e=60, m=60;
		boolean passYn = true;
		boolean fail = k > 50 && e > 50 && m > 50;
		
		System.out.println("fail : " + fail);
		
		
		int engScore = 10; // 변수선언, 초기화
		int mathScore; // 변수선언
		mathScore = 100; // 초기화
		
		System.out.println(avg);
		System.out.println(totalAvg);
		System.out.println(engScore);
		
		char grade = '가';//'A';
		String grade2 = "A+";
		
		System.out.println("grade = " + (int)grade);
		
		//
		char code = 44033;
	System.out.println("44033문자 = " + code);
	
	}

}
