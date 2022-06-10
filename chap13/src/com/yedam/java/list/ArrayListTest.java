package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList
		
		/*배열
		- 처음 만든 크기 셋팅을 변경불가능
		- 중간에 데이터가 비었을 때 자동으로 공간을 없애지 못함. 그대로 둠
		
		이런 단점을 해결하기 위해 자바에서는 컬렉션 프레임워크를 만들어놨는데
		프레임워크 : 어떤 목적에 맞춰서 정의해 놓은 것
		
		컬렉션 프레임워크 : 객체를 저장하기 위해 정의해놓은 라이브러리들을 총칭하는 말
		
		리스트(인터페이스)
		- 배열처럼 인덱스로 관리 
		- 실제로 부여한 값과 상관없이 인덱스만 중복되지 않으면 된다.(null도 넣기가능)
		- 같은 값을 넣는 것을 허용한다.
		- 크기를 동적으로 관리
		- 내부에 10개정도의 공간을 가지고 있는데 알아서 늘린다
		- 중간에 데이터가 비었을 때 공간 자체를 줄여준다.
		- 리스트를 이용할 때 
		- 리스트컬렉션은 제네릭 타입으로 내부를 구성한다
		
		1. ArrayList(클래스)
		- arraylist도 제네릭 타입으로 내부를 구성한다.
		- 들어갈때는 0부터 차례로 인덱스 부여
		- delete method로 중간의 값이나 첫번째 값을 삭제하면 뒤의 인덱스들을 앞으로 당겨온다.
		- 중간에 값이 많이 삭제되고 들어오는 경우에는 이 특성때문에 arraylist를 많이 사용하는 것을 권장하지 않는다.
		 * 
		 * 
		 */
		List<String> list = new ArrayList<>();
		// 최초로 선언할 때 크기 지정하지 않는다.
		// 제네릭타입이기 때문에 wrapper클래스만 들어간다.
		list.add("Java");
		list.add("jbdc");
		list.add("Servlet/JSP");
		list.add(2,"Database"); // 인덱스 위치 2라고 지정
		list.add("iBATIS");
		
		System.out.println("총 객체 수 " + list.size());
		System.out.println();
		
		String skill = list.get(2); // 2번째 인덱스에 잇는 객체 가지고 오기
		System.out.println("2 : " + skill); // "database"
		System.out.println();
		
		// 리스트에 어떤 객체가 저장되어있는지 전체 조회
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		/*
		 *  0 : Java
			1 : jbdc
			2 : Database
			3 : Servlet/JSP
			4 : iBATIS
		 */
		
		System.out.println();
		list.remove(2);
		// 하고나서 인덱스 1식 떙겨온다.
		// 인덱스를 이용해서 삭제하는 경우에는 한번 삭제하고 인덱스가 변경된다는 것을 예상하고 삭제해야한다.
		list.remove(2);
		list.remove("iBATIS");
		
		System.out.println();
		for(String data : list) {
			System.out.println(data);
		}
		
		
		
		
	}

}
