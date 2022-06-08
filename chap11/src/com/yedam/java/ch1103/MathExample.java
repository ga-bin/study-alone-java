package com.yedam.java.ch1103;

public class MathExample {

	public static void main(String[] args) {
		// Math.abs 절대값
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
		
		// Math.ceil 올림값
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3 =" + v3);
		System.out.println("v4 =" + v4);
		
		// Math.floor 버림
		double v5 = Math.floor(5.3);
		double v6  = Math.floor(-5.3); // -5아니고 -6이다.
		System.out.println("v5 = " + v5);
		System.out.println("v6 = " + v6);
		
		// Math.max 최댓값
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.5);
		System.out.println("v7 = " + v7);
		System.out.println("v8 = " + v8);
		
		// Math.min 최솟값
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5, 9);
		System.out.println("v9 = " + v9);
		System.out.println("v10 = " + v10);
		
		// math.random 랜덤값
		// math.random은 내가 조절할 수 없음. 실행시킬 때 마다 값이 다르다. 
		// but random클래스는 조정할 수 있다. - 랜덤한 값을 조절해야할때는 random클래스를 사용해야한다.
		
		double v11= Math.random();
		System.out.println("v11 = " + v11);
		
		// math.rint 가까운 정수의 실수값 -> math.round와 유사함
		// math.rint보다 math.round쓰는게 더 낫다. math.round는 반올림값이 정확함
		// math.rint는 5를 다루는 방식이 rount와 다르다.
		
		double v12 = Math.rint(4.5);
		double v13 = Math.rint(5.7);
		System.out.println("v12 = " + v12);
		System.out.println("v13 = " + v13);
		
		// math.round -> 반올림값
		// math.round는 항상 소숫점 첫째 자리에서 반올림한다.
		long v14 = Math.round(5.3);	
		long v15 = Math.round(5.7);
		
		System.out.println("v14 = " + v14);
		System.out.println("v15 = " + v15);
		
		double value = 12.3456;
		double temp1 = value * 100; // 반올림하고 싶은 소수 자릿수가 소수점 첫째자리가 되도록 1o^n을 곱함
		long temp2 = Math.round(temp1);
		double v16 = temp2 / 100.0; // math.round 적용 후 다시 나누기      
		
		System.out.println(temp2);
		System.out.println("v16 = " + v16);
		
	}	

}

















