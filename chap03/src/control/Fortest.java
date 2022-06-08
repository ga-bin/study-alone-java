package control;

public class Fortest {

	public static void main(String[] args) {
		test1();

	}

	public static void test1() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
