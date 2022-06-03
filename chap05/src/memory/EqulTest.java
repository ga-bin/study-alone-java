package memory;

public class EqulTest extends MethodTest {

	public static void main(String[] args) {
		
		int[] a = new int[5];
		int[] b = a; // 얕은 복사 (같은 객체를 참조하는 주소만 복사함)
		int [] c = new int[a.length]; 
		System.arraycopy(a, 0, c, 0, a.length); // 깊은 복사, 안의 내용까지 같은 완전히 새로운 객체가 만들어짐
		
		b[0] = 100;
		System.out.println(a[0]);
		
		System.out.println(a == b); // 참조변수끼리의 != ==는 같은 객체를 참조하냐의 의미
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3 = "h1";
		String s4 = "h2";
		System.out.println(s3 == s4); //  true 메서드 영역의 같은 상수값인 "hi"를 가져가는 것 -> 같은 객체를 참조함
		
		s1 = null;
		s2 = null; // 메모리 공간에 값이 계속 있는 것을 막기 위해서 참조를 끊어버림
	}

}
