package com.yedam.java.ch0701_01;

public class ChildTest {

	public static void main(String[] args) {
		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();
		
		GrandPa pa = father; // grandpa에 타입이 다른 인스턴스를 담아도 문제 없음
							// 자식클래스는 부모클래스의 타입으로 변환가능하다
		pa.method();
		pa = uncle;	// pa에 연결되어 있는 인스턴스가 자식 인스턴스이면 자식 메소드가 우선순위가 높다
		pa.method();
		pa = child;
		pa.method();
		pa = cousin;
		pa.method();
		
		Father fa =	child; // 같은 부모를 상속받은 형제 메소드는 서로간의 타입 변환이 불가능하다, 연관없이 독립적이다
//		fa = uncle;
//		fa = cousin; // cousin은 uncle이 부모이기 때문에 fa로 타입 변환이 불가능하다
		fa.method(); // child인스턴스가 담겨있으므로 child의 메소드 실행
		// 참조관계가 있기 때문에 이제 참조타입의 데이터타입을 볼 때, 그안에 실제 담겨있는 인스턴스가 무엇인지 봐야한다
		

		System.out.println();
		Uncle un = cousin;
//		un = father; 
//		un = child;
		
		
		// 자식클래스는 부모클래스로 자동 형변환 가능하다, 부모클래스는 자식 클래스로 자동형변환 불가능
//		Child ch = (Child)fa; // child와 father는 상속관계이기 때문에 부모클래스가 자식클래스로 강제 형변환 가능하다
//		Cousin co = (Cousin)fa; // 서로간에 연관없이 독립적인 메소드들은 강제 타입변환도 불가능하다
		un.method();
	}

}
