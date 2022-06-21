package com.yedam.app.product;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {
	// 싱글톤
	private static ProductDAO productDAO = null;
	
	private ProductDAO() {
		
	};
	
	public static ProductDAO getInstance() {
		if (productDAO == null) {
		productDAO = new ProductDAO();
	}
		return productDAO;
	}
	
	
	public void insert(Product product) {
		try {
			connection();
			String sql = "INSERT INTO product (product_id, prouduct_name, product_price) VALUES (product_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 업데이트 되었습니다.");
			} else {
				System.out.println("정상적으로 업데이트 되지 않았습니다.");
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	
	public void updateStock(Product product) {
		try {
			connection();
			String sql = "UPDATE products SET product_stock = ?, WHERE productId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductStock());
			pstmt.setInt(2, product.getProductId());
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
}
