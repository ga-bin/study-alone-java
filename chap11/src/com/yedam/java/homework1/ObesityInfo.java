package com.yedam.java.homework1;

public class ObesityInfo extends StandardWeightInfo {
	
	ObesityInfo() {
		
	}
 	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}

	@Override
	public void getInformation() {
//		super 키워드를 사용해서 부모 클래스(바로 직계만)의 메소드는 호출할 수 있습니다만
//		그 이상의 조상의 메소드는 접근할 수 없습니다.
		System.out.println(super.name + "님의 신장" + super.height + "몸무게 " + super.weight + getObesity(super.weight) + "입니다.");

	}

	public String getObesity(int weight) {
		double standardWeight = super.getStandardWeight(super.height);
		double bmi = (weight - standardWeight) / standardWeight * 100;
		if (bmi < 18.5) {
			return "저체중";
		} else if (bmi < 24) {
			return "정상";
		} else if (bmi < 28) {
			return "과체중";
		} else {
			return "비만";
		}
	}

}
