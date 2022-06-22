package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.members.Member;
import com.yedam.app.members.MemberDAO;

public class LoginControl {
	
	Scanner sc = new Scanner(System.in);
	private static Member loginInfo = null;

	public static Member getLoginInfo() {
		return loginInfo;

	}

	public LoginControl() {
		while (true) {
			menuPrint();

			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 로그인
				login();
			} else if (menuNo == 2) {
				// 종료
				exit();
			} else if (menuNo == 3) {
				showInputError();
			}
		}

	}
	
	private void menuPrint() {
		System.out.println("=================");
		System.out.println("1.로그인    2. 종료");
		System.out.println("=================");
	
	}
	
	private int menuSelect() {
		int num = 0;
		System.out.println("메뉴를 선택하세요");
		try {
		num = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해 주세요");
		}
		return num;
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void showInputError() {
		System.out.println("메뉴에 있는 숫자를 입력해 주세요");
	}
	
	private void login() {
		// 아이디와 비밀번호 입력
		Member inputInfo = inputMember();
		
		// 로그인 시도
		loginInfo = MemberDAO.getInstance().selectOne(inputInfo);
		
		// 실패할 경우 그대로 메소드 종료
		// 성공할 경우 프로그램을 실행
		if (loginInfo == null) {
			return;
		} 
		
		new Management().run();
		
	}
	
	private Member inputMember() {
		Member member = new Member();
		System.out.println("로그인 아이디를 입력하세요");
		member.setMemberId(sc.nextLine());
		System.out.println("로그인 비번을 입력하세요");
		member.setMemberPassword(sc.nextLine());
		
		return member;
	}
}
