package com.yedam.java.ch1601_1;

public class RamdaTest {

	public static void main(String[] args) {
		MyFunInterfaceA fa = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		
		fa.method();
		
		fa = () -> { System.out.println("method call2"); };
		fa.method();
		fa = () -> System.out.println("method call3");
		fa.method();
		
		MyFunInterfaceB fb = (int x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		
		fb.method(10);
		
		fb = (x) -> { System.out.println(x*5); };
		fb = x -> System.out.println(x*5);
		
		MyFunInterfaceC fc = (int x, int y) -> {
			int result = x + y;
			return result;
		};
		
		fc = (x, y) -> { return x + y; };
		fc = (x, y) -> x + y;
		
		fc = (x, y) -> Math.max(x, y);
		System.out.println(fc.method(10, 12));
		
		int val1 = 10;
		int val2 = 20;
		
		
		fa = () -> {
			int result = val1 + val2;
			System.out.println(result);
		};
		
		fa.method();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
