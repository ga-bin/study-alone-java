package com.yedam.java.question;

public class VIPCard implements Payment {
		// 필드
		private String name;
		private String grade;
		private double saleRatio;
		private int point;
		private double pointRatio;
		
		// 생성자
		VIPCard() {
			name = "VIPCard";
			grade = "GOLD";
			saleRatio = 0.1;
			pointRatio = 0.03;
		}
	
		// 메소드
		@Override
		public int offline(int price) {
			// 포인트 
			point = (int) (price * pointRatio);
			// 추가할인율 1%
			price = (int) (price * (1 - (saleRatio + 0.01)));
			return price;
		}

		@Override
		public int online(int price) {
			// 포인트 
			point = (int) (price * pointRatio);
			// 추가할인율 3%
			price = (int) (price * (1 - (saleRatio + 0.03)));
			return price;
		}

		@Override
		public int simple(int price) {
			// 포인트 
			point = (int) (price * pointRatio);
			// 추가할인율 1%
			price = (int) (price * (1 - (saleRatio + 0.05)));
			return price;
		}

		@Override
		public void showCardInfo() {
			System.out.println("=========카드 정보============");
			System.out.println("카드 명 " + name);
			System.out.println("적용 등급 " + grade);
			System.out.println("할인율 : " + saleRatio);
			System.out.println("포인트 적립율 : " + pointRatio);
			System.out.println("적립 포인트 : " + point);
			

		}


}
