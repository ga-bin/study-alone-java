package com.yedam.java.ch1002;

public class MainTest {

	public static void main(String[] args) {
		try {
			// 원래 실행하고자 한 코드
		} catch (Exception e) {
			// 예외가 발생한 경우 실행할 코드
		} finally {
			// 정상적으로 실행되든 예외가 발생했든 반드시 실행해야 하는 코드
			// finally는 선택사항
		}

		String data1 = null;
		String data2 = null;

		try {
			int value1 = Integer.parseInt(data1);
			data1 = args[0];
			data2 = args[1];
			// catch로 처리해야하는게 여러가지이면 try구문의 제일 위에 것만 catch실행한다.
		} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
			// e.printStackTrace() : 에러의 발생근원지를 찾아서 단계별로 에러를 출력합니다.
			// 예외가 출력된 것이라서 콘솔에 예외가 발생한 것 처럼 보임
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
			// catch구문은 try로 묶은 코드만 처리하고, catch구문이 가지는 exception만 처리할 수 있다
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식에 맞춰 입력해 주세요.");
			return;
			// 무조건 return써줘야함 아니면 마지막의 exception으로 처리하게 된다.
		} catch(Exception e) {
			System.out.println("기타");
			// 모든 예외 상황에 대해서 다중캐치 구문을 만들 수 없으니 가장 많이 발생하는 것만 자식 exception의 catch로 처리
			// 나머지는 exception e로 처리(상속 관계를 이용한 자동형변환을 통해서)
			// exception은 항상 마지막에 들어가야 한다.
			// exception이 다른 모든 자식 exception들을 포함하고 있기 때문에 exception이 앞에 나오면 다른 catch구문들이
			// 실행되지 않는다.
			return;
		} finally {
			System.out.println("필수 구문");
			// try catch구문이 return으로 중간에 종료되더라도 finally는 무조건 실행된다.
			// 보통 종료될 때 자원을 정리할 경우에 사용한다., ram이나 통신 등등                            
		}
		System.out.println("메인 메소드 종료");
		
		findClass(); // 호출하는쪽에 예외 처리를 넘긴다.
		// thorws로 던질때 메소드에 처리해야하는 메소드를 try catch구문이나 if문 등으로 처리해야한다.
	}
	public static void findClass() throws ClassNotFoundException, NullPointerException {
		Class clazz = Class.forName("java.lang.String");
		// 클래스에 대한 메타정보를 가지는 클래스
		// try catch구문이 아니라 throws를 사용하는 이유는 오류를 처리하는 방식이
		// 회사마다 다 다르기 때문이다
		// throws가 가질 수 있는 예외는 경우에 따라서 여러개가 되기도 한다. 
		// 이 경우에는 단스디 throws에 있는 것 다 처리되야한다.(다중 catch구문)
	}
	
	// 필요에 따라서 내가 예외를 만드는 것도 가능
	// final(상속, 재정의 불가능)한 것 아니다.
}

	
}
