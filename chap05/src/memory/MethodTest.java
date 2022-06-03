package memory;

public class MethodTest {

	public static void main(String[] args) {
		test1("*", 10);
		test1("w", 20);

	}
	
	// 인수
	public static void test1(String s, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(s);
		}
		System.out.println();
	}

}
