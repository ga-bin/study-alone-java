package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		Bag bag = new Bag();
		
		// OBJECT필드는 타입에 상관없이 다 넣을 수 있다.
		// BUT 가지고 올 떄 문제가 생김
		bag.set(new Note());
		Note note = (Note)bag.get();
		// 가지고 올 때 return 타입이 object이기 때문에 반드시 강제로 형변환을 시켜줘야한다.
		// 같은타입이면 한번에 끝나지만 이경우에는 작업 2번해야한다.
		// 성능상의 문제, 코드상의 오류(값은 여러개를 넣을 수 있지만 꺼내올때 항상 확인해야한다)

		
		bag.set("신운하");
		String name = (String)bag.get();
		
		// 예를 들어 이런경우 자바는 오류를 알 수 없지만 실행오류가 발생한다.
//		bag.set(new Note()); // 넣는것 문제 없다.
//		String name = (String)bag.get(); // 가지고오는 것도 object타입이어서 string가지고 올 수 있다.
		// but들어있는 객체가 string이 아님
//		
//		bag.set("신운하");
//		Note note = (Note)bag.get();
		// 제네릭
		
		Box<Note, String, Integer> box = new Box<>();
		// 제네릭타입은 기본타입 안된다. INT등 사용하고 싶으면 wrapper class로 타입 지정하자
		// 지정된 note, string, integer등의 타입만 가능하다.
		
		box.setT(new Note());
		box.setK(500);
		box.setV("홍길동");
		
		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();
		
		// 새로운 클래스를 담고 싶을 경우 기존에 있는 box에는 담을 수 없다.
		// 제네릭 클래스에 특정 객체를 넣는 경우
		Box<Car, Bus, Texi> vehicle = new Box<>();
		vehicle.setT(new Car());
		vehicle.setK(new Texi());
		vehicle.setV(new Bus());
		
		Car car = vehicle.getT();
		Texi texi = vehicle.getK();
		Bus bus = vehicle.getV();
	}

}

class Car {}
class Bus {}
class Texi {}

