package array;

public class ArrayTest2 {

	public static void main(String[] args) {
		
		String[] arr = new String[] {"hello", "hi", "good"};
		
		for (int i =0; i<arr.length; i++) {
			System.out.println(arr[i]);
			System.out.println(arr[i].length()); // length로 문자열 길이도 출력가능
		}
		

	}

}
