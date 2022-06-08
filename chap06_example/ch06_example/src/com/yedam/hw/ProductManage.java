package com.yedam.hw;

public class ProductManage {

	private Product[] product;
	private int index;

	public ProductManage() {
		index = -1;
	}

	// 상품수 입력
	public void setProductNum(int size) {
		product = new Product[size];
		index = -1;
	}

	// 상품 및 가격입력
	public void setProduct(String name, int price) {
		if (index < product.length - 1) {
			product[++index] = new Product(name, price);
		} else {
			System.out.println("더이상 입력할 수 없습니다.");
		}
	}

	// 제품별 가격 출력
	public void printProduct() {
		for (int i = 0; i <= index; i++) {
			product[i].showInfo();
		}
	}

	// 분석 결과출력
	public void showHigh() {
		System.out.println("최고가격 상품>> " + getHigh().getName() + " : " + getHigh().getPrice() + "원");
		System.out.println("최고가격 제외 총합>> " + sumPrice() + "원");
	}

	// 최고가격
	public Product getHigh() {
		Product p = product[0];
		//int high = p.getPrice();
		for (int i = 1; i <= index; i++) {
			if (p.getPrice() < product[i].getPrice()) {
				//high = product[i].getPrice();
				p = product[i];
			}
		}
		return p;
	}

	// 총합
	public int sumPrice() {
		int sum = 0;
		for (int i = 0; i <= index; i++) {
			sum += product[i].getPrice();
		}

		return sum - getHigh().getPrice();
	}
	
	public int getTotalPrice() {
		int sum=0;
		for(Product temp : product) {
			if(temp.getPrice() == getHigh().getPrice()) {
				continue;
			}
			sum+=temp.getPrice();
		}
		return sum;
	}

}
