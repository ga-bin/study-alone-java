package com.yedam.java.question;

public class GreenCard implements Payment {
	// 필드
		private String name;
		private String grade;
		private int point;
		private double pointRatio;
		
		GreenCard() {
			name = "Green Card";
			grade = "SILVER";
			pointRatio = 0.05;
		}
		// 메소드
		@Override
		public int offline(int price) {
			// 포인트
			point = (int) (price * pointRatio);
			// 오프라인일 때 추가 할인율 1%
			price = (int) (price * (1-0.01));
			return price;
		}

		@Override
		public int online(int price) {
			// 포인트
			point = (int) (price * pointRatio);
			// 온라인일때 추가할인율 3%
			price = (int) (price * (1-0.03));
			return price;
		}

		@Override
		public int simple(int price) {
			// 포인트
			point = (int) (price * pointRatio);
			// 간편결제일 때 추가할인율 5%
			price = (int) (price * (1-0.05));
			return price;
		}

		@Override
		public void showCardInfo() {
			System.out.println("=========카드 정보============");
			System.out.println("카드 명 " + name);
			System.out.println("적용 등급 " + grade);
			System.out.println("포인트 적립율 : " + pointRatio);
			System.out.println("적립 포인트 : " + point);
			
		}
	
}
