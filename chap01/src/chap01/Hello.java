package chap01;

public class Hello {

	public static void main(String[] args) {
		// 영어로 인사
		greetEn();
		greetEn();
		greetEn();
		greetEn();
		// 한글로인사
		greet();
		// 자기이름
		info();
	}

	public static void greetEn() {
		System.out.println("hello");
	}
	public static void greet() {
		System.out.println("안녕");
	}
	
	public static void info() {
		System.out.println("kimgabin");		
	}
}
