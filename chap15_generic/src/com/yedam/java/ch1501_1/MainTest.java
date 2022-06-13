package com.yedam.java.ch1501_1;

public class MainTest {

	public static void main(String[] args) {
		Bag bag = new Bag();
		
		bag.set(new Note());
		Note note = (Note)bag.get();
		
		bag.set("신운하");
		String name = (String)bag.get();
		
		Box<Note, String, Integer> box = new Box<>();
		// 제네릭은 기본타입 안된다. int 등 사용하고 싶으면 wrapper class로 타입 지정하자
		// 지정된 note, string, integer등의 타입만 가능하다.
		// Box<T, V, K>
		
		box.setT(new Note());
		box.setK(500);
		box.setV("홍길동");
		
		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();
		
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

