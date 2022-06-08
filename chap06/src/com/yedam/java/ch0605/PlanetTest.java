package com.yedam.java.ch0605;

public class PlanetTest {

	public static void main(String[] args) {
		System.out.println("pi : " + Planet.pi);
		// 정적필드기 때문에 클래스 이름으로 접근 가능
		// 실행 클래스에서 접근해서 출력은 가능
//		Planet.pi = Math.pi;
		// final로 정적필드에서 초기화 했기 때문에 수정불가능
		
		Planet earth = new Planet(6400);
		System.out.println("earth : " + earth.radius);
		Planet moon = new Planet(1500);
		System.out.println("moon : " + moon.radius);
		// 처음 인스턴스 만들때 생성자에 의해서 radius값 초기화
		
//		earth.radius = 1000;
//		moon.radius = 6400;
		// final이 붙었기 때문에 초기화 한 후에 변경은 불가능
		
		// 인스턴스 메소드는 생성된 인스턴스 이름으로 접근 가능
		earth.getArea();
		moon.getArea();
	}
}
