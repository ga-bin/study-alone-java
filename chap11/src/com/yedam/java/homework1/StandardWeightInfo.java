package com.yedam.java.homework1;

public class StandardWeightInfo extends Human {
	
	StandardWeightInfo() {
	
	}
	
	StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
		
	}
	
	// 이름, 키, 몸무게, 표준기능 출력
	@Override
	public void getInformation() {
		System.out.println(super.name + "님의 신장" + super.height + "몸무게 " + super.weight + "표준체중" + getStandardWeight(super.height) + "입니다.");
	}
	
	public double getStandardWeight(int height) {
		double standardWeight = (height - 100) * 0.9;
		return standardWeight;
	}

}
