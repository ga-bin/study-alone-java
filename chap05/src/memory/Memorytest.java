package memory;

public class Memorytest {

	public static void main(String[] args) { 
		int[] sc = new int[2];
		sc[0] = 100;
		sc[1] = 110;
		test2(sc);
		System.out.println(sc[0] + ":" + sc[1]);
		int a = 10;
		{
			int b1 = 10;
			int b2 = 20;
			test1();
		}
		int c = 30;
		System.out.println(a);
	}
	
	public static void test1() {
		int a = 100;
		int b = 200;
	}
	
	public static void test2(int[] sc) {
		sc[0] = sc[0] + 100;
		sc[1] = sc[1] + 100;
	}
}
