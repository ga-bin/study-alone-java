package com.yedam.app.product;

import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.Management;

public class ProductInfoManagement extends Management {
	
   // 제품에 대한 정보를 등록, 수정, 삭제
   public ProductInfoManagement() {
	   boolean role = selectRole();
      while (true) {
         menuPrint(role);
         int menu = menuSelect();

         if (menu == 1 && role) {
            // 제품정보 등록
            insertProductInfo();
         } else if (menu == 2 && role) {
            // 제품정보 수정 - 가격
            updateProductPrice();
         } else if (menu == 3 && role) {
            // 제품정보 삭제
            deleteProductInfo();
         } else if (menu == 4) {
        	 // 제품검색
        	 selectOne();
         } else if (menu == 5) {
        	 // 전체조회
        	 selectAll();
         }
         	else if (menu == 9) {
            // 뒤로가기
            back();
            break;
         } else {
            showInputError();
         }

      }

   }
   
   private void selectOne() {
	   String productName= inputName();
	   
	   Product product = pDAO.selectOne(productName);
	   
	   if (product == null) {
		   System.out.println("등록된 제품이 아닙니다.");
		   return;
	   }
	   System.out.println(product);
   }
   private void back() {
	System.out.println("뒤로가기");
	
}
   
   private void selectAll() {
	   List<Product> list = new ArrayList<>();
	   list = pDAO.selectAll();
	   for (Product product : list) {
		   System.out.println(product);
	   }
   }

   private void insertProductInfo() {
	   // 제품정보 입력
	   Product product = inputAll();
	   // DB저장
	   pDAO.insert(product);
   }

private void updateProductPrice() {
      // 제품이름 입력
      String productName = inputName();
      // 제품정보 검색
      Product product = pDAO.selectOne(productName);
      if (product == null) {
         System.out.println("등록된 정보가 없습니다.");
         return;
      }

      // 수정할 정보 입력
      product = inputUpdateInfo(product);

      // DB 수정
      pDAO.updateInfo(product);

   }

   private Product inputUpdateInfo(Product product) {
      System.out.println("기존 정보");
      System.out.println(product.getProductName() + ", " + product.getProductPrice() + "원");
      System.out.print("이름(수정하지 않으려면 -1입력)>");
      String name = sc.nextLine();
      if (!name.equals("-1")) {
         product.setProductName(name);
      }
      System.out.print("가격(수정하지 않으려면 -1입력)>");
      int price = Integer.parseInt(sc.nextLine());
      if (price != -1) {
         product.setProductPrice(price);
      }
      return product;
   }

   private void deleteProductInfo() {
      // 제품이름 입력
      String productName = inputName();
      // 제품정보 검색
      // -1 products 테이블에서 정보가져오기
      Product product = pDAO.selectOne(productName);
      if (product == null) {
         System.out.println("등록된 정보가 없습니다.");
         return;
      }
      // -2 입고내역에서 검색
      boolean isSelected = rDAO.selectInfo(product.getProductId());
      // DB에서 삭제
      if (!isSelected) {
         pDAO.delete(product.getProductId());
      } else {
         System.out.println("거래내역이 존재합니다.");
      }
   }

   private String inputName() {
      System.out.print("제품이름>");
      return sc.nextLine();
   }


   private Product inputAll() {
      Product product = new Product();
      System.out.print("제품이름>");
      product.setProductName(sc.nextLine());
      System.out.print("제품가격>");
      product.setProductPrice(Integer.parseInt(sc.nextLine()));
      return product;
   }

   

   protected void menuPrint(boolean role) {
	  String menu = "";
	  if(role) {
		  menu += "1.제품정보등록  2.제품가격수정  3.제품정보삭제";
	  } 
	  menu += "   4. 제품검색   5. 전체조회  9.뒤로가기";
	  
	  
      System.out.println("-----------------------------------------------------------------");
     System.out.println(menu);
   }
}
	
