package com.yedam.java.homework2;

public class RPGGame implements Keypad {
	
	// 필드
	int currentMode;
	
	// 생성자
	RPGGame() {
		this.currentMode = NORMAL_MODE;
	}
	
	// 메소드
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다.");

	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		if(currentMode == NORMAL_MODE) {
			System.out.println("캐릭터가 한칸단위로 점프한다.");
		} else if(currentMode == HARD_MODE) {
			System.out.println("캐릭터가 두칸단위로 점프한다.");
		}

	}

	@Override
	public void rightDownButton() {
		if(currentMode == NORMAL_MODE) {
			System.out.println("캐릭터가 일반 공격");
		} else if(currentMode == HARD_MODE) {
			System.out.println("캐릭터가 HIT 공격");
		}

	}

	@Override
	public void changeMode() {
		if (currentMode == NORMAL_MODE) {
			currentMode = HARD_MODE;
		} else if(currentMode == NORMAL_MODE) {
			currentMode = HARD_MODE;
		}
		System.out.println(currentMode);	
	}

}
