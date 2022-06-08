package chap01;
/*
 * 데이터타입을 다른 타입으로 변환
 * 강제형변환
 * 자동형변환
 * string <-----> 기본데이터형(int, double)
 */
public class 타입변환 {

	public static void main(String[] args) {
		// 자동
		int a = 100;
		long b = a;
		
		// 강제
		long c = 100;
		int d = (int)c;
		
		// 자동
		double e = c;
		
		// 강제
		double f = 5.2;
		long g = (long)f; 
		
		System.out.println("g = " + g);
		
		double h = (double)10 / 3; // int끼리 더하면 int -> double로 강제 형변환 해줘야함
		System.out.println("h= " + h);
		
		System.out.println("결과는=" + (10 + 20)); //-> string과 연산하는 것이기 때문에 int인 10과 20이 string으로 변환된다
		// 결과는=1020으로 나옴, 계산하려면 괄호로 묶어주기
		System.out.println(10 + 20 + "결과는 = ");
		
		// int(기본타입) -> string
		int i = 100;
		String j = String.valueOf(i);
		
		// string -> int
		String k = "100";
		short l = Short.parseShort(k);
		
		// 
	}
}































