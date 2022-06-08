package com.yedam.java.pack;

import java.util.Scanner;

public class PlayerProgram implements Program {

	private Scanner sc = new Scanner(System.in);
	private static Player max;
	private static Player min;

	@Override
	public void inputInfo(Access access) {
		Player player = inputAll();
		access.insert(player);
	}

	@Override
	public void menuPrint() {
		System.out.println("1.입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.종료");
	}

	private Player inputAll() {
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("능력치 > ");
		int stat = Integer.parseInt(sc.nextLine());

		return new Player(name, stat);
	}

	@Override
	public void printAll(Access access) {
		Player[] list = access.selectAll();
		for (int i = 0; i < list.length; i++) {
			list[i].showInfo();
		}
	}

	@Override
	public void search(Access access) {
		String name = inputName();
		Player info = access.selectOne(name);
		info.showInfo();
	}

	private String inputName() {
		System.out.print("이름 > ");
		return sc.nextLine();
	}

	@Override
	public void analyze(Access access) {

		// 능력치 최상
		System.out.println("능력치 최상 > ");
		max = findMax(access);
		max.showInfo();

		// 능력치 최하
		System.out.println("능력치 최하 > ");
		min = findMin(access);
		min.showInfo();

		// 2개 제외 리스트, 평균
		System.out.println("나머지 리스트, 능력치 평균 > ");
		printList(access);
		printAvg(access);

	}

	private Player findMax(Access access) {
		Player[] list = access.selectAll();
		max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i].getStat() > max.getStat()) {
				max = list[i];
			}
		}
		return max;
	}

	private Player findMin(Access access) {
		Player[] list = access.selectAll();
		min = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i].getStat() < min.getStat()) {
				min = list[i];
			}
		}
		return min;
	}

	private void printList(Access access) {

		Player[] list = access.selectAll();

		for (int i = 0; i < access.selectAll().length; i++) {
			if (list[i] != max && list[i] != min) {
				list[i].showInfo();
			}
		}

	}

	private void printAvg(Access access) {
		Player[] list = access.selectAll();
		double sum = 0;
		int count = 0;

		for (int i = 0; i < access.selectAll().length; i++) {
			if (list[i] != max && list[i] != min) {
				sum += list[i].getStat();
				count++;
			}
		}
		System.out.println("평균은 " + (sum / count) + "입니다.");
	}

}
