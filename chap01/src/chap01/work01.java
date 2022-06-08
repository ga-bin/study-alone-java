package chap01;

public class work01 {

	public static void main(String[] args) {
		변수선언();

	}
	
	public static void 변수선언() {
		char grade = '상';
		String schoolName = "예담";
		byte score = 85;
		double average = 4.235;
		short flag = 0b10000000;
		char firstChar = '\uAC00';
		int secondChar = 0xAC01;
		int salary = 1_000_000;
		boolean useYn = true;
		
		System.out.println("grade=" + grade + "\t\t, schoolName=" + schoolName + "\t\t, score=" + score);
		System.out.println("average=\t" + average);
		System.out.println("flag=\t\t" + flag);
		System.out.println("firstChar=\t" + firstChar);
		System.out.println("secondChar=\t"+ (char)secondChar);
		System.out.println("salary=\t\t" + salary);
		System.out.println("userYn=\t\t" + useYn);
	}

}
