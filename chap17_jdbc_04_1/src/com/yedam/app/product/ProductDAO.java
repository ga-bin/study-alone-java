package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// 재고 업데이트
	public void updateStock(Product product) {
		try {
			connection();
			String sql = "UPDATE products SET product_stock = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductStock());
			pstmt.setInt(2, product.getProductId());
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 업데이트 되었습니다.");
			} else {
				System.out.println("정상적으로 업데이트되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	
	// 이름, 가격 업데이트
	public void updateInfo(Product product) {
		try {
			connection();
			String sql = "UPDATE products SET product_name = ?, product_price = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductId());
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
	
	// 삭제
	public void delete(int productId) {
		try {
			connection();
			String sql = "DELETE FROM products WHERE product_id = " + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			}  else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	
	// 단건조회
	public Product selectOne(String productName) {
		Product product = null;
		try {
			connection();
			String sql = "SELECT * FROM products WHERE product_name = " + productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
			
		}
		return product;
	}
	
	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT * FROM products ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				
				list.add(product);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		
		return list;
	}
}
