package com.yedam.hw0;

public class Control  {
	   // productTest 컨트롤할 메서드 만들기
	   // 필드
	   private Product[] productList;
	   // 배열에 생성할 인스턴스 담을 거라서 product로 데이터 타입 설정
	   private int index;
	   private int max;

	   // 생성자
	   Control() {
	      index = -1;
	   }

	   // 메소드
	   // 상품 수 입력 받을 메소드 - 상품 수 만큼 배열 길이 설정
	   public void setLength(int length) {
	      productList = new Product[length];
	       // new생성자 호출로 배열 생성
	   }

	   // 상품 및 가격 설정할 메소드
	   public void setProductPrice(String name, int price) {
	      // product인스턴스 생성하기
//	      Product product = new Product();
	      productList[++index] = new Product();
	      // setProductPrice호출할 때마다 각 배열 요소마다 객체 생성하기
	      // getter와 setter로 생성한 객체에 상품이름과 가격을 설정
	      productList[index].setName(name);
	      productList[index].setPrice(price);

	   }

	   // 제품별 가격 보여줄 메소드
	   public void showPrice() {
	      for (int i = 0; i < index + 1; i++) {
	         System.out.println(productList[i].getName() + ":" + productList[i].getPrice());
	      }
	   }

	   // 분석
	   public void analyse() {
	      maxPriceProduct();
	      restProduct();
	   }

	   // 최고가 제품
	   public void maxPriceProduct() {
	      for (int i = 0; i < index + 1; i++) {
	         if (max < productList[i].getPrice()) {
	            max = productList[i].getPrice();
	         }
	         System.out.println("최고가 제품 :" + max);
	      }
	   }

	   // 최고가 제품을 뺀 나머지 제품 총합
	   public void restProduct() {
	      int sum = 0;
	      for(int i = 0; i < index+1; i++) {
	         sum += productList[i].getPrice();
	      }
	      System.out.println("나머지 총합 :" + (sum-max));
	      }
	   }